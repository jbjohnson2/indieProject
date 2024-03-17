<%@include file="taglib.jsp" %>

<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>
<html>
<body>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
            <th>Park</th>
            <th>Campground</th>
            <th>Campsite</th>
            <th>Shade</th>
            <th>Size</th>
            <th>Bathroom Access</th>
            <th>Kid Friendliness</th>
            <th>Dog Friendliness</th>
            <th>Review</th>
        </thead>
        <tbody>
        <c:forEach var="review" items="${reviews}">
            <tr>
                <td>${review.park}</td>
                <td>${review.campground}</td>
                <td>${review.campsite}</td>
                <td>${review.shade}</td>
                <td>${review.size}</td>
                <td>${review.bathroomAccess}</td>
                <td>${review.kidFriendliness}</td>
                <td>${review.dogFriendliness}</td>
                <td>${review.reviewText}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
