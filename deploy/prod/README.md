# 生产环境部署说明

生产环境参考 `zy_qy` 的模式，使用云效 Flow 构建镜像并部署到 ACK/Kubernetes。

## 服务清单

- `rf-mng`：管理端后端，镜像由 `deploy/prod/aliyun-pipeline-rf-mng-backend.yaml` 构建。
- `rf-performance`：员工绩效后端，镜像由 `deploy/prod/aliyun-pipeline-rf-performance-backend.yaml` 构建。
- `rf-mng-node`：管理端前端，镜像由 `deploy/prod/aliyun-pipeline-rf-mng-node.yaml` 构建。
- `rf-h5-node`：员工绩效 H5，镜像由 `deploy/prod/aliyun-pipeline-rf-h5-node.yaml` 构建。

## 云效变量

四条流水线均需要配置：

- `ACR_REGISTRY`：阿里云镜像仓库地址，例如 `xxx.cn-hangzhou.cr.aliyuncs.com`。
- `ACR_NAMESPACE`：镜像命名空间。
- `CR_USER_NAME`：镜像仓库用户名。
- `CR_PWD`：镜像仓库密码。

流水线 YAML 中还包含以下占位符，需要在导入云效后替换：

- `RF_CODEUP_ENDPOINT_PLACEHOLDER`
- `RF_CODEUP_SERVICE_CONNECTION_PLACEHOLDER`
- `RF_YUNXIAO_RUNNER_GROUP_PLACEHOLDER`
- `RF_ACK_CLUSTER_PLACEHOLDER`

## ACK 预置资源

ACK/K8s 基础资源复用 `zy_qy`：

- 命名空间：`prod`
- 镜像拉取：`acr-secret`
- Nacos Config 入口：`qy-backend-nacos-config`
- 配置密文解密密钥：`qy-backend-config-crypto-secret`

`rf-mng` 和 `rf-performance` 的本地 `application.properties` 只保留启动引导配置，真实配置按 `zy_qy` 的两层结构放入 Nacos：

1. `common-backend-prod.properties`：后端公共基础设施配置。
2. `${spring.application.name}-prod.properties`：项目自己的配置。

生产需要在 Nacos 创建：

| Data ID | 说明 | 样例 |
| --- | --- | --- |
| `common-backend-prod.properties` | Dubbo、XXL-JOB 等公共配置 | `backend/docs/config/common-backend-prod.properties` |
| `rf-mng-prod.properties` | 管理端后端数据库、Cookie、tax-browser-worker 配置 | `backend/docs/config/rf-mng-prod.properties` |
| `rf-performance-prod.properties` | 员工绩效后端数据库、短信、验证码、XXL-JOB 执行器配置 | `backend/docs/config/rf-performance-prod.properties` |

敏感值使用 `SM4_密文`，解密密钥复用 `zy_qy` 的 `QY_CONFIG_CRYPTO_SECRET_KEY` 注入方式，不再为 rf 单独创建数据库、短信、Cookie 等 K8s Secret。

## 路由建议

- 管理端前端 `rf-mng-node` 暴露给后台域名。
- 员工端 H5 `rf-h5-node` 暴露给公众号菜单域名或路径。
- `rf-mng-node` 的 `/api/` 代理到 `rf-mng`。
- `rf-h5-node` 的 `/api/performance/h5/` 代理到 `rf-performance`。

## 注意事项

- `rf-performance` 生产配置需要在 `rf-performance-prod.properties` 中设置：
  - `rf.performance.h5.auth.mock-enabled=false`
  - `rf.performance.h5.auth.captcha-enabled=true`
- XXL-JOB 需要在调度中心配置执行器 `rf-performance`，并添加任务 handler：`employeePerformanceAutoConfirmJob`。
- 数据库拆分为 `rf_pt` 和 `rf_robot`：平台业务表放入 `rf_pt`，tax-browser-worker 与 rf-mng 交互的税务机器人表放入 `rf_robot`。
- 生产上线前需要在 `rf_pt` 执行 `backend/services/rf-mng/sql/rf_pt/20260622_platform_admin.sql`、`backend/services/rf-performance/sql/20260621_employee_performance.sql` 和 `backend/services/rf-mng/sql/rf_pt/20260615_social_security_payment_management.sql`。
- 生产上线前需要在 `rf_robot` 执行 qy_robot 税务机器人表结构。
