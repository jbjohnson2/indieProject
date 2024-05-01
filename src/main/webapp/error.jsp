<%@include file="taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="head.jsp" />
<c:choose>
    <c:when test="${empty User}">
        <c:import url="nav.jsp" />
    </c:when>
    <c:otherwise>
        <c:import url="navLoggedIn.jsp" />
    </c:otherwise>
</c:choose>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <h2>${errorMessage}</h2>

</body>
</html>