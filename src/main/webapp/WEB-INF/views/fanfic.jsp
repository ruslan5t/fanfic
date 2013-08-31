<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script src="<c:url value="/resources/js/jquery.raty.min.js" />"></script>
<script src="<c:url value="/resources/js/settingRating.js" />"></script>
<script src="<c:url value="/resources/js/fanfic.js" />"></script>


<div id="fanficId" value="${fanfic.getId()}"></div>
<sec:authorize access="hasRole('ROLE_USER')">
	<div id="isLogged" value="true"></div>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
	<div id="isLogged" value="false"></div>
</sec:authorize>
<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1>${fanfic.getName()}</h1>
		</div>
	</div>
</div>

<spring:message code="author" />:
<a href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
	${fanfic.getAuthor().getUsername()} </a>
<br />
<table>
	<tr>
		<td><spring:message code="rating" />:</td>
		<td>
			<div class="rating" fanficId="${fanfic.getId()}"
				rating="${fanfic.getRating()}"></div>
		</td>
	</tr>
</table>
<spring:message code="categories" />
:
<c:forEach items="${fanfic.getCategories()}" var="category">
	<a
		href="${pageContext.servletContext.contextPath}/catalog/category/${category.getId()}">
		<spring:message code="${category.getName()}" />
	</a>
</c:forEach>
<br />
<spring:message code="tags" />
:
<c:forEach items="${fanfic.getTags()}" var="tag">
	<div class="tag">
		<a
			href="${pageContext.servletContext.contextPath}/catalog/tag/${tag.getId()}">
			${ tag.getName() } </a>
	</div>
</c:forEach>
<br />
<c:if test="${fanfic.getAuthor().getId().equals(currentUserId)}">
	<form
		action="${pageContext.servletContext.contextPath}/editFanfic/${fanfic.getId()}"
		method="get">
		<button class="btn btn-primary">
			<spring:message code="edit" />
		</button>
	</form>
</c:if>
<hr />
<div class="content">
	<c:if test="${!noChapters}">
		<button id="convertToPdf" class="btn btn-success">
			<spring:message code="convertToPdf" />
		</button>

		<div id="contentTitle">
			<spring:message code="content" />
			:
		</div>
		<c:forEach items="${fanfic.getChapters()}" var="chapter">
			<div class="contentItem">
				<a
					href="${pageContext.servletContext.contextPath}/chapter/${fanfic.getId()}/${chapter.getId()}">
					${chapter.getName()} </a>
			</div>
			<c:if test="${canRemoveFanfics}">
				<form method="post"
					action="${pageContext.servletContext.contextPath}/removeChapter/${fanfic.getId()}/${chapter.getId()}">
					<button class="remove">
						<div>x</div>
					</button>
				</form>
			</c:if>
			<br />
		</c:forEach>
	</c:if>
	<c:if test="${noChapters}">
		<spring:message code="noChapters" />
	</c:if>
	<c:if test="${fanfic.getAuthor().getId().equals(currentUserId)}">
		<br />
		<a
			href="${pageContext.servletContext.contextPath}/addChapter/${fanfic.getId()}">
			<spring:message code="addChapter" />
		</a>
	</c:if>
	<br />
</div>
<hr />
<c:if test="${noComments}">
	<spring:message code="noComments" />
</c:if>
<c:if test="${!noComments}">
	<div class="comments">
		<spring:message code="comments" />
		:
		<c:forEach items="${fanfic.getComments()}" var="comment">
			<div class="comment">
				<a
					href="${pageContext.servletContext.contextPath}/user/${comment.getAuthor().getId()}">
					${comment.getAuthor().getUsername()} </a>: ${comment.getContent()}
			</div>
			<br />

		</c:forEach>
	</div>
</c:if>
<hr />
<sec:authorize access="hasRole('ROLE_USER')">
	<form
		action="${pageContext.servletContext.contextPath}/addComment/${fanfic.getId()}/${currentUserId}"
		method="post">
		<spring:message code="addComment" var="addCommentTranslate" />
		<div class="commentTextarea">
			<textarea name="newComment" placeholder="${addCommentTranslate}" class="form-control"></textarea>
		</div>
		<input type="submit" value="${addCommentTranslate}" class="btn btn-primary" />
	</form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
	<spring:message code="signInToPostAComment" />
</sec:authorize>

