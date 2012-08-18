<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="header">
	<div class="span-4">
		<img alt="" src='<s:url value="/images/bid.jpg" />' width="100" height="100">
	</div>
	<s:if test="#session.IDENTIFIER != null">
		<h2 class="span-6 info" style="margin-top:10px;">
			(My Identifier:<s:property value="#session.IDENTIFIER"/>)
		</h2>
	</s:if>
	<hr>
</div>