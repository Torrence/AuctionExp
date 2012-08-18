<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="Randomize Participants" />
	<tiles:putAttribute name="content">
	
	<script type="text/javascript">
	  		$(document).ready(function(){
	  			$('#group_sort').live('click',function(){
 					
	  			});
	  		});
	  	</script>
		<fieldset>
			<legend>Participant & The Corresponding Condition Group</legend>
	          <table>
		          <caption><em>Participant Detailed Information(total: <s:property value="participantList.size()"/>)</em></caption>
		          <thead>
		            <tr>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="participant"></s:param><s:param name="queryParticipantsOrderBy">participant.identifier</s:param></s:url>'>Identifier</a>
		              </th>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="participant"></s:param><s:param name="queryParticipantsOrderBy">participant.name</s:param></s:url>'>Name</a>
		              </th>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="participant"></s:param><s:param name="queryParticipantsOrderBy">participant.studentId</s:param></s:url>'>Student ID</a>
		              </th>
		              <th class="span-1">
						<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="participant"></s:param><s:param name="queryParticipantsOrderBy">participant.labNo</s:param></s:url>'>Lab No</a>
		              </th>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="conditionGroup"></s:param><s:param name="queryParticipantsOrderBy">conditionGroup.id</s:param></s:url>'>Condition Group</a>
		              </th>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="conditionGroup"></s:param><s:param name="queryParticipantsOrderBy">conditionGroup.averageRating</s:param></s:url>'>Average Rating</a>
		              </th>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="conditionGroup"></s:param><s:param name="queryParticipantsOrderBy">conditionGroup.reviewCount</s:param></s:url>'>Review Count</a>
		              </th>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="conditionGroup"></s:param><s:param name="queryParticipantsOrderBy">conditionGroup.overview</s:param></s:url>'>Show Overview</a>
		              </th>
		              <th class="span-1">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="participant">participant</s:param><s:param name="queryParticipantsOrderBy">participant.batch</s:param></s:url>'>Batch Serial</a>
		              </th>
		              <th class="span-1 last">
		              	<a href='<s:url action="getTheParticipants" namespace="/groupAssignment"><s:param name="orderObject" value="conditionGroup"></s:param><s:param name="queryParticipantsOrderBy">conditionGroup.distinctReviewOrder</s:param></s:url>'>Distinct Review Order</a>
		              </th>
		            </tr>
		          </thead>
		          
		          <tbody id="body"> 
	        		<s:iterator id="participant" value="participantList">
	        			<tr id='review-<s:property value="identifier" />' >
	        			  <td><s:property value="identifier" /></td>
			              <td><s:property value="name" /></td>
			              <td><s:property value="studentId" /></td>
			              <td><s:property value="labNo" /></td>
			              <td><s:property value="conditionGroup.id" /></td>
			              <td><s:property value="conditionGroup.averageRating" /></td>
			              <td><s:property value="conditionGroup.reviewCount" /></td>
			              <s:if test="%{conditionGroup.overview == ''}">
		          				<td>No overview</td>
		          		  </s:if>
		          		  <s:if test="%{conditionGroup.overview != ''}">
		          				<td>Has overview</td>
		          		  </s:if>
		          		  <td><s:property value="batch" /></td>
		          		  <s:if test="%{conditionGroup.distinctReviewOrder == 1}">
		          				<td>Begin</td>
		          		  </s:if>
		          		  <s:if test="%{conditionGroup.distinctReviewOrder == 2}">
		          				<td>Middle</td>
		          		  </s:if>
		          		  <s:if test="%{conditionGroup.distinctReviewOrder == 3}">
		          				<td>End</td>
		          		  </s:if>
			            </tr>
	        		</s:iterator>
		          </tbody>
	          </table>
	          
		</fieldset>
	</tiles:putAttribute>
</tiles:insertTemplate>
