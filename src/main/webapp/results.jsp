<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<c:import url="head.jsp" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<body >

<c:choose>
    <c:when test="${empty User}">
        <c:import url="nav.jsp" />
    </c:when>
    <c:otherwise>
        <c:import url="navLoggedIn.jsp" />
    </c:otherwise>
</c:choose>


<section class="header16 cid-u7iIcWYjMC mbr-fullscreen mbr-parallax-background" id="hero-17-u7iIcWYjMC" style="padding-top: 110px">
    <div class="mbr-overlay" style="opacity: 0.3; background-color: rgb(0, 0, 0);"></div>
    <div class="container-fluid">
        <div class="row">
            <div class="content-wrap col-12 col-md-11" style= "background-color: white">
                <div class="container-fluid">
                    <h2>${tableHeader}: </h2>
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

            </div>
        </div>
    </div>
</section>

<c:import url="footer.jsp" />
<c:import url="scripts.jsp" />

</body>
</html>



