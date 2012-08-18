package nju.edu.auctionExp.dao;

import static org.junit.Assert.*;

import java.util.List;

import nju.edu.auctionExp.model.Item;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemDAOTest {
	
	private ItemDAO dao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao-hibernate.xml");
		this.dao = (ItemDAO)context.getBean("ItemDAO");
	}

	@Test
	public void testInitDao() {
		this.dao.initDao();
		return;
	}

	@Test
	public void testSave() {
		// call the constructor with id, title, and imageUrl.
		Item item = new Item("0", "Title1", "C:/image.jpg");
		this.dao.save(item);
	}

	@Test
	public void testDelete() {
		Item item = new Item("0", "Title1", "C:/image.jpg");
		this.dao.delete(item);
	}

	@Test
	public void testFindById() {
		Item item = this.dao.findById("0");
	}

	@Test
	public void testFindByExample() {
		Item item = new Item("Title1", "C:/image.jpg");
		this.dao.findByExample(item);
	}

	@Test
	public void testFindByProperty() {
		List<Item> item = this.dao.findByProperty("id", "0");
	}

	@Test
	public void testFindAll() {
		List<Item> item = this.dao.findAll();
	}

}
