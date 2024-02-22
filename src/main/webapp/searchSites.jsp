
<%@include file="head.jsp"%>
<html>
<body>

<h2>Campsite Reviewer</h2>

<%@include file="nav.jsp"%>
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
