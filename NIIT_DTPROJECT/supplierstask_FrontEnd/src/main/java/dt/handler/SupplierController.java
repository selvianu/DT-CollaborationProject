package dt.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dt.dao.SupplierDao;
import dt.model.Supplier;

@Controller

public class SupplierController {
	@Autowired
	private SupplierDao supplierDao;

	@RequestMapping(value = { "/", "/home" })
	public String showMessage() {
		System.out.println("in controller");
		return "index";
	}

	@RequestMapping("/insertsupplier")
	public String AddProduct() {
		System.out.println("supplier added");
		return "insertsupplier";
	}

	@RequestMapping(value = "/insertsupplier", method = RequestMethod.POST)
	public String addcategory(@RequestParam("supplierName") String supplierName) {
		System.out.println(supplierName);
		Supplier sup = new Supplier();
		sup.setSupplierName(supplierName);
		supplierDao.insertSupplier(sup);
		return "insertsupplier";
	}

	@RequestMapping("/deletesupplier")
	public String DeleteSupplier() {
		System.out.println("supplier deleted");
		return "deletesupplier";
	}

	@RequestMapping(value = "/deletesupplier", method = RequestMethod.POST)
	public String DeleteSupplier(@RequestParam("sid") int sid) {
		System.out.println(sid);
		Supplier sup = new Supplier();

		sup.setSid(sid);
		supplierDao.deleteSupplier(sup);
		System.out.println("Supplier Removed");
		return "deletesupplier";
	}

	@RequestMapping("/updatesupplier")
	public String updatesupplier() {
		System.out.println("supplier updated");
		return "updatesupplier";
	}

	@RequestMapping(value = "/updatesupplier", method = RequestMethod.POST)
	public String updatesupplier(@RequestParam("sid") int sid, @RequestParam("supplierName") String supplierName) {
		System.out.println(sid);
		Supplier sup = new Supplier();
		sup.setSupplierName(supplierName);
		supplierDao.updateSupplier(sup);
		System.out.println("Supplier Updated");
		return "updatesupplier";
	}

}
