<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
    <title>Consent</title>
	<link rel="stylesheet" href="<%=basePath %>css/blueprint/screen.css" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="<%=basePath %>css/blueprint/print.css" type="text/css" media="print">
    <!--[if lt IE 8]><link rel="stylesheet" href="<%=basePath %>css/blueprint/ie.css" type="text/css" media="screen, projection"><![endif]-->
  	<script type="text/javascript" src="<%=basePath %>/js/jquery-1.7.2.min.js"></script>
  	<script type="text/javascript">
  		$(document).ready(function(){
  		});
  	</script>
  </head>
  
  <body>
  	<div class="container">
  		<div id="header">
  			<div class="span-4">
				<img alt="" src='images/bid.jpg' width="100" height="100">
			</div>
  			<hr>
  		</div>
  		<div class="content">
  			<fieldset>
  				<legend>Consent</legend>
  				<div style="font-size: 14px;">
	  				<p>
						<p>
							Dear Student,</p>
						<p align="left">
							I am a professor in the Department of Information Systems at City University of Hong Kong. I invite you to participate in a research study that examines how consumers participate in online auctions (e.g., auctions on ebay.com).</p>
						<p>
							Your participation will involve making bids for an eco-friendly alarm clock in an auction conducted on the study website. The experiment should only take about 1 hour. Your involvement in the study is voluntary, and you may choose not to participate or to stop at any time without penalty or loss of benefits to which you are otherwise entitled. Your participation in the study is confidential. We will collect your student ID only for the purpose of awarding you a gift card (see below). After we give you the gift card, your identity data will be deleted from the data. Your name or any identifying information will not be used in any publications. In fact, the published results of the study will be presented in summary form only. Your identity will not be associated with your responses in any published format.</p>
						<p>
							The findings from this project may provide information on the design of auctions and websites that support them. The ultimate goal is to understand how to better protect consumer welfare. There are no known risks or discomforts associated with this research. The winner of the auction will get the alarm clock at the winning price plus a gift card worth $10 less the winning price. Other participants will receive a $10 gift card as a reward for participating in the study. The gift card is an incentive to encourage participation. It is not considered a benefit of participation. Therefore, you will receive the gift card only when you participate in the study. Please note that participating in the study means that you participating in all auctions that will be conducted in the experiment. This is because the validity of the experiment depends on your participation in all auctions.</p>
						<p>
							If you have any questions about this research project, please feel free to send me an e-mail to ben.liu@cityu.edu.hk.</p>
						<p>
							By clicking on the &ldquo;next&rdquo; button below, you are agreeing to participate in the above described research project.</p>
						<p>
							Thank you for your consideration!&nbsp;</p>
						<p>
							Sincerely,</p>
						<p>
							Dr. Ben Liu</p>
	  				</p>
	  				<p>
	  					<a class="right button" href="<%=basePath %>participant/signIn.action">Next</a>
	  				</p>
  				</div>
  			</fieldset>
  			<fieldset>
  				<legend>Administration Actions</legend>
  				<p>
  					<a href="<%=basePath %>review/getReviewForm.action" target="_blank">Setup Reviews</a>
  				</p>
  				<p>
  					<a href="<%=basePath %>groupAssignment/getPreviewParticipants.action" target="_blank">Preview Participants</a>
  				</p>
  				<p>
  					<a href="<%=basePath %>groupAssignment/assignGroups.action" target="_blank">Setup groups for 7,8,9 round to calculate winners</a>
  				</p>
  				<p>
  					<a href="<%=basePath %>auction/getAuctionForm.action" target="_blank">Config Auction</a>
  				</p>
  			</fieldset>
  		</div>
  	</div>
  </body>
</html>
