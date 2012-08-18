<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/layouts/baseLayout.jsp">
	<tiles:putAttribute name="title" value="Setup Groups" />
	<tiles:putAttribute name="content">
		<script type="text/javascript">
	  		$(document).ready(function(){
	  			
	  			var saveGrouping = function(grouping){
	  				$.ajax({
	  				  type: 'POST',
	  				  url: '<s:url action="saveGroup" namespace="/groupAssignment" />',
	  				  data: {
	  					  'grouping':grouping
	  				  },
	  				  success: function(){},
	  				  dataType: 'json'
	  				});
	  			};
	  			
	  			$('.save-group').live('change',function(){ 
	  			    // groupIndex is used to record the data-id's value
	  				var groupIndex = $(this).attr('data-id');
	  				var theId = $(this).attr('id');
	  				
	  				// get the selected group num.
	  				var selectIndex = $('#' + theId).get(0).selectedIndex;
	  				var oTest = $('#group-' + selectIndex);
	  				var index = $(this).attr('select-num');
	  				var reviewNum;
	  				if(index>=0&&index<4){
	  					reviewNum = 6;
	  				}else{
	  					reviewNum = 14;
	  				}
	  				var averageRating;
	  				if(index%4>=0 && index%4<2){
	  					averageRating = 2;
	  				}else{
	  					averageRating = 4;
	  				}
	  				var overview ;
	  				if(index%2 == 0){
	  					overview = "with overview";
	  				}else{
	  					overview = "without overview";
	  				}
	  				
					var insertDiv = "<td id='td-" + theId + "'>" + "reviewNum" + reviewNum + "<br/>"
					    + "averageRating" + averageRating + "<br/>" + overview + "<br/>" + theId
						+ " <a class='select-cancle' td-num='td-" + theId 
						+ "' row-num='group-" + selectIndex + "' data-id='" 
						+ theId + " ' id='a-" + groupIndex + "'>" + "cancle" + "</a>" 
						+ "</td>";
					
					oTest.append(insertDiv);
					$(this).attr('disabled','disabled');
	  			});
	  			
	  			$('.select-cancle').live('click',function(){ 
					var groupNum = $(this).attr('row-num');     // the parent element
					var tdNum = $(this).attr('td-num');
					var theSelect = $(this).attr('data-id');
					$('#' + theSelect).get(0).selectedIndex = 0;
					$('#' + theSelect).removeAttr('disabled');
					
					$('#' + tdNum).remove();
	  			});

	  			$('#confirm').live('click',function(){
 					var grouping = new Array(24);
					for(var i=1; i<=8; i++){
						var begin = $('#begin-' + i).get(0).selectedIndex;
						grouping[i-1] = begin;
						var middle = $('#middle-' + i).get(0).selectedIndex;
						grouping[8+i-1] = middle;
						var end = $('#end-' + i).get(0).selectedIndex;
						grouping[16+i-1] = end;
					}
					var param = "";
					param = param + grouping[0];
					for(var j = 1; j<24; j++){
						param = param + "," + grouping[j].toString();
					}
					saveGrouping(param);
	  			});
	  		});
	  	</script>
		<div id='test' data-id='<s:property value="groupNum"/>'></div>
		<fieldset>
		
			<legend>Assign Groups</legend>
	          <table>
		          <caption><em>Description of the 24 conditions.</em></caption>
		          <thead>
		            <tr>
		              <th class="span-1" colspan=2 rowspan=3></th>
		              <th class="span-1" colspan=4 style="text-align:center;">Number of Reviews:6</th>
		              <th class="span-1" colspan=4 style="text-align:center;">Number of Reviews:14</th>
		            </tr>
		            <tr>
		              <th class="span-1" colspan=2 style="text-align:center;">average rating: 2</th>
		              <th class="span-1" colspan=2 style="text-align:center;">average rating: 4</th>
		              <th class="span-1" colspan=2 style="text-align:center;">average rating: 2</th>
		              <th class="span-1" colspan=2 style="text-align:center;">average rating: 4</th>
		            </tr>
		            <tr>
		               <s:iterator value="{'1', '2', '3', '4'}" id='number'>
		                  <th class="span-1">with overview</th>
		              	  <th class="span-1">without overview</th>
		               </s:iterator>
		            </tr>
		          </thead>
 
		          <tbody>
		          	<tr>
		          		<td class="span-1" rowspan=3>Position of the distinct review</td>
		          		
		          		<s:iterator value="{'begin','middle','end'}" id ="p" status="position">
		          			<td style="width:64px"><s:property value="p" /></td>
		          			<s:iterator value='{"1","2","3","4","5","6","7","8"}' id="num" status="tmp">
		          				<td>
		          					<select class="save-group" 
		          							select-num='<s:property value="#tmp.index"/>'
		          					        id='<s:property value="p"/>-<s:property value="num"/>'
		          					        data-id='<s:property value="#position.index * 8 + #tmp.index"/>' 
		          					        style="width:82px">
		          					<option value="0">select...</option>
		       		          		<s:iterator value="new int[groupNum]" status="i">
		          						<option value="#i.index+1">Group<s:property value="#i.index + 1"/> </option>
		          					</s:iterator>
		          					</select>
		          				</td>
		          			</s:iterator>
		          			</tr>
		          			<s:if test="%{#position.getIndex()>=0}">
		          				<tr>
		          			</s:if>
		          		</s:iterator>
		          	
		          </tbody>
	          </table>
	       
	          <hr>
	          
	           <table>
		          <caption><em>Preview of group-assignment</em></caption>
		          <thead>
		            <tr>
		              <th class="span-1" style="text-align:center;">Group Number</th>
		              <th class="span-1" colspan=8 style="text-align:center;">Corresponding Condition Groups</th>
		            </tr>
		          </thead>
		          <tbody>
		          	<s:iterator value="new int[groupNum]" id="pId" status="i">
		          		<tr>
		          			<td style="width:64px; height:110px">Group <s:property value="#i.index+1"/></td>
		          			<td style="width:845px;" id='group-<s:property value="#i.index+1"/>'></td>
		          		</tr>
		          	</s:iterator>
		          </tbody>
	          </table>

	          <hr>
	          <input type="button" id="confirm" value="submit grouping">
	          <hr>
	          
		</fieldset>
	</tiles:putAttribute>
</tiles:insertTemplate>