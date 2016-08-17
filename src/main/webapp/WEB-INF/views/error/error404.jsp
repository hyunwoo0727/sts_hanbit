<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
	<link href="${css}/style.css" rel="stylesheet" type="text/css" />
	<div id="main">
		<!-- header -->
		<div id="header">
			<h1>No pages here as you see!<span>404 error - not found.</span></h1>
		</div>
		<!-- content -->
		<div id="content">
			<ul class="nav">
         	<li class="home"><a href="${context}/index.jsp">Home Page</a></li>
            <li class="site_map"><a href="#">Site Map</a></li>
            <li class="search"><a href="#">Website Search</a></li>
         </ul>
         <p>Unless creepy emptiness was what you were looking for, this place has nothing that you want.<br /> 
         So please either go to our <a href="#">homepage</a>, <a href="#">sitemap</a> or try using the <a href="#">website search</a>.</p>
		</div>
	</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />