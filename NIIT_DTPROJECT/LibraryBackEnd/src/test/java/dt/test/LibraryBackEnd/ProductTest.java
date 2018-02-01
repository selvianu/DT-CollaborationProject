package dt.test.LibraryBackEnd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dt.dao.ProductDao;
import com.dt.model.Product;

public class ProductTest {

	static ProductDao productdao;
	static Product product;

	@BeforeClass
	public static void setup() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.dt");
		configApplnContext.refresh();
		productdao = (ProductDao) configApplnContext.getBean("productDao");
		product = new Product();
	}

	/*@Test
	public void addProductTest() {
		product.setPid(10);
		product.setPname("CD");
		product.setPrice(150);
		product.setAvailable(2);
		product.setcId(1);
		product.setSupplierId(101);
		assertTrue(productdao.addProduct(product));
	}*/
/*	
	@Test
	public void getProductTest() {
		Product pdt = productdao.getProduct(10);
		assertNotNull("prbm in getting data" + pdt);
		System.out.println(pdt.getAvailable());
		System.out.println(pdt.getPname());
		System.out.println(pdt.getPrice());
		System.out.println(pdt.getSupplierId());
	}*/
	
}
