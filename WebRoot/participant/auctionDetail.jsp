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
	  				if(floatReg.test(bidPrice)){
	  					document.bidForm.submit();
	  				}else{
	  					alert('Please enter a number with two decimals');
	  				}
	  			});
	  			var timer;
	  			$('#show-reviews').live('click',function(){
	  				popupReview();
	  				$('.auction-reivew:first').show();
	  				timer = setTimeout(function(){
	  					$('#next-review').show();
	  				}, 6000);
		  		});
	  			$('#next-review').live('click',function(){
	  				$('.auction-reivew:first').remove();
	  				if($('.auction-reivew').size()<1){
  						$('#auction-reviews-dialog').dialog('close');
  						//clearInterval(timer);
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
			<s:if test="auction != null">
			<form name="bidForm" action='<s:url action="placeBid" namespace="/participant" />' method="post">
				<input type="hidden" name="auctionBid.auction.round" value='<s:property value="auction.round" />' />
				<fieldset>
					<legend>Submit your bid</legend>
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
						<div class="tips">
							<p class="quiet" style="font-size: 14px;">
								Write down the <b>most</b> you are willing to pay for the product. Please enter a number with two decimal places.
							</p>
						</div>
						<div class="span-8">
							<div class="space"></div>
							<div class="bid-price-field">
								<input type="text" name="auctionBid.bidPrice" id="bid-price" size="5"/>
								<input type="button" id="place-bid" value="Place Bid" />
							</div>
						</div>
					</div>
				</fieldset>
			</form>
			</s:if>
			<s:else>
				<h1>
					The new auction has not started yet, please 
					<a href='<s:url action="getAuctionDetail" namespace="/participant" />'>TRY</a> later.
				</h1>
			</s:else>
		</div>
	</tiles:putAttribute>
</tiles:insertTemplate>
