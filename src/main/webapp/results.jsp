<%@include file="taglib.jsp" %>

<%@include file="head.jsp"%>

<html><body>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table>

        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th><th>Age</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
