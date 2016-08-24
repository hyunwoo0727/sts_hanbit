<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/nav.jsp" />

<div id="container">
<section>
	<button id="bt_bom">BOM(Browser Object Model)</button>
	<button id="bt_dom">DOM(Document Object Model)</button>
	<button id="bt_kaup">KAUP</button>
	<button id="bt_account">ACCOUNT</button>
</section>
</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />
<script src="${js}/douglas.js"></script>
<script type="text/javascript">
	douglas.init()
</script>