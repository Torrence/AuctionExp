package nju.edu.auctionExp.common.json;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class JSONResult implements Result {
	/**
	 * 
	 */
	private static final long serialVersionUID = 987690849419734258L;
	public static final String DEFAULT_PARAM = "classAlias";
	private String classAlias;
	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		ServletActionContext.getResponse().setContentType("text/plain");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter responseStream =
		ServletActionContext.getResponse().getWriter();
		ValueStack valueStack = invocation.getStack();
		Object jsonModel = valueStack.findValue("jsonModel");
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		if ( classAlias == null ){
			classAlias = "object";
		}
		if(jsonModel==null) return;
		xstream.alias(classAlias, jsonModel.getClass() );
		responseStream.println(xstream.toXML( jsonModel ));
	}
	public void setClassAlias(String classAlias) {
		this.classAlias = classAlias;
	}
	public String getClassAlias() {
		return classAlias;
	}
}
