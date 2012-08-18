<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="Setup Auction" />
	<tiles:putAttribute name="content">
		<script type="text/javascript">
	  		$(document).ready(function(){
	  			$('#round').live('change',function(){
	  				var round = $(this).val();
	  				var auctionType = $('#auctionType').val();
	  				window.location = '<s:url action="calculateWinners" namespace="/auction" />?auction.round='+round+'&auctionType='+auctionType;
	  			});
	  			$('#auctionType').live('change',function(){
	  				var auctionType = $(this).val();
	  				var round = $('#round').val();
	  				window.location = '<s:url action="calculateWinners" namespace="/auction" />?auction.round='+round+'&auctionType='+auctionType;
	  			});
	  			var stopAuction = function(round){
	  				$.ajax({
		  				  type: 'POST',
		  				  url: '<s:url action="stopAuction" namespace="/auction" />',
		  				  data: {
		  					  'auction.round':round
		  				  },
		  				  success: function(){alert('Auction Stoped');$('#stop-autcion').attr('disabled','disabled');},
		  				  dataType: 'json'
		  				});
	  			};
	  			$('#stop-autcion').live('click',function(){
	  				var round = $('input[name="auction.round"]').val();
	  				stopAuction(round);
	  			});
	  		});
	  	</script>
	  	<div id="view-auction-result">
	  		<input type="hidden" value='<s:property value="auction.round" />' name="auction.round" />
			<fieldset>
				<legend>View Auction Result</legend>
				<div>
					<div class="span-4">
						<label for="round">Auction Round:</label>
						<select id="round" name="round">
							<s:iterator value="auctionList" status="status">
								<option value='<s:property value="round" />' <s:if test="round==auction.round">selected</s:if>>
									<s:property value="round" />
								</option>
							</s:iterator>
						</select>
					</div>
					<div class="span-6">
						<label for="auctionType">Auction Type:</label>
						<select id="auctionType" name="auctionType" <s:if test="auction.status==2">disabled</s:if>>
							<option value="SECOND_PRICE" <s:if test="auctionType.toString().equals('SECOND_PRICE')">selected</s:if>>SECOND_PRICE</option>
							<option value="RANDOM_PRICE" <s:if test="auctionType.toString().equals('RANDOM_PRICE')">selected</s:if>>RANDOM_PRICE</option>
						</select>
					</div>
					<div class="span-4">
						Auction Status:
						<span id="auction-status" class="info">
							<s:if test="auction.status==0">Ready</s:if>
							<s:elseif test="auction.status==1">Started</s:elseif>
							<s:else>Finished</s:else>
						</span>
					</div>
					<div class="span-3">
						<input type="button" value="Stop Auction" id="stop-autcion" <s:if test="auction.status==2">disabled</s:if> />
					</div>
				</div>
				<hr>
				<p>
					<label for="title">Title</label>
					<br>
					<input type="hidden" name="item.id" value='<s:property value="auction.item.id" />' />
					<input type="text" name="item.title" id="title" value='<s:property value="auction.item.title" />' size="80" />
				</p>
				<p>
					<label for="preview">Preview</label>
					<br>
					<input type="hidden" name="item.imageUrl" value='<s:property value="auction.item.imageUrl" />' />
					<s:if test="auction.item==null||auction.item.imageUrl==null||auction.item.imageUrl.equals('')">
						<img src='<s:url value="/images/no-pre.png" />' width="300px" height="300px" />
					</s:if>
					<s:else>
						<img alt='' src='<s:url value="/uploadfiles/" /><s:property value="auction.item.imageUrl" />' width="300px" height="300px" />
					</s:else>
				</p>
				<div id="group-winners">
					<h1>Winner(s) in each group</h1>
					<s:iterator value="auctionGroupList" status="Status" var="auctionGroup">
						<div>
							<h2>Group <s:property value="#Status.index+1" /></h2>
							<s:if test="auction.round>6">
								<table>
									<caption><em>Participants with below conditions were grouped to determine winner(s)</em></caption>
									<thead>
							            <tr>
							              <th class="span-1">Review Count</th>
							              <th class="span-1">Average Review Rating</th>
							              <th class="span-1">Distinct Review Order</th>
							              <th class="span-1">Overview</th>
							            </tr>
							        </thead>
									<tbody>
										<s:iterator value="conditionGroupList">
											<tr>
												<td><s:property value="reviewCount" /></td>
												<td><s:property value="averageRating" /></td>
												<td><s:property value="distinctReviewOrder" /></td>
												<td><s:if test="overview!=null&&!overview.equals('')">ON</s:if><s:else>OFF</s:else></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</s:if>
							<table>
								<caption><em>
									<s:if test="auction.round>0 && auction.round <4">
										Calculate winner(s) by all participants
										(Final Price:<s:property value="#auctionGroup.groupPrice"/>, Total Bids: <s:property value="totalBids"/>)
									</s:if>
									<s:elseif test="auction.round<7">
										Calculate winner(s) by lab:<s:property value="conditionGroupIds"/>
										(Final Price:<s:property value="#auctionGroup.groupPrice"/> Total Bids: <s:property value="totalBids"/>)
									</s:elseif>
									<s:else>
										(Final Price:<s:property value="#auctionGroup.groupPrice"/> Total Bids: <s:property value="totalBids"/>)
									</s:else>
								</em></caption>
								<thead>
						            <tr>
						              <th class="span-1" style="background-color: white;">Participant Bid</th>
						              <th class="span-1" style="background-color: white;">Winner Identifier</th>
						            </tr>
						        </thead>
						        <tbody>
						        	<s:iterator value="#auctionGroup.winnerBids">
						        		<tr>
						        			<td>
						        				<s:property value="bidPrice"/>
						        			</td>
						        			<td>
						        				<s:property value="identifier"/>
						        			</td>
						        		</tr>
						        	</s:iterator>
						        </tbody>
							</table>
							<hr color="red" />
						</div>
					</s:iterator>
				</div>
			</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertTemplate>