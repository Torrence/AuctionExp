<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="sign in successfully" />
	<tiles:putAttribute name="content">
		<script type="text/javascript">
		  		$(document).ready(function(){
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
			  		$('#continue-auction').live('click',function(event){
			  			event.preventDefault();
			  			checkAvailableAuction();
			  		});
		  		});
  		</script>
  		<h1>
	    	Welcome <s:property value="participant.identifier" />! 
		</h1>
		<div style="font-size: 14px;">
			<p>
				We will conduct an auction in which you will have the opportunity to win a product that will be displayed to you shortly. We will provide you with $10 so that you can use the money to make your bids. In a moment, you will be asked to indicate the <strong>most</strong> you are willing to pay (if anything) to purchase the product by writing bids via this website. The auction will proceed as follows:</p>
			<p style="margin-left:36.0pt;">
				(1)&nbsp;&nbsp; You will see the picture of the product on the next webpage. On this webpage, you will write the <strong>most</strong> you are willing to pay for the product. Please note that your bid is private information and should not be shared with anyone.</p>
			<p style="margin-left:36.0pt;">
				(2)&nbsp;&nbsp; After all of you finish writing your bids, bids will be ranked from highest to lowest. The person with the highest bid will win the auction and pay the <strong>second highest</strong> bid amount for the product.</p>
			<p style="margin-left:36.0pt;">
				(3)&nbsp;&nbsp; The website will show you the winning price and whether you win the auction or not.</p>
			<p style="margin-left:36.0pt;">
				(4)&nbsp;&nbsp; After showing the winning price, we will re-conduct the auction for two additional rounds.</p>
			<p style="margin-left:36.0pt;">
				(5)&nbsp;&nbsp; After the completion of the additional rounds, we will randomly draw a number 1 through 3 to determine the binding round. For example, if we randomly draw the number 2, then we will ignore outcomes in round 1 and 3 and only focus on the winning bidder and price in round 2. It is important to note that all rounds have an equally likely chance of being binding. &nbsp;</p>
			<p style="margin-left:36.0pt;">
				(6)&nbsp;&nbsp; Once the binding round has been determined, the winning bidder will pay the second highest bid amount and receive the product. Other participants do not get the product.</p>
			<p>
				Important notes</p>
			<ul>
				<li>
					<strong>The auction is not hypothetical</strong>: the winning bidder <strong>will actually pay money</strong> to obtain the product. You may submit a bid greater than $10.00 if you think the product is worth more than $10.00 to you. If the winning price (that is, the second highest bid) is higher than $10.00, the winning bidder will have to use his or her own money to pay the part beyond $10.00.</li>
				<li>
					In this auction, <strong>the best strategy is to bid exactly what the product is worth to you</strong>. Consider the following: if you bid more than the product is worth to you, you may end up having to buy the product for more than you really want to pay. Conversely, if you bid less than the product is really worth to you, you may end up not winning the auction even though you could have bought the product at a price you were actually willing to pay. Thus, you best strategy is to bid exactly what the product is worth to you.</li>
			</ul>
			<p>
				We will first give you an exercise to practice. Please click on the &ldquo;Continue&rdquo; button when you are ready to take the exercise.</p>
        	<p>
        		<a class="right button" id="continue-auction" href='javascript:void(0);'>Continue</a>
        	</p>
        </div>
        <hr/>
	</tiles:putAttribute>
</tiles:insertTemplate>
