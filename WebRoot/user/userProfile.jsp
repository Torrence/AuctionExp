<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="User Profile" />
	<tiles:putAttribute name="content">
		<h3>
	    	<s:property value="user.name" />'s profile
	    </h3>
	</tiles:putAttribute>
</tiles:insertTemplate>