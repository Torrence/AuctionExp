<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
    <title><tiles:insertAttribute name="title" /></title>
	<link rel="stylesheet" href="../css/blueprint/screen.css" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="../css/blueprint/print.css" type="text/css" media="print">
    <!--[if lt IE 8]><link rel="stylesheet" href="../css/blueprint/ie.css" type="text/css" media="screen, projection"><![endif]-->
  	<link type="text/css" href="../css/smoothness/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
  	<link type="text/css" href="../css/main.css" rel="stylesheet" />
  	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
  	<script type="text/javascript" src="../js/jquery-ui-1.8.22.custom.min.js"></script>
  	<script type="text/javascript">
  		$(document).ready(function(){
  		});
  	</script>
  </head>
  
  <body>
  	<div class="container">
  		<tiles:insertAttribute name="header" defaultValue="/include/header.jsp" />
  		<div class="content">
  			<tiles:insertAttribute name="content" />
  		</div>
  		<tiles:insertAttribute name="footer" defaultValue="/include/footer.jsp" />
  	</div>
  </body>
</html>
