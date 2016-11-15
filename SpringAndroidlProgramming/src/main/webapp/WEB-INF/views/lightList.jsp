<%@ page  contentType="application/json;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="light" items="${list}">
	{
		"image":"${light.image}",
		"imageLarge":"${light.imageLarge}",
		"title":"${light.title}",
		"side" : "${light.side}",
		"content":"${light.content}"
	}
	<c:if test="${!status.last}">,</c:if> <%--마지막줄이 아니면 ,를 붙여라 --%>
</c:forEach>
]