package com.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.dao.UserDao;
import com.dt.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/registrationController", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("password1") String password1,
			@RequestParam("password2") String password2, @RequestParam("email") String email,
			@RequestParam("dob") Date dob, ModelMap model, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("registration contoller");
		User user = new User();
		user.setUsername(username);
		user.setPassword1(password1);
		user.setPassword2(password2);
		user.setEmail(email);
		user.setDob(dob);
		user.setRole("role_user");
		user.setEnabled(true);
		if (password1.equals(password2)) {
			userDao.addUser(user);
			System.out.println(username + " added");
		} else {
			System.out.println("password mismatch");
			// res.sendRedirect("passwordincorect");
		}
		// res.sendRedirect("register");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) throws ClassNotFoundException, SQLException {
		System.out.println("user Controller");
		User user2 = userDao.getUser(username);
		System.out.println(user2.getUsername());
		if (user2.getPassword1().equals(password)) {
			System.out.println(user2.getUsername() + "User Page");
		}
		return "login";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String login(ModelMap model, Principal principal) {
		//System.out.println("principal name" + principal.getName());
		// String name = principal.getName();
		System.out.println("spring security login");
		// model.addAttribute("username", name);
		model.addAttribute("username");
		// model.addAttribute("spring security");
		return "index";

	}

	@RequestMapping(value = "/login")
	public String loginPage(@RequestParam(required = false) boolean Login, Model model) {
		if (Login == false) {
			model.addAttribute("error", "login failed");
		} else {
			model.addAttribute("error", null);
		}
		return "login";
	}
}
