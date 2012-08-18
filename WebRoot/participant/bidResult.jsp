<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="Bid the Auction" />
	<tiles:putAttribute name="content">
		<script type="text/javascript">
	  		$(document).ready(function(){
	  			var popupReview = function(){
	  				$('#auction-reviews-dialog').dialog({
	  					autoOpen: true,
	  					modal: true,
	  					closeOnEscape: false,
	  					open: function() { $(".ui-dialog-titlebar-close").hide(); },
	  					width: 600,
	  					height: 400
	  				});
	  			};
	  			$('#place-bid').live('click',function(){
	  				var bidPrice = $('input[name="auctionBid.bidPrice"]').val();
	  				var floatReg = /^[1-9]d*.d*|0.d*[1-9]d*$/;
	  				if(floatReg.test(bidPrice) && parseFloat(bidPrice)>0){
	  					document.bidForm.submit();
	  				}else{
	  					alert('Please enter a number with two decimals');
	  				}
	  			});
	  			$('#show-bid-history').live('click',function(){
	  				$("#bid-history-grid").show();
	  				$(this).hide();
	  			});
	  			
	  			var checkAvailableAuction = function(){
	  			//Check if there is available auction
	  				$.ajax({
		  				  type: 'POST',
		  				  url: '<s:url action="checkAvailableAuction" namespace="/participant" />',
		  				  data: {
		  				  },
		  				  success: function(data){
		  					  if(data.boolean == true){
		  						  window.location = '<s:url action="getAuctionDetail" namespace="/participant" />';
		  					  }else{
		  						  alert('New auction has not started, please wait until informed to continue!');
		  					  }
		  				  },
		  				  dataType: 'json'
		  				});
	  			};
	  			
	  			var timer;
	  			$('#continue-auction').live('click',function(event){
	  				event.preventDefault();
	  				//if in 6th round, popup reviews
	  				var round  = $('input[name="auction.round"]').val();
	  				if(round == '6' && $('.auction-reivew').size()>0){
	  					popupReview();
		  				$('.auction-reivew:first').show();
		  				timer = setTimeout(function(){
		  					$('#next-review').show();
		  				}, 6000);
	  				}else{
	  					checkAvailableAuction();
	  				}
	  			});
	  			
	  			$('#next-review').live('click',function(){
	  				$('.auction-reivew:first').remove();
	  				if($('.auction-reivew').size()<1){
  						$('#auction-reviews-dialog').dialog('close');
  						//checkAvailableAuction();
  					}else{
  						$('.auction-reivew:first').show();
  					}
	  				$(this).hide();
	  				timer = setTimeout(function(){
	  					$('#next-review').show();
	  				}, 6000);
	  			});
	  		});
	  	</script>
		<div id="auction-detail" >
			<input type="hidden" name="auction.round" value='<s:property value="auction.round" />' />
			<fieldset>
				<legend>Bid Review</legend>
				<div class="space"></div>
				<div class="span-20">
					<h2 id="auction-title">
						<s:property value="auction.item.title" />
					</h2>
				</div>
				<div class="span-20">
					<div class="span-8">
						<s:if test="auction.item==null||auction.item.imageUrl==null||auction.item.imageUrl.equals('')">
							<img src='<s:url value="/images/no-pre.png" />' width="300px" height="300px" />
						</s:if>
						<s:else>
							<img alt='' src='<s:url value="/uploadfiles/" /><s:property value="auction.item.imageUrl" />' width="300px" height="300px" />
						</s:else>
					</div>
					<div class="span-8">
						<div class="space"></div>
						<div>
							<h2>My Bid:<s:property value="auctionBid.bidPrice" /></h2>
						</div>
						<div class="info">
							<s:if test="reBidFlag">
								You have bid for one time, do not repeat bid.
							</s:if>
							<s:if test="auction.status!=2">
								(Bid result currently not available)
							</s:if>
							<s:else>
								<s:if test="getFinalPrice(auction.round)>auctionBid.bidPrice">
									(BID RESULT: LOSE)
								</s:if>
								<s:else>
									(BID RESULT: WIN)
								</s:else>
							</s:else>
						</div>
					</div>
				</div>
			</fieldset>
			<h3><a href="javascript:void(0);" id="show-bid-history">Show Bid History</a></h3>
			<table id="bid-history-grid" style="display: none;">
				<caption>Bid History</caption>
		          <thead>
		            <tr>
		              <th class="span-1">Round</th>
		              <th class="span-2">My Bid</th>
		              <th class="span-4">Bid Result</th>
		            </tr>
		          </thead>
		          <tbody>
		          	<s:iterator value="bidHistoryList">
		          		<tr>
		          			<td>
		          				<s:property value="auction.round"/>
		          			</td>
		          			<td>
		          				<s:property value="bidPrice"/>
		          			</td>
		          			<td>
		          				<s:set name="finalPrice" value="getFinalPrice(auction.round)"></s:set>
		          				<s:if test="#finalPrice<0">
									NOT AVAILABLE
								</s:if>
								<s:elseif test="#finalPrice<bidPrice">
									WIN
								</s:elseif>
								<s:else>
									FAIL
								</s:else>
		          			</td>
		          		</tr>
		          	</s:iterator>
		          	<tr>
		          	</tr>
		          </tbody>
			</table>
			<h1><a id="continue-auction" href='javascript:void(0);'>Continue</a></h1>
			<div title='Reviews of <s:property value="auction.item.title" />' id="auction-reviews-dialog" style="display:none;">
				<s:iterator value="conditionGroup.reviewList">
					<div class="auction-reivew" style="display: none;">
						<div class="space"></div>
						<div class="rating">
							<h3>Rating:<s:property value="rating"/></h3>
						</div>
						<hr>
						<div class="review-title">
							<h4>
								<s:property value="author"/>:
								<s:property value="summary"/>
							</h4>
						</div>
						<div class="space"></div>
						<div class="review-content">
							<s:property value="content"/>
						</div>
					</div>
				</s:iterator>
				<hr>
				<s:if test="conditionGroup.overview!=null">
					<div class="review-overview">
						<h4>Overview</h4>
						<s:property value="conditionGroup.overview"/>
					</div>
				</s:if>
				<input type="button" id="next-review" value="NEXT" style="display:none;">
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertTemplate>
