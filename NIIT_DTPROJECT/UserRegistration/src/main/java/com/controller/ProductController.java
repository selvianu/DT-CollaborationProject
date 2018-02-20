package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dt.dao.CategoryDao;
import com.dt.dao.ProductDao;
import com.dt.dao.SupplierDao;
import com.dt.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = { "/saveproduct" })
	public String saveProduct(@ModelAttribute("pro") Product product) {
		productDao.insertProduct(product);
		MultipartFile image = product.getImage();
		String imagepath = request.getServletContext().getRealPath("/resource/images");
		System.out.println("---------Directory:-------" + imagepath);
		Path path = Paths.get(imagepath + File.separator + product.getPid() + ".jpg");
		System.out.println("-------Path:-----" + path.toString());

		try {
			image.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return "redirect:/productlist";
	}

	@RequestMapping(value = { "/productlist" })
	public String showAllProduct(Model model) {
		List<Product> product = productDao.getAllProducts();
		model.addAttribute("product", product);
		return "productlist";
	}

	@RequestMapping(value = "/admin/deleteProduct/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		productDao.deleteProduct(pid);
		return "redirect:/productlist";
	}

	@RequestMapping(value = { "/all/product/viewProduct/{pid}" })
	public String viewProduct(@PathVariable int pid, Model model) {
		Product product = productDao.getProductById(pid);
		model.addAttribute("product", product);
		return "viewproduct";
	}

	@RequestMapping(value = { "/admin/product/editform/{pid}" })
	public String editForm(@PathVariable int pid, Model model) {
		model.addAttribute("category", categoryDao.getAllCategories());
		model.addAttribute("supplier", supplierDao.getAllSuppliers());
		Product product = productDao.getProductById(pid);
		model.addAttribute("products", product);
		return "updateproduct";
	}

	@RequestMapping(value = { "/all/product/updateproduct" })
	public String updateSupplier(@ModelAttribute("products") Product product) {
		productDao.updateProduct(product);
		return "redirect:/productlist";
	}

	@RequestMapping(value = { "/returns" })
	public String backToProducts() {
		System.out.println("Back to Product List");
		// Product product = productDao.getProductById(pid);
		// model.addAttribute("product", product);
		return "productlist";
	}

	@RequestMapping(value = { "/returns2" })
	public String backToHome() {
		System.out.println("Back to Home");
		// Product product = productDao.getProductById(pid);
		// model.addAttribute("product", product);
		return "home";
	}
}
