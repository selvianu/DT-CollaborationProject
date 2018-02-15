package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dt.dao.CategoryDao;
import com.dt.dao.CategoryDaoImpl;
import com.dt.dao.ProductDao;
import com.dt.dao.ProductDaoImpl;
import com.dt.dao.SupplierDao;
import com.dt.dao.SupplierDaoImpl;
import com.dt.dao.UserDao;
import com.dt.dao.UserDaoImpl;
import com.dt.model.Category;
import com.dt.model.Product;
import com.dt.model.Supplier;
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

	@Autowired
	private SupplierDao supplierDao;

	@RequestMapping("/goToLogin")
	public String goToLoginPage() {
		return "login";
	}

	@RequestMapping("/userLogged")
	public String userLogged() {
		return "redirect:/index";
	}

	@RequestMapping("/error")
	public String userLogged1() {
		return "error";
	}

	@RequestMapping(value = { "/", "/home" })
	public String showMessage(Model model) {
		System.out.println("in controller");
		model.addAttribute("category", categoryDao.retrieveCategory());
		return "index";
	}

	@RequestMapping("/addcategory")
	public String AddCategory(Model model, HttpServletRequest req) {
		Category cat = new Category();
		Product p = new Product();
		cat.setCid(Integer.parseInt(req.getParameter("selectCategory")));
		p.setCategory(cat);
		model.addAttribute("category", categoryDao.retrieveCategory());
		return "catList";
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public ModelAndView saveSupplierData(@RequestParam("sid") Integer sid, @RequestParam("sname") String sname) {
		ModelAndView mv = new ModelAndView();
		Supplier s = new Supplier();
		s.setSid(sid);
		s.setSupplierName(sname);
		supplierDao.insertSupplier(s);
		return mv;
	}

}
