package com.rf.mng.provider.interfaces.socialsecurity;

import com.rf.mng.provider.application.command.socialsecurity.config.SocialSecurityEnterpriseSaveCommand;
import com.rf.mng.provider.application.command.socialsecurity.config.SocialSecurityRegionSiteSaveCommand;
import com.rf.mng.provider.application.manager.socialsecurity.config.SocialSecurityConfigManager;
import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityEnterpriseQuery;
import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityRegionSiteQuery;
import com.rf.mng.provider.application.result.socialsecurity.config.SocialSecurityEnterpriseResult;
import com.rf.mng.provider.application.result.socialsecurity.config.SocialSecurityRegionSiteResult;
import com.rf.mng.provider.common.auth.MngModule;
import com.rf.mng.provider.common.auth.MngPermission;
import com.rf.mng.provider.interfaces.socialsecurity.param.config.SocialSecurityEnterpriseSaveCtrlParam;
import com.rf.mng.provider.interfaces.socialsecurity.param.config.SocialSecurityRegionSiteSaveCtrlParam;
import com.zy.common.core.bo.PageResp;
import com.zy.common.core.bo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 社保缴费配置管理接口。
 */
@RestController
@RequestMapping("/api/social-security-config")
@MngPermission(MngModule.SOCIAL_SECURITY)
public class SocialSecurityConfigController {

    /** 社保缴费配置管理器。 */
    @Resource
    private SocialSecurityConfigManager socialSecurityConfigManager;

    /** 分页查询企业配置。 */
    @GetMapping("/enterprises")
    public Result<PageResp<SocialSecurityEnterpriseResult>> pageEnterprise(SocialSecurityEnterpriseQuery query) {
        return Result.success(socialSecurityConfigManager.pageEnterprise(query));
    }

    /** 保存企业配置。 */
    @PostMapping("/enterprises")
    public Result<SocialSecurityEnterpriseResult> saveEnterprise(@RequestBody SocialSecurityEnterpriseSaveCtrlParam param) {
        SocialSecurityEnterpriseSaveCommand command = new SocialSecurityEnterpriseSaveCommand();
        BeanUtils.copyProperties(param, command);
        return Result.success(socialSecurityConfigManager.saveEnterprise(command));
    }

    /** 删除企业配置。 */
    @PostMapping("/enterprises/{id}/delete")
    public Result<Void> deleteEnterprise(@PathVariable Long id) {
        socialSecurityConfigManager.deleteEnterprise(id);
        return Result.success();
    }

    /** 分页查询地区站点配置。 */
    @GetMapping("/region-sites")
    public Result<PageResp<SocialSecurityRegionSiteResult>> pageRegionSite(SocialSecurityRegionSiteQuery query) {
        return Result.success(socialSecurityConfigManager.pageRegionSite(query));
    }

    /** 保存地区站点配置。 */
    @PostMapping("/region-sites")
    public Result<SocialSecurityRegionSiteResult> saveRegionSite(@RequestBody SocialSecurityRegionSiteSaveCtrlParam param) {
        SocialSecurityRegionSiteSaveCommand command = new SocialSecurityRegionSiteSaveCommand();
        BeanUtils.copyProperties(param, command);
        return Result.success(socialSecurityConfigManager.saveRegionSite(command));
    }

    /** 删除地区站点配置。 */
    @PostMapping("/region-sites/{id}/delete")
    public Result<Void> deleteRegionSite(@PathVariable Long id) {
        socialSecurityConfigManager.deleteRegionSite(id);
        return Result.success();
    }
}
