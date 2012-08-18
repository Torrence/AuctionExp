package nju.edu.auctionExp.action;

import java.util.Map;

import nju.edu.auctionExp.common.constant.SessionKeys;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Base struts action that provides session, cookie service
 * @author hamsongliu
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5227780830147273651L;
	private Object jsonModel;
	
	/**
	 * get system session
	 * @return
	 */
	public Map<String, Object> getSession(){
		return ActionContext.getContext().getSession();
	}
	
	/**
	 * @return
	 */
	public String getIdentifier(){
		return getSession().get(SessionKeys.IDENTIFIER)==null? null : getSession().get(SessionKeys.IDENTIFIER).toString();
	}

	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
	}

	public Object getJsonModel() {
		return jsonModel;
	}

}
