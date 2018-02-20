package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.dao.CategoryDao;
import com.dt.dao.SupplierDao;
import com.dt.dao.UserDao;
import com.dt.model.Category;
import com.dt.model.Product;
import com.dt.model.Supplier;
import com.dt.model.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SupplierDao supplierDao;

	@RequestMapping(value = { "/register" })
	public String registerPage(Model model) {
		model.addAttribute("supp", new Supplier());
		model.addAttribute("pro", new Product());
		model.addAttribute("cat", new Category());
		model.addAttribute("category", categoryDao.getAllCategories());
		model.addAttribute("supplier", supplierDao.getAllSuppliers());
		model.addAttribute("user", new User());
		return "register";
	}

	/*@RequestMapping("/userLogged")
	public String check() {
		return "home";
	}*/

	@RequestMapping(value = "/login")
	public String loginPage(@RequestParam(required = false) boolean Login, Model model) {
		if (Login == false) {
			model.addAttribute("error", "login failed");
		} else {
			model.addAttribute("error", null);
		}
		return "Login";
	}

	@RequestMapping(value = { "/saveregister" })
	public String saveRegister(@ModelAttribute("user") User user) {
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		userDao.insertValues(user);
		System.out.println("user information gets inserted");
		return "Login";
	}

}
