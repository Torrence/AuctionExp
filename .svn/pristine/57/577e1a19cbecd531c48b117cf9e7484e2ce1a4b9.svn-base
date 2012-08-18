<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="User Profile" />
	<tiles:putAttribute name="content">
		<fieldset>
		
			<legend>Assign Groups(7,8,9 round)</legend>
			<form method="post" action='<s:url action="findConditionGroups" namespace="/groupAssignment" />'>
            	<div>
            		<label for="dummy6">Please input the total groups you expect: </label>
            	</div>
            	<hr>
            	<div style="text-align:center">
	            	<input type="text" name="groupNum" style="height:25px" size="1" id="num" value="" autofocus=true>
	            	<br>
	            	<input type="submit" style="width:60px; height:32px" class="groupButton" value="Send">
          		</div>
          	</form>
          </fieldset>
	</tiles:putAttribute>
</tiles:insertTemplate>