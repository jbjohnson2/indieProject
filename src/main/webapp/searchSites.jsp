<html>
<%@include file="head.jsp"%>

<body>

<h2>Campsite Reviewer</h2>

<%@include file="header.jsp"%>
<form action="searchUser" class="form-inline">
    <div class="=form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp"
               placeholder="Enter last name">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</button>
</form>


<form>
    <div class="form-group">
        <label for="park">Select Park:</label>
        <select id="park" name="park">
            <option value="governorDodge">Governor Dodge</option>
            <option value="wyalusing">Wyalusing</option>
            <option value="devilsLake">Devil's Lake</option>
            <option value="lakeKegonsa">Lake Kegonsa</option>
        </select>
    </div>
    <div class="form-group">
        <label for="campground">Campground:</label>
        <input type="text" id="campground" name="campground">
    </div>







</form>
</body>
<%@include file="footer.jsp"%>
</html>
