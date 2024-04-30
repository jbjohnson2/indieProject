<%@include file="taglib.jsp"%>
<html>


<c:import url="head.jsp" />
<body>
<c:choose>
    <c:when test="${empty User}">
        <c:import url="nav.jsp" />
    </c:when>
    <c:otherwise>
        <c:import url="navLoggedIn.jsp" />
    </c:otherwise>
</c:choose>


<section class="header16 cid-u7iIcWYjMC mbr-fullscreen mbr-parallax-background" id="hero-17-u7iIcWYjMC">
    <div class="mbr-overlay" style="opacity: 0.3; background-color: rgb(0, 0, 0);"></div>
    <div class="container-fluid">
        <div class="row">
            <div class="content-wrap col-12 col-md-10">
                <h2 style="color:white">Search for a Review</h2>
                <br>
                <form action="searchReview" class="form-inline">
                    <div class="=form-group">
                        <label for="parkName">Search</label>
                        <input type="text" class="form-control" id="parkName" name="parkName" aria-describedby="searchTermHelp"
                               placeholder="Enter park name">
                    </div>

                    <button type="submit" name="submit" value="searchByPark" class="btn btn-primary">Search by Park</button>

                    <div class="=form-group">
                        <label for="keyword">Search</label>
                        <input type="text" class="form-control" id="keyword" name="keyword" aria-describedby="searchTermHelp"
                               placeholder="Enter keyword">
                    </div>
                        <button type="submit" name="submit" value="searchByKeyword" class="btn btn-primary">Search by Keyword</button>
                    <div>
                    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Reviews</button>
                     </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
<c:import url="footer.jsp" />
</html>
