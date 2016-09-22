<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="context" value="<%=request.getContextPath()%>" />
<c:set var="img" value="${context}/resources/img" />
<c:set var="css" value="${context}/resources/css" />
<c:set var="js" value="${context}/resources/js"/>
<!doctype html>
<html lang="en">
<head>
	<title><tiles:getAsString name="title"/></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="${css}/application.css" type="text/css"/>
	<link rel="apple-touch-icon" sizes="57x57" href="${img}/favicons/apple-touch-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="${img}/favicons/apple-touch-icon-60x60.png">
	<link rel="icon" type="image/png" href="${img}/favicons/favicon-32x32.png" sizes="32x32">
	<link rel="icon" type="image/png" href="${img}/favicons/favicon-16x16.png" sizes="16x16">
	<link rel="manifest" href="${img}/favicons/manifest.json">
	<link rel="shortcut icon" href="${img}/favicons/favicon.ico">
	<!-- Normalize -->
	<link rel="stylesheet" type="text/css" href="${css}/normalize.css">
	<!-- Owl -->
	<link rel="stylesheet" type="text/css" href="${css}/owl.css">
	<!-- Animate.css -->
	<link rel="stylesheet" type="text/css" href="${css}/animate.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" type="text/css"
		href="${font}/font-awesome-4.1.0/css/font-awesome.min.css">
	<!-- Elegant Icons -->
	<link rel="stylesheet" type="text/css"
		href="${font}/eleganticons/et-icons.css">
	<!-- Main style -->
	<link rel="stylesheet" type="text/css" href="${css}/cardio.css">
</head>
<body>
	<header>
		<div id="user_header">
			<%-- <tiles:insertAttribute name="header" />  --%>	
		</div>
	</header>
	<section>
		<article id="user_article">
			<tiles:insertAttribute name="body" />
		</article>
	</section>
	<footer>
		 <div id="user_footer">
		 <tiles:insertAttribute name="footer" /> 
		 </div>
	</footer>
</body>
<script src="${js}/app.js?ver=1.2"></script>
<script>
	app.init('${pageContext.request.contextPath}');
	
</script>
</html>