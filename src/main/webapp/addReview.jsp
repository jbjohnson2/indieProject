<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>

<body>








    <div class="container-fluid">
            <form action="addReview">
                <div class="form-group">
                    <label for="userID">User:</label>
                    <input type="text" id="userID" name="userID">
                </div>

                <div class="form-group">
                    <label for="park">Select Park:</label>
                    <select id="park" name="park">
                        <option value="Governor Dodge">Governor Dodge</option>
                        <option value="Wyalusing">Wyalusing</option>
                        <option value="Devil's Lake">Devil's Lake</option>
                        <option value="Lake Kegonsa">Lake Kegonsa</option>
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


</body>
</html>
