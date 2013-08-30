<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-6">
			<h1>Editing chapter</h1>
		</div>
	</div>
</div>

<div class="well">
	<form:form class="bs-example form-horizontal"
		action="${pageContext.servletContext.contextPath}/editChapter/${editingFanficId}/${editingChapterId}"
		method="POST" modelAttribute="newChapter">
		<fieldset>
			<jsp:include page="makeChapterForm.jsp" />
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<spring:message code="editChapter" var="editChapterTranslate" />
					<button type="submit" class="btn btn-primary">${editChapterTranslate}</button>
				</div>
			</div>
		</fieldset>
	</form:form>
</div>