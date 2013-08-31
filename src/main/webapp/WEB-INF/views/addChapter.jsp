<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1>
				<spring:message code="chapterAdding"/>
			</h1>
		</div>
	</div>
</div>

<div class="well">
	<form:form method="POST" modelAttribute="chapter"
		class="bs-example form-horizontal"
		action="${pageContext.servletContext.contextPath}/addChapter/${fanficId}">
		<fieldset>
			<jsp:include page="makeChapterForm.jsp" />
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<spring:message code="addChapter" var="addChapterTranslate" />
					<button type="submit" class="btn btn-primary">${addChapterTranslate}</button>
				</div>
			</div>
		</fieldset>
	</form:form>
</div>