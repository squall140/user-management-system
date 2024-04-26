package org.ums.api.controller.system;

import io.swagger.annotations.ApiOperation;
import org.ums.common.controller.BaseController;
import org.ums.common.domain.AjaxResult;
import org.ums.common.domain.model.RegisterBody;
import org.ums.common.utils.StringUtils;
import org.ums.framework.web.service.SysRegisterService;
import org.ums.admin.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册验证
 * 
 * @author ruoyi
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("User registration does not support now.");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }

    @PostMapping("/emailVerificationLink")
    @ApiOperation(value = "activate email", notes = "user registration")
    public AjaxResult emailVerificationLink(String email) throws Exception {
        // TODO:
        return null;
    }
}
