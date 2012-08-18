package nju.edu.auctionExp.model;

import java.util.Date;

/**
 * Participant entity. @author MyEclipse Persistence Tools
 */

public class Participant implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -334800843420153998L;
	private String identifier;
	private String name;
	private String studentId;
	private String labNo;
	private ConditionGroup conditionGroup;
	private Date signInTime;
	private String batch;

	// Constructors

	/** default constructor */
	public Participant() {
	}
	
	public Participant(String identifier) {
		this.identifier = identifier;
	}

	/** minimal constructor */
	public Participant(String identifier, String name, String studentId,
			String labNo) {
		this.identifier = identifier;
		this.name = name;
		this.studentId = studentId;
		this.labNo = labNo;
	}

	// Property accessors

	public String getIdentifier() {
		return this.identifier;
	}
	
	public void setIdentifier(Object identifier) {
		this.identifier = String.valueOf(identifier);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getLabNo() {
		return this.labNo;
	}

	public void setLabNo(String labNo) {
		this.labNo = labNo;
	}

	public void setConditionGroup(ConditionGroup conditionGroup) {
		this.conditionGroup = conditionGroup;
	}

	public ConditionGroup getConditionGroup() {
		return conditionGroup;
	}

	public Date getSignInTime() {
		return signInTime;
	}

	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

}