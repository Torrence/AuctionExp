<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="Preview Result" />
	<tiles:putAttribute name="content">
		<script type="text/javascript">
	  		$(document).ready(function(){
	  		});
	  	</script>
	  	<div id="view-auction-result">
	  		<input type="hidden" value='<s:property value="auction.round" />' name="auction.round" />
			<fieldset>
				<legend>Preview Auction Result: Round <s:property value="auction.round" /></legend>
				<table id="auction-bid-list">
					<caption>Preview Result of Round <s:property value="auction.round" />(total: <s:property value="auctionBidList.size()"/>, winners with green background)</caption>
					<thead>
						<tr>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.identifier</s:param></s:url>'>Identifier</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.name</s:param></s:url>'>Name</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.studentId</s:param></s:url>'>Student ID</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.labNo</s:param></s:url>'>Lab</a>
							</th>
							<s:if test="auction.round>6">
								<th>
									<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">auctionGroup</s:param></s:url>'>Auction Group</a>
								</th>
							</s:if>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.conditionGroup.id</s:param></s:url>'>Condition Group</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.conditionGroup.reviewCount</s:param></s:url>'>Reviews</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.conditionGroup.averageRating</s:param></s:url>'>Average Rating</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.conditionGroup.overview</s:param></s:url>'>OverView</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">participant.conditionGroup.distinctReviewOrder</s:param></s:url>'>Distinct Review</a>
							</th>
							<th>
								<a href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="auction.round"/><s:param name="queryAuctionBidorderBy">bidPrice</s:param></s:url>'>Price</a>
							</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="auctionBidList">
							<tr <s:if test="auction.status==2&&bidPrice>getFinalPrice(auction.round,participant.labNo,participant.conditionGroup.id)">class="winner"</s:if>>
								<td>
									<s:property value="participant.identifier"/>
								</td>
								<td>
									<s:property value="participant.name"/>
								</td>
								<td>
									<s:property value="participant.studentId"/>
								</td>
								<td>
									<s:property value="participant.labNo"/>
								</td>
								<s:if test="auction.round>6">
									<td>
										<s:property value="participant.conditionGroup.auctionGroup"/>
									</td>
								</s:if>
								<td>
									<s:property value="participant.conditionGroup.id"/>
								</td>
								<td>
									<s:property value="participant.conditionGroup.reviewCount"/>
								</td>
								<td>
									<s:property value="participant.conditionGroup.averageRating"/>
								</td>
								<td>
									<s:if test="participant.conditionGroup.overview==null||participant.conditionGroup.overview.equals('')">
										off
									</s:if>
									<s:else>
										on
									</s:else>
								</td>
								<td>
									<s:if test="participant.conditionGroup.distinctReviewOrder==1">
										top
									</s:if>
									<s:elseif test="participant.conditionGroup.distinctReviewOrder==2">
										middle
									</s:elseif>
									<s:else>
										end
									</s:else>
								</td>
								<td>
									<s:if test="bidPrice>0">
										<s:property value="bidPrice"/>
									</s:if>
									<s:else>
										--
									</s:else>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertTemplate>