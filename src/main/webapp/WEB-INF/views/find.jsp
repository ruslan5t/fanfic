<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h3>
				<spring:message code="search" />: <xmp id="searchRequest">"${searchRequest}"</xmp>
			</h3>
		</div>
	</div>
</div>

<c:forEach items="${foundedFanfics}" var="fanfic">
	<div class="row">
		<div class="postTitle">
			<a href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
				${fanfic.getName()}
			</a>
		</div>
		<div class="author">
			<a href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
				${fanfic.getAuthor().getUsername()}
			</a>
		</div>
		<div class="description">${fanfic.getDescription()}</div>
		<div class="tags">
			<spring:message code="tags" />:
			<c:forEach items="${fanfic.getTags()}" var="tag">
				<div class="tag">
					<a href="${pageContext.servletContext.contextPath}/catalog/tag/${tag.getId()}">
						${ tag.getName() }
					</a>
				</div>
			</c:forEach>
		</div>
		<div class="rating" fanficId="${fanfic.getId()}" rating="${fanfic.getRating()}"></div>
		<hr />
	</div>
</c:forEach>


<c:if test="${noFoundedFanfics}">
	<spring:message code="yourSearchDidNotMatchAny" />
</c:if>