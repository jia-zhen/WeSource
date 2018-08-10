package com.we.controller;

import com.we.model.User;
import com.we.service.UserService;
import com.we.utils.MD5Utils;
import com.we.utils.ResultVOUtil;
import com.we.vo.ResultVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResultVO login(@RequestBody  User user) {

        Map<String,String> map=new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        String password = MD5Utils.encrypt(user.getUsername().toLowerCase(), user.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), password);
        try {
            subject.login(token);
            this.userService.updateLoginTime(user.getUsername());
            String sessionId = (String) subject.getSession().getId();
            map.put("sessionId",sessionId);
            return ResultVOUtil.success("1", "登录成功",map);
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
