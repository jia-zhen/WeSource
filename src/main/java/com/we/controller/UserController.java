package com.we.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.model.User;
import com.we.reqModel.ReqUser;
import com.we.service.UserService;
import com.we.utils.MD5Utils;
import com.we.utils.QueryRequestUtils;
import com.we.utils.ResultVOUtil;
import com.we.vo.ResultVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.juli.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * 引入日志，注意都是"org.slf4j"包下
	 */
	private final static Logger log = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private UserService userService;

	private static final String ON = "on";


	@RequestMapping("/checkUserName")
	public boolean checkUserName(String username, String oldusername) {
		if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
			return true;
		}
		User result = this.userService.findByName(username);
		return result == null;
	}

	@RequestMapping("/getUser")
	public ResultVO<User> getUser( @RequestBody User user) {
		try {
			User userResult = userService.selectByPrimaryKey(user.getUserId());
			return ResultVOUtil.success("1","获取用户信息成功",userResult);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultVOUtil.error("0","获取用户信息失败，请联系网站管理员！");
		}
	}
//	@ApiOperation(value="获取用户列表", notes="获取用户列表")
//	@RequestMapping("/list")
//	public ResultVO<User> userList(QueryRequestUtils request, User user) {
//		PageHelper.startPage(request.getPageNum(), request.getPageSize());
//		List<User> list = userService.(user);
//		PageInfo<User> pageInfo = new PageInfo<>(list);
//		return ResultVOUtil.success("1","分页查询用户信息成功",getDataTable(pageInfo));
//	}



	@PostMapping("/regist")
	public ResultVO<User> regist(@RequestBody User user) {
		try {
			User result = this.userService.findByName(user.getUsername());
			if (result != null) {
				return ResultVOUtil.warn("2","该用户名已被使用！");
			}
			this.userService.registUser(user);
			return ResultVOUtil.success("1","注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultVOUtil.error("0","注册失败，请联系网站管理员！");
		}
	}




	@RequiresPermissions("user:add")
	@RequestMapping("/add")
	public ResultVO<User> addUser(User user, Long[] roles) {
		try {
			if (ON.equalsIgnoreCase(user.getStatus()))
				user.setStatus(User.STATUS_VALID);
			else
				user.setStatus(User.STATUS_LOCK);
			this.userService.addUser(user, roles);
			return ResultVOUtil.success("1","新增用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultVOUtil.error("0","新增用户失败，请联系网站管理员！");
		}
	}


	@RequiresPermissions("user:update")
	@RequestMapping("/update")
	public ResultVO<User> updateUser(@RequestBody ReqUser reqUser) {
		User user=new User();
		BeanUtils.copyProperties(reqUser,user);
		try {
			if (ON.equalsIgnoreCase(reqUser.getStatus()))
				user.setStatus(User.STATUS_VALID);
			else
				user.setStatus(User.STATUS_LOCK);
			String [] roles=reqUser.getRoles().split(",");
			Long[] rolesL= (Long[]) ConvertUtils.convert(roles,Long.class);
			this.userService.updateUser(user, rolesL);
			return ResultVOUtil.success( "1","修改用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultVOUtil.error("0","修改用户失败，请联系网站管理员！");
		}
	}

	@ApiOperation(value="删除用户", notes="根据id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequiresPermissions("user:delete")
	@RequestMapping("/delete")
	public ResultVO<User> deleteUsers(String ids) {
		try {
			this.userService.deleteUsers(ids);
			return ResultVOUtil.success("1","删除用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultVOUtil.error("0","删除用户失败，请联系网站管理员！");
		}
	}

	@RequestMapping("/checkPassword")
	public boolean checkPassword(String password) {
		User user = getCurrentUser();
		String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
		return user.getPassword().equals(encrypt);
	}

	@RequestMapping("/updatePassword")
	public ResultVO<User> updatePassword(@RequestBody  String newPassword) {
		try {
			this.userService.updatePassword(newPassword);
			return ResultVOUtil.success("1","更改密码成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultVOUtil.error("0","更改密码失败，请联系网站管理员！");
		}
	}

	@RequestMapping("/unauth")
	public ResultVO<User> checkLogin() {
		return ResultVOUtil.warn("0", "没有权限");
	}

}
