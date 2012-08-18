package nju.edu.auctionExp.action;

import java.util.Map;

import nju.edu.auctionExp.common.constant.SessionKeys;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * sign interceptor
	 */
	private static final long serialVersionUID = -2055983191240726063L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map<String, Object> session = ai.getInvocationContext().getSession();
		String identifier = (String) session.get(SessionKeys.IDENTIFIER);
		if(null != identifier){
			return ai.invoke();
		}else{
			return Action.ERROR;
		}
	}
}
