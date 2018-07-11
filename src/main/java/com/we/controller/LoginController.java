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
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;



	@RequestMapping("/login")
	public ResultVO<User> checkUserName(String username, String password) {

		return ResultVOUtil.success();
	}



	@RequestMapping("/checkLogin")
	public ResultVO<User> checkLogin() {
		return ResultVOUtil.warn("0","请登录");
	}

}
