package nju.edu.auctionExp.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuctionGroupDAOTest {
	private AuctionGroupDAO dao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao-hibernate.xml");
		this.dao = (AuctionGroupDAO)context.getBean("AuctionGroupDAO");
	}

	@Test
	public void testFindByHQL() {
		assertTrue(dao.findByHQL("from AuctionGroup where groupSerial = 3", 0, 1).size()>0);
	}

}
