package nju.edu.auctionExp.dao;

import static org.junit.Assert.*;

import java.util.List;

import nju.edu.auctionExp.model.Auction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuctionDAOTest {
	private AuctionDAO dao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao-hibernate.xml");
		this.dao = (AuctionDAO)context.getBean("AuctionDAO");
	}

	@Test
	public void testInitDao() {
		this.dao.initDao();
	}

	@Test
	public void testSave() {
		Auction auction = new Auction();
		this.dao.save(auction);
	}

	@Test
	public void testDelete() {
		Auction auction = new Auction();
		this.dao.delete(auction);
	}

	@Test
	public void testFindByIdInteger() {
		List<Auction> auctoin = this.dao.findByProperty("round", 1);
	}

	@Test
	public void testFindByExample() {
		Auction auction = new Auction();
		this.dao.findByExample(auction);
	}

	@Test
	public void testFindByProperty() {
		List<Auction> auctoin = this.dao.findByProperty("round", 1);
	}

	@Test
	public void testFindAll() {
		List<Auction> auctoin = this.dao.findByHQL("from Auction", 0, 1);
		assertTrue(auctoin.size()>0);
	}

}
