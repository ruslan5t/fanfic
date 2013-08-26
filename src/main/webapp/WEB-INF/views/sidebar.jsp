<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="<c:url value="/resources/js/settingTagCloud.js" />"></script>
<script src="<c:url value="/resources/js/tagcloud.jquery.min.js" />"></script>
<div class="sidePanel span3">
			<div id="tagcloud" class="row">
				<ul>
					<c:forEach items="${allTags}" var="tag">
						<li><a
							href="${pageContext.servletContext.contextPath}/catalog/tag/${tag.getId()}">
								${tag.getName()} </a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="categories">
				<div class="categoriesTitle">
					Навигация:
				</div>
			<ul>
				<li><a href="${pageContext.servletContext.contextPath}/catalog">
					<spring:message code="all"/>
				</a></li>
				<c:forEach items="${allCategories}" var="category">
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/category/${category.getId()}">
							<spring:message code="${category.getName()}" />
					</a></li>
				</c:forEach>
			</ul>
			</div>
		</div>