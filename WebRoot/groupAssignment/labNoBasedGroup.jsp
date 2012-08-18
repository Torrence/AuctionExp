<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="Setup Groups" />
	<tiles:putAttribute name="content">
		<script type="text/javascript">
	  		
	  	</script>
	  	
		<fieldset>
		
			<legend>Round-1, 2, and 3</legend>
	           <table>
		          <caption><em>Preview of group-assignment</em></caption>
		          <thead>
		            <tr>
		              <th class="span-1" style="text-align:center;">Lab Number</th>
		              <th class="span-1" style="text-align:center;">Corresponding Participants</th>
		            </tr>
		          </thead>
		          <tbody>
		          	<s:iterator value="labGroup.keySet()" id="id">
		          		<s:iterator value="labGroup.get(#id)">
		        			<tr>
		        			  <td style="text-align:center;"><s:property value="id"/></td>
		        			  <td style="text-align:center;"><s:property value="labGroup.get(#id)"/></td>
				            </tr>
		        		</s:iterator>
		          	</s:iterator>
		          </tbody>
	          </table>
	      
		</fieldset>
	</tiles:putAttribute>
</tiles:insertTemplate>