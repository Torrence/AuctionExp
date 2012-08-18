package nju.edu.auctionExp.service;

import java.util.List;

import nju.edu.auctionExp.dao.ParticipantDAO;
import nju.edu.auctionExp.model.Participant;

public interface ParticipantManager {
	
	
	/**
	 * Generate identifier based on the parameter studentId, and insert
	 * the Participant's information. When the participant sign in, the
	 * system should first check whether he/she has signed or not.  
	 * @param name
	 * @param studentId
	 * @param labNo
	 */
	public void signIn(Participant participant);
	
	/**
	 * generate identifier based on the studentId input.
	 * @param studentId
	 * @return: identifier
	 */
	public String generateId(String studentId);
	
	public void saveParticipant(Participant participant);
	
	public List<Participant> findAll();
	
	public Participant findByIdentifier(String identifier);
	
	public boolean participantExist(String studentId);
	
	public void deleteByIdentifier(String identifier);
	
	public String getConditionGroupIdByNum(int num);
	
	/**
	 * @param hql
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<Participant> findByHql(String hql, int firstResult, int maxResult);
	
	public ParticipantDAO getParticipantDAO();
	
	public void deleteByHQL(String hql);
	
}
