package com.open.shiro.dynamic.permissions.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.open.shiro.dynamic.permissions.annotation.CurrentUser;
import com.open.shiro.dynamic.permissions.entity.Resource;
import com.open.shiro.dynamic.permissions.entity.User;
import com.open.shiro.dynamic.permissions.service.ResourceService;
import com.open.shiro.dynamic.permissions.service.UserService;

/**
 * 
 * The class IndexController.
 *
 * Description: 
 *
 * @author: liuheng
 * @since: 2016年1月8日	
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
@Controller
public class IndexController {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(@CurrentUser User loginUser, Model model) {
		Set<String> permissions = userService.findPermissions(loginUser.getUsername());
		List<Resource> menus = resourceService.findMenus(permissions);
		model.addAttribute("menus", menus);
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
