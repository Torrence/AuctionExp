<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="User Profile" />
	<tiles:putAttribute name="content">
		<fieldset>
			<legend>Set Up Reviews</legend>
	          <s:iterator value="groupedReview.keySet()" id="id">
	          <table>
	          <caption><em>Set up <s:property value="#id.substring(0,2)" /> reviews with average rating of <s:property value="#id.substring(2,3)" /></em></caption>
	          <thead>
	            <tr>
	              <th class="span-1">Rating</th>
	              <th class="span-1">Author</th>
	              <th class="span-4">Summary</th>
	              <th class="span-4">Content</th>
	              <th class="span-1 last">Operation</th>
	            </tr>
	          </thead>
	          <tbody id='review-group-<s:property value="#id" />'>
        		<s:iterator value="groupedReview.get(#id)">
        			<tr id='review-<s:property value="id" />' >
        			  <td><input type="text" size="1" value='<s:property value="rating" />' name="rating"></td>
		              <td><input type="text" size="10" value='<s:property value="author" />' name="author"></td>
		              <td><input type="text" size="30" value='<s:property value="summary" />' name="summary"></td>
		              <td><textarea name="content" style="height:45px;"><s:property value="content" /></textarea></td>
		              <td><input type="button" value="save" class="save-review" data-id='<s:property value="id" />'></td>
		            </tr>
        		</s:iterator>
	          </tbody>
	          </table>
	          </s:iterator>
		</fieldset>
	</tiles:putAttribute>
</tiles:insertTemplate>