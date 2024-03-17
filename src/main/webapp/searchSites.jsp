<html>
<%@include file="head.jsp"%>



<%@include file="nav.jsp"%>

<section class="header16 cid-u7iIcWYjMC mbr-fullscreen mbr-parallax-background" id="hero-17-u7iIcWYjMC">
    <div class="mbr-overlay" style="opacity: 0.3; background-color: rgb(0, 0, 0);"></div>
    <div class="container-fluid">
        <div class="row">
            <div class="content-wrap col-12 col-md-10">

                <form action="searchReview" class="form-inline">
                    <div class="=form-group">
                        <label for="parkName">Search</label>
                        <input type="text" class="form-control" id="parkName" name="parkName" aria-describedby="searchTermHelp"
                               placeholder="Enter park name">
                    </div>
                    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
                    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Reviews</button>
                </form>
            </div>
        </div>
    </div>
</section>
<body>
<h2>Campsite Reviewer</h2>


<form action="searchUser" class="form-inline">
    <div class="=form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp"
               placeholder="Enter last name">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</button>
</form>




</body>
<%@include file="footer.jsp"%>
</html>
