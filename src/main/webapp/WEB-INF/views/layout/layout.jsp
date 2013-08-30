<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<tiles:insertAttribute name="minHeadBody" />
</head>
<body>
	<tiles:insertAttribute name="menu" />
	<div class="container">
		<div class="col-xs-12 col-sm-9">
			<tiles:insertAttribute name="main" />
		</div>
		<tiles:insertAttribute name="sidebar" />
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>