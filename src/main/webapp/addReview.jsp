<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<%@include file="head.jsp"%>



<%@include file="nav.jsp"%>
<body>


<section class="header16 cid-u7iIcWYjMC mbr-fullscreen mbr-parallax-background" id="hero-17-u7iIcWYjMC">
    <div class="mbr-overlay" style="opacity: 0.3; background-color: rgb(0, 0, 0);"></div>
    <div class="container-fluid col-12 col-md-4" style="background-color: blanchedalmond">
        <form action="addReview">
            <h2>Add Your Review</h2>
            <div class="form-group">
                <label for="userID">User:</label>
                <input type="text" id="userID" name="userID">
            </div>
            <div class="form-group">
                <label for="park">Select Park:</label>
                <select id="park" name="park">
                    <option value="Amnicon Falls">Amnicon Falls</option>
                    <option value="Big Bay">Big Bay</option>
                    <option value="Big Foot Beach">Big Foot Beach</option>
                    <option value="Blue Mounds">Blue Mounds</option>
                    <option value="Brunet Island">Brunet Island</option>
                    <option value="Buckhorn">Buckhorn</option>
                    <option value="Copper Falls">Copper Falls</option>
                    <option value="Council Grounds">Council Grounds</option>
                    <option value="Devil's Lake">Devil's Lake</option>
                    <option value="Governor Dodge">Governor Dodge</option>
                    <option value="Governor Thompson">Governor Thompson</option>
                    <option value="Harrington Beach">Harrington Beach</option>
                    <option value="Hartmen Creek">Hartmen Creek</option>
                    <option value="High Cliff">High Cliff</option>
                    <option value="Interstate">Interstate</option>
                    <option value="Kohler-Andrae">Kohler-Andrae</option>
                    <option value="Lake Kegonsa">Lake Kegonsa</option>
                    <option value="Lake Wissota">Lake Wissota</option>
                    <option value="Merrick">Merrick</option>
                    <option value="Mill Bluff">Mill Bluff</option>
                    <option value="Mirror Lake">Mirror Lake</option>
                    <option value="Nelson Dewey">Nelson Dewey</option>
                    <option value="New Glarus Woods">New Glarus Woods</option>
                    <option value="Pattison">Pattison</option>
                    <option value="Peninsula">Peninsula</option>
                    <option value="Perrot">Perrot</option>
                    <option value="Potawatami">Potawatami</option>
                    <option value="Roche-A-Cri">Roche-A-Cri</option>
                    <option value="Rock Island">Rock Island</option>
                    <option value="Rocky Arbor">Rocky Arbor</option>
                    <option value="Straight Lake">Straight Lake</option>
                    <option value="Tower Hill">Tower Hill</option>
                    <option value="Wildcat Mountain">Wildcat Mountain</option>
                    <option value="Willow River">Willow River</option>
                    <option value="Wyalusing">Wyalusing</option>
                    <option value="Yellowstone Lake">Yellowstone Lake</option>



                </select>
            </div>
            <div class="form-group">
                <label for="campground">Campground:</label>
                <input type="text" id="campground" name="campground">
            </div>
            <div class="form-group">
                <label for="campsite">Campsite:</label>
                <input type="text" id="campsite" name="campsite">
            </div>
            <div class="form-group">
                <label for="shade">Shade:</label>
                <select id="shade" name="shade">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="F">F</option>
                </select>
            </div>
            <div class="form-group">
                <label for="size">Size:</label>
                <select id="size" name="size">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="F">F</option>
                </select>
            </div>
            <div class="form-group">
                <label for="bathroomAccess">Restroom Access:</label>
                <select id="bathroomAccess" name="bathroomAccess">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="F">F</option>
                </select>
            </div>
            <div class="form-group">
                <label for="kidFriendliness">Kid Friendliness:</label>
                <select id="kidFriendliness" name="kidFriendliness">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="F">F</option>
                </select>
            </div>
            <div class="form-group">
                <label for="dogFriendliness">Dog Friendliness:</label>
                <select id="dogFriendliness" name="dogFriendliness">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="F">F</option>
                </select>
            </div>
            <p><label for="reviewText">Review:</label></p>
            <textarea id="reviewText" name="reviewText" rows="4" cols="50"></textarea>
            <br>

            <button type="submit" name="submit" value="search" class="btn btn-primary">Submit</button>

        </form>
    </div>
</section>








</body>
<%@include file="footer.jsp"%>
</html>
