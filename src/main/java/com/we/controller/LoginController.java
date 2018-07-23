package com.we.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.model.User;
import com.we.service.UserService;
import com.we.utils.MD5Utils;
import com.we.utils.QueryRequestUtils;
import com.we.utils.ResultVOUtil;
import com.we.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResultVO login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("rememberMe") Boolean rememberMe) {


        password = MD5Utils.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            super.login(token);
            this.userService.updateLoginTime(username);
            return ResultVOUtil.success("1", "登录成功");
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return ResultVOUtil.error("0", e.getMessage());
        } catch (AuthenticationException e) {
            return ResultVOUtil.error("0", "认证失败");
        }
    }


    @RequestMapping("/checkLogin")
    public ResultVO<User> checkLogin() {
        return ResultVOUtil.warn("0", "请登录");
    }

}
