<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="format-detection" content="telephone=no" />
		<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
		<title>跨域 v${version}</title>
	</head>
	<body>
		<c:forEach items="${allow_methods}" var="method">
			<c:forEach items="${allow_origins}" var="origin">
				<div>${method}&nbsp;${origin}&nbsp;${allow_credentials}</div>
			</c:forEach>
		</c:forEach>
		
	</body>
</html>