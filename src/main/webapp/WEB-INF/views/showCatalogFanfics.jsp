<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr />
<div class="row offset1">
	<div class="span12">
		<c:forEach items="${allFanfics}" var="fanfic">
			<div class="row">
				<div class="span12">
					<a
						href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
						${fanfic.getName()} </a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<div class="row offset1">
	<div class="span11">
		<div id="pagination"></div>
	</div>
</div>