package com.we.controller;

import com.github.pagehelper.PageInfo;
import com.we.model.User;
import com.we.utils.ResultVOUtil;
import com.we.vo.ResultVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

	protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
		Map<String, Object> rspData = new HashMap<>();
		rspData.put("rows", pageInfo.getList());
		rspData.put("total", pageInfo.getTotal());
		return rspData;
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	protected User getCurrentUser() {
		return (User) getSubject().getPrincipal();
	}

	protected Session getSession() {
		return getSubject().getSession();
	}

	protected Session getSession(Boolean flag) {
		return getSubject().getSession(flag);
	}

	protected void login(AuthenticationToken token) {
		getSubject().login(token);
	}
	/**
	 * 权限异常
	 */
	@ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
	public ResultVO authorizationException(HttpServletRequest request, HttpServletResponse response) {

		return ResultVOUtil.warn("-998", "没有权限");

	}

}
