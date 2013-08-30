<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container">
		<div class="col-xs-12 col-sm-9">
			<div class="page-header" id="banner">
				<div class="row">
					<div class="col-lg-6">
						<h1>
							Vosstanovlenie parolya
						</h1>
					</div>
				</div>
			</div>
			<div class="well">
				<form class="bs-example form-horizontal" method="post">
                	<fieldset>
                  		<legend>Legenda</legend>
                  		<div class="form-group">
                  			<spring:message code="username" var="usernameTranslate" />
                    		<label for="username" class="col-lg-2 control-label">${usernameTranslate}</label>
                    		<div class="col-lg-10">
                      			<input type="text" name="username" placeholder="${usernameTranslate}"  class="form-control"/> 
                    		</div>
                  		</div>
                  		<div class="form-group">
                    		<div class="col-lg-10 col-lg-offset-2">
                      			<spring:message code="continue" var="continueTranslate" />
                      			<button type="submit" class="btn btn-primary">${continueTranslate}</button> 
                    		</div>
                  		</div>
                	</fieldset>
              	</form>
			</div>
		</div>
		<jsp:include page="sidebar.jsp" />
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>