package com.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.dao.CategoryDao;
import com.dt.dao.ProductDao;
import com.dt.dao.UserDao;
import com.dt.dao.UserDaoImpl;
import com.dt.model.Category;
import com.dt.model.Product;
import com.dt.model.User;

/**
 * Servlet implementation class indexController
 */
@Controller
public class indexController {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = { "/", "/home" })
	public String showMessage() {
		System.out.println("in controller");

		return "index";
	}

	@RequestMapping("/signin")
	public String Login() {
		return "signin";
	}

	@RequestMapping("/addcategory")
	public String AddCategory() {
		return "addcategory";
	}

	@RequestMapping("/addproduct")
	public String AddProduct() {
		return "addproduct";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addcategory(@RequestParam("cname") String cname, Model model) {
		System.out.println(cname);
		Category cty = new Category();
		cty.setCname(cname);
		categoryDao.addCategory(cty);
		return "addcategory";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addproduct(@RequestParam("price") Integer price, @RequestParam("available") Integer available,
			@RequestParam("cId") Integer cId, @RequestParam("supplierId") Integer supplierId,
			@RequestParam("pname") String pname, Model model) {
		System.out.println(pname);
		Product pdt = new Product();
		pdt.setPname(pname);
		pdt.setPrice(price);
		pdt.setAvailable(available);
		pdt.setSupplierId(supplierId);
		pdt.setcId(cId);
		productDao.addProduct(pdt);
		return "addproduct";
	}

	@RequestMapping(value = "/registrationController", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("password1") String password1,
			@RequestParam("password2") String password2, @RequestParam("email") String email,
			@RequestParam("dob") Date dob) throws ClassNotFoundException, SQLException {
		User user = new User();
		user.setUsername(username);
		user.setPassword1(password1);
		user.setPassword2(password2);
		user.setEmail(email);
		user.setDob(dob);
		if (password1.equals(password2)) {
			userDao.addUser(user);
			System.out.println(username + " added");
		} else {
			return "passwordincorect";
		}
		return "register";
	}

	@RequestMapping(value = "/signInCtrl", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) throws ClassNotFoundException, SQLException {
		User user2 = userDao.getUser(username);
		if ((user2.getUsername().equals(username)) && (user2.getPassword1().equals(password))) {
			System.out.println(user2.getUsername() + "Uufser Page");
			return "loginSuccess";
		} else if (username.equals("admin") && (password.equals("admin"))) {
			System.out.println("Admin Page");
			return "loginSuccess";
		} else {
			return "loginFailure";
		}

	}
}
