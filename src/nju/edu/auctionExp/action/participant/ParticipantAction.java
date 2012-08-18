package nju.edu.auctionExp.action.participant;

import com.opensymphony.xwork2.Action;

import nju.edu.auctionExp.action.BaseAction;
import nju.edu.auctionExp.common.constant.SessionKeys;
import nju.edu.auctionExp.model.Participant;
import nju.edu.auctionExp.service.ParticipantManager;

public class ParticipantAction extends BaseAction {

	private static final long serialVersionUID = 4508750866082650479L;
	
	private ParticipantManager participantManager;
	private Participant participant;
	
	/**
	 * participants sign in
	 * @return
	 */
	public String signIn(){
		if(participant == null){
			return Action.INPUT;
		}
		participantManager.signIn(this.participant);
		getSession().put(SessionKeys.IDENTIFIER, participant.getIdentifier());
		return Action.SUCCESS;
	}

	public void setParticipantManager(ParticipantManager participantManager) {
		this.participantManager = participantManager;
	}

	public ParticipantManager getParticipantManager() {
		return participantManager;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Participant getParticipant() {
		return participant;
	}


}
