package com.we.controller;

import com.we.model.User;
import com.we.service.UserService;
import com.we.service.impl.UserServiceImpl;
import com.we.utils.DateUtil;
import com.we.utils.ResultVOUtil;
import com.we.vo.ResultVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册",notes = "用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",value="用户名",dataType = "String",required = true,paramType = "path"),
            @ApiImplicitParam(name="password",value="密码",required = true,paramType = "path")
    })
    @RequestMapping("/register")
    public ResultVO register(@RequestBody User user){
        logger.debug("用户注册");
        user.setCrateTime(DateUtil.getDateTime());
        userService.register(user);
        logger.debug("注册成功");
        return ResultVOUtil.success(0,"注册成功");
    }




}
