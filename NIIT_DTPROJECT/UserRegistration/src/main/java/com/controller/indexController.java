package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	@RequestMapping(value = { "/", "/home" })
	public String showMessage(Model model) {
		System.out.println("in controller");
		model.addAttribute("category", categoryDao.retrieveCategory());
		return "index";
	}

	@RequestMapping("/login")
	public String Login() {
		return "signin";
	}

	@RequestMapping("/addcategory")
	public String AddCategory(Model model, HttpServletRequest req) {
		Category cat = new Category();
		Product p = new Product();
		cat.setCid(Integer.parseInt(req.getParameter("selectCategory")));
		p.setCategory(cat);
		model.addAttribute("category", categoryDao.retrieveCategory());
		return "addcategory";
	}

	@RequestMapping("/addproduct")
	public String AddProduct(Model model) {
		return "addproduct";
	}

	@RequestMapping("/showProductDetails")
	public String showProducts() {
		System.out.println("show products");
		return "/showProducts";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public ModelAndView saveCategoryData(@RequestParam("cname") String cname) {

		ModelAndView mv = new ModelAndView();
		Category c = new Category();
		c.setCname(cname);
		categoryDao.addCategory(c);
		mv.addObject(c);
		// categoryDaoImpl.addCategory(c);
		System.out.println("category added");
		return mv;

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

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest req, RedirectAttributes redirectAttributes,
			@RequestParam("imgName") MultipartFile file, Model model) {
		Product p = new Product();
		System.out.println("in controller");
		model.addAttribute("category", categoryDao.retrieveCategory());
		String UPLOADED_FOLDER = "C:\\Users\\selvi\\Pictures\\DT-images";
		p.setPname(req.getParameter("pname"));
		p.setDesc(req.getParameter("desc"));
		// Float pprice = Float.parseFloat("price");
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		p.setStockAvailable(Integer.parseInt(req.getParameter("stockAvailable")));
		Category cat = new Category();
		cat.setCid(Integer.parseInt(req.getParameter("selectCategory")));
		p.setCategory(cat);

		String filepath = req.getSession().getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();
		p.setImgName(filename);
		productDao.addProduct(p);
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "addproduct";
		}
		// productDaoImpl.addProduct(p);
		try {
			byte[] imagebytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, imagebytes);
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return "addproduct";
	}

	/*
	 * @RequestMapping(value = "/showProducts") public String showProducts1(Model m)
	 * { System.out.println("to show product - List"); List<Product> listProducts =
	 * productDao.retrieveProducts(); m.addAttribute("productList", listProducts);
	 * return "index"; }
	 */
	@RequestMapping(value = "/showProducts")
	public String listAllProducts(Model m) {
		System.out.println("product list");
		System.out.println("to show product - List");
		List<Product> listProducts = productDao.getAllProducts();
		m.addAttribute("productList", listProducts);
		for (Product product : listProducts) {
			System.out.println(product.getPname());
			
			
		}
		return "showProducts";
	}

	@RequestMapping(value = "/showProducts", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Product pdt, ModelMap model) {
		model.addAttribute("name", pdt.getPname());
		model.addAttribute("desc", pdt.getDesc());
		// model.addAttribute("id", student.getId());
		return "result";
	}

	@RequestMapping(value = "/registrationController", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password1") String password1,
			@RequestParam("password2") String password2, @RequestParam("email") String email,
			@RequestParam("dob") Date dob, @ModelAttribute("user") User user, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, IOException {
		ModelAndView mv = new ModelAndView();
		user.setUsername(username);
		user.setPassword1(password1);
		user.setPassword2(password2);
		user.setEmail(email);
		user.setDob(dob);
		user.setRole("role_user");
		if (password1.equals(password2)) {
			userDao.addUser(user);
			System.out.println(username + " added");
		} else {
			res.sendRedirect("passwordincorect");
		}
		res.sendRedirect("register");
		return mv;
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
