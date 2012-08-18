package nju.edu.auctionExp.dao;

import static org.junit.Assert.*;

import java.util.List;

import nju.edu.auctionExp.model.Participant;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParticipantDAOTest {
	private ParticipantDAO dao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao-hibernate.xml");
		this.dao = (ParticipantDAO)context.getBean("ParticipantDAO");
	}

	@Test
	public void testInitDao() {
		this.dao.initDao();
	}

	@Test
	public void testSave() {
		Participant participant = new Participant(null, "88888888", "88888888", "labNo");
		this.dao.save(participant);
	}

	@Test
	public void testDelete() {
		Participant participant = new Participant("identifier", "name", "studentId", "labNo");
		this.dao.delete(participant);
	}

	@Test
	public void testFindById() {
		List<Participant> participantList = this.dao.findByProperty("identifier", "identifier");
	}

	@Test
	public void testFindByExample() {
		Participant participant = new Participant("identifier", "name", "studentId", "labNo");
		List<Participant> participantList = this.dao.findByExample(participant);
	}

	@Test
	public void testFindAll() {
		List<Participant> participantList = this.dao.findAll();
	}

}
