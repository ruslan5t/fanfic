<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:forEach items="${allFanfics}" var="fanfic">
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
<div id="pagination"></div>