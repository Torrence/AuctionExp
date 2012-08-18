package nju.edu.auctionExp.dao;

import static org.junit.Assert.*;

import java.util.List;

import nju.edu.auctionExp.model.Review;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReviewDAOTest {
	private ReviewDAO dao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao-hibernate.xml");
		dao = (ReviewDAO)context.getBean("ReviewDAO");
	}

	@Test
	public void testInitDao() {
		this.dao.initDao();
	}

	@Test
	public void testSave() {
		Review review = new Review("0", 2, "Rod", "useability",
				"content");
		this.dao.save(review);
	}
	
	@Test
	public void testSaveId() {
		Review review = new Review("0");
		this.dao.save(review);
	}

	@Test
	public void testDelete() {
		Review review = new Review("0", 2, "Rod", "useability",
		"content");
		this.dao.delete(review);
	}

	@Test
	public void testFindById() {
		Review review = this.dao.findById("0");
	}

	@Test
	public void testFindByExample() {
		Review review = new Review("0", 2, "Rod", "useability",
		"content");
		List<Review> reviewList = this.dao.findByExample(review);
	}

	@Test
	public void testFindAll() {
		List<Review> reviewList = this.dao.findAll();
	}

}
