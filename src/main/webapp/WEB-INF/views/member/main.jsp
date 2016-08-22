<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:getAsString name="title"/>
<tiles:insertAttribute name="header" />

<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/nav.jsp" />
<jsp:include page="content.jsp" />
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />