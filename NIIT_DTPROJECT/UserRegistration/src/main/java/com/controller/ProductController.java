package com.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dt.dao.CategoryDao;
import com.dt.dao.ProductDao;
import com.dt.dao.SupplierDao;
import com.dt.dao.UserDao;
import com.dt.model.Category;
import com.dt.model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SupplierDao supplierDao;

	/*
	 * @RequestMapping("/addproduct") public String AddProduct(Model model) {
	 * System.out.println("Product Controller"); return "addproduct"; }
	 */

	@RequestMapping("/showProductDetails")
	public String showProducts() {
		System.out.println("show products - Product Controller");
		return "/showProducts";
	}

	@RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
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
		// cat.setCid(Integer.parseInt(req.getParameter("selectCategory")));
		// p.setCategory(cat);

		String filepath = req.getSession().getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();
		p.setImgName(filename);
		productDao.addProduct(p);
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "addProduct";
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
		System.out.println("product - security added");
		return "index";
	}

	@RequestMapping(value = "/showProducts")
	public String listAllProducts(Model m) {
		System.out.println("to show product - List");
		List<Product> listProducts = productDao.getAllProducts();
		m.addAttribute("productList", listProducts);
		/*
		 * for (Product product : listProducts) {
		 * System.out.println(product.getPname()); }
		 */
		return "showProducts";
	}

	@RequestMapping(value = "/admin/deleteProduct/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		System.out.println("to delect specified product by id");
		productDao.deleteProduct(pid);
		return "redirect:/showProducts";
	}

	@RequestMapping(value = { "/all/product/viewProduct/{pid}" })
	public String viewProduct(@PathVariable int pid, Model model) {
		System.out.println("to view specified product by id");
		Product product = productDao.getProduct(pid);
		model.addAttribute("product", product);
		return "viewProduct";
	}

	@RequestMapping(value = "/showCategory")
	public String listAllCategory(Model m) {
		System.out.println("product list");
		System.out.println("to show product - List");
		List<Category> listCategory = categoryDao.getAllCategory();
		m.addAttribute("categoryList", listCategory);
		for (Category category : listCategory) {
			System.out.println(category.getCname());
		}
		return "catList";
	}

	@RequestMapping(value = "/showCategoryByPid")
	public String ProductsByPid(Model m, @RequestParam("pid") int pid) {
		System.out.println("product list");
		System.out.println("to show product - List");
		List<Category> listCategoryByPid = productDao.getProductBypid(pid);
		m.addAttribute("productListById", listCategoryByPid);
		for (Category category : listCategoryByPid) {
			System.out.println(category.getCname());
		}
		return "catList";
	}

	@RequestMapping(value = { "/all/product/updateProduct/{pid}" })
	public String editForm(@PathVariable int pid, Model model) {
		model.addAttribute("cat", categoryDao.getAllCategory());
		// model.addAttribute("supp", supplierDao.getAllSuppliers());
		Product product = productDao.getProduct(pid);
		model.addAttribute("products", product);
		return "updateProduct";
	}

	/*
	 * @RequestMapping(value = "/showProducts", method = RequestMethod.POST) public
	 * String showPdt(@ModelAttribute("SpringWeb") Product pdt, ModelMap model) {
	 * model.addAttribute("name", pdt.getPname()); model.addAttribute("desc",
	 * pdt.getDesc()); // model.addAttribute("id", student.getId()); return
	 * "result"; }
	 */

}
