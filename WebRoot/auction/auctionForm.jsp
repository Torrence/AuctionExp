<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="Config Auction" />
	<tiles:putAttribute name="content">
		<script type="text/javascript">
	  		$(document).ready(function(){
	  			var saveAuction = function(itemId,itemTitle){
	  				$.ajax({
	  				  type: 'POST',
	  				  url: '<s:url action="saveAuction" namespace="/auction" />',
	  				  data: {
	  					  'auction.item.id':itemId,
	  					  'auction.item.title':itemTitle
	  				  },
	  				  success: function(data){alert('Save Success');},
	  				  dataType: 'json'
	  				});
	  			};
	  			$('#save-auction').live('click',function(){
	  				var itemId = $('#auction-form').find('input[name="item.id"]').val();
	  				var itemTitle = $('#auction-form').find('input[name="item.title"]').val();
	  				saveAuction(itemId,itemTitle);
	  			});
	  			$('#round').live('change',function(){
	  				var round = $(this).val();
	  				window.location = '<s:url action="getAuctionForm" namespace="/auction" />?auction.round='+round;
	  			});
	  			$('#show-result').live('click',function(){
	  				var round = $('#round').val();
	  				window.location = '<s:url action="calculateWinners" namespace="/auction" />?auction.round='+round+'&auctionType=SECOND_PRICE';
	  			});
		  		$('.start-auction').live('click',function(event){
		  			event.preventDefault();
		  			if(confirm("Are you sure to start this auction? Once you start, other auctions will be stopped!")){
		  				window.location = this.href;	  				
		  			}
		  		});
		  		$('.stop-auction').live('click',function(event){
		  			event.preventDefault();
		  			if(confirm("Are you sure to stop this auction?")){
		  				window.location = this.href;	  				
		  			}
		  		});
	  		});
	  	</script>
	  	<div id="setup-auction">
		  	<form id="auction-form">
				<fieldset>
					<legend>Config Auction: Round <s:property value="auction.round" /></legend>
					<p>
						<label for="title">Title</label>
						<br>
						<input type="hidden" name="item.id" value='<s:property value="auction.item.id" />' />
						<input type="text" name="item.title" id="title" value='<s:property value="auction.item.title" />' size="80" />
						<input type="button" value="Save" id="save-auction">
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
					<hr>
					<table id="auction-list">
						<caption>Auction List</caption>
						<thead>
							<tr>
								<th>Round</th>
								<th>Status</th>
								<th>Operation</th>
								<th>Reset</th>
							</th>
						</thead>
						<tbody>
							<s:iterator value="auctionList">
								<tr <s:if test="round==auction.round">class="current"</s:if>>
									<td>
										<a href='<s:url action="getAuctionForm" namespace="/auction"><s:param name="auction.round" value="round" /></s:url>'>Round <s:property value="round"/></a>
									</td>
									<td>
										<s:if test="status==0">
											ready
										</s:if>
										<s:elseif test="status==1">
											started
										</s:elseif>
										<s:else>
											finished
										</s:else>
									</td>
									<td>
										<s:if test="status==0">
											<a class="start-auction" href='<s:url action="startAuction" namespace="/auction"><s:param name="auction.round" value="round"/></s:url>'>start</a>
										</s:if>
										<s:elseif test="status==1">
											<a target="_blank" class="preview-result" href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="round"/></s:url>'>preview</a>
											/<a class="stop-auction" href='<s:url action="stopAuction" namespace="/auction"><s:param name="auction.round" value="round"/></s:url>'>stop</a>
										</s:elseif>
										<s:else>
											<a target="_blank" class="show-result" href='<s:url action="previewResult" namespace="/auction"><s:param name="auction.round" value="round"/></s:url>'>result</a>
											/<a class="restart-auction" href='<s:url action="startAuction" namespace="/auction"><s:param name="auction.round" value="round"/></s:url>'>restart</a>
										</s:else>
									</td>
									<td>
										<a class="reset-auction" href='<s:url action="startAuction" namespace="/auction"><s:param name="auction.round" value="round"/></s:url>'>Reset</a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</fieldset>
			</form>
		</div>
	</tiles:putAttribute>
</tiles:insertTemplate>