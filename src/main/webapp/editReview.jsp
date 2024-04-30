<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<c:import url="head.jsp" />



<c:import url="nav.jsp" />
<body>


<section class="header16 cid-u7iIcWYjMC mbr-fullscreen mbr-parallax-background" id="hero-17-u7iIcWYjMC">
    <div class="mbr-overlay" style="opacity: 0.3; background-color: rgb(0, 0, 0);"></div>
    <div class="container-fluid col-12 col-md-4" style="background-color: blanchedalmond">
        <form action="editReview">
            <h2>Edit Your Review</h2>
            <input type="hidden" name="userId" value=${userId} />
            <input type="hidden" name="reviewId" value=${reviewToEdit.id} />
            <div class="form-group">
                <label for="park">Select Park:</label>
                <select  id="park" name="park">
                    <option value="${reviewToEdit.park}">${reviewToEdit.park}</option>
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
                <input type="text" id="campground" name="campground" value="${reviewToEdit.campground}">
            </div>
            <div class="form-group">
                <label for="campsite">Campsite:</label>
                <input type="text" id="campsite" name="campsite" value=${reviewToEdit.campsite}>
            </div>
            <div class="form-group">
                <label for="shade">Shade:</label>
                <select id="shade" name="shade" >
                    <option value="${reviewToEdit.shade}">${reviewToEdit.shade}</option>
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
                    <option value="${reviewToEdit.size}">${reviewToEdit.size}</option>
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
                    <option value="${reviewToEdit.bathroomAccess}">${reviewToEdit.bathroomAccess}</option>
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
                    <option value="${reviewToEdit.kidFriendliness}">${reviewToEdit.kidFriendliness}</option>
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
                    <option value="${reviewToEdit.dogFriendliness}" selected>${reviewToEdit.dogFriendliness}</option>
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="F">F</option>
                </select>
            </div>
            <p><label for="reviewText">Review:</label></p>
            <textarea id="reviewText" name="reviewText" rows="4" cols="50">${reviewToEdit.reviewText}</textarea>
            <br>

            <button type="submit" name="submit" value="add" class="btn btn-primary">Update</button>

        </form>
    </div>
</section>








</body>
<c:import url="footer.jsp" />
</html>
