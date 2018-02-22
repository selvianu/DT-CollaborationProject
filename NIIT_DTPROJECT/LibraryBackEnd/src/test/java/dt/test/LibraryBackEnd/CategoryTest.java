package dt.test.LibraryBackEnd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dt.dao.CategoryDao;
import com.dt.model.Category;

public class CategoryTest {
	static CategoryDao categorydao;
	static Category category;

	@BeforeClass
	public static void setup() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.dt");
		configApplnContext.refresh();

		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");

		categorydao = (CategoryDao) configApplnContext.getBean("categoryDao");
		category = new Category();
	}

	/*
	 * @Test public void addCategoryTest() { category.setCid(2);
	 * category.setCname("Bed Time Stories");
	 * assertTrue(categorydao.addCategory(category)); }
	 */

	/*
	 * @Ignore
	 * 
	 * @Test public void retrieveCategoryTest() { List<Category> clist =
	 * categorydao.retrieveCategory(); assertNotNull(clist); this.show(clist); }
	 * 
	 * public void show(List<Category> listCategory) { for (Category category :
	 * listCategory) { System.out.println("Category ID:" + category.getCid());
	 * System.out.println("Category Name:" + category.getCname()); } }
	 */
	/*
	 * @Ignore
	 * 
	 * @Test public void getCategoryTest() { Category category2 =
	 * categorydao.getCategory(1); assertNotNull("prbm in getting data" +
	 * category2); System.out.println(category.getCid());
	 * System.out.println(category.getCname()); }
	 */

	/*
	 * @Test public void deleteCategoryTest() { category.setCid(10);
	 * assertTrue(categorydao.deleteCategory(category)); }
	 */

	@Ignore

	@Test
	public void updateCategoryTest() {
		category.setCid(1);
		category.setCname("Bed Time Stories");
		// assertTrue(categorydao.updateCategory(category));
	}

}
