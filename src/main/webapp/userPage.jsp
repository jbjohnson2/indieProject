<%@include file="taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="head.jsp"%>
<%@include file="navLoggedIn.jsp"%>
<head>
    <title>User Page</title>
</head>
<body>
<section class="features03 cid-u7iIcWYVVo" id="news-1-u7iIcWYVVo">
    <div class="container-fluid">

        <div class="row justify-content-center mb-5">
            <div class="col-12 content-head">
                <div class="mbr-section-head">
                    <h4 class="mbr-section-title mbr-fonts-style align-left mb-0 display-2">
                        <strong>My Reviews</strong>
                    </h4>
                </div>
            </div>
        </div>
        <c:forEach var="review" items="${userReviews}">
        

            <div class="row">
                <div class="item features-image col-12 col-md-6 col-lg-4 active">
                    <div class="item-wrapper">
                        <div class="item-content align-left">
                            <h6 class="item-subtitle mbr-fonts-style mb-3 display-5">
                                <strong><a class="text-black fw-bold">${review.park}</a></strong>
                            </h6>
                            <p class="mbr-text mbr-fonts-style mb-3 display-7">Campground: ${review.campground}  Campsite: ${review.campsite}</p>
                            <p class="mbr-text mbr-fonts-style mb-3 display-7">Grades<ul>
                            <li>Shade: ${review.shade}</li>
                            <li>Size: ${review.size}</li>
                            <li>Bathroom Access: ${review.bathroomAccess}</li>
                            <li>Kid Friendliness: ${review.kidFriendliness}</li>
                            <li>Dog Friendliness: ${review.dogFriendliness}</li>
                        </ul></p>
                            <div class="mbr-text mbr-fonts-style mb-3 display-7">Review: ${review.reviewText}</div>
                                <form action="editReviewRouter" class ="form-inline">
                                    <input type="hidden" name="reviewID" value=${review.id} />
                                    <input type="hidden" name="userId" value=${userId} />
                                    <button type="submit" name="edit" value="edit" class="btn btn-primary">Edit Review</button>
                                </form>
                                <form action="deleteReview" class="form-inline">
                                    <input type="hidden" name="reviewID" value=${review.id} />
                                    <input type="hidden" name="userId" value=${userId} />
                                    <button type="submit" name="delete" value="delete" class="btn btn-primary">Delete Review</button>
                                </form>
                        </div>

                        </div>
                    </div>
                </div>
         </div>
        </c:forEach>

          <div class="row">
        <div class="item features-image col-12 col-md-6 col-lg-4 active">
            <div class="item-wrapper">
                <h3> ${message}</h3>
                <c:remove var="message" ></c:remove>
                <h4 class="mbr-section-title mbr-fonts-style align-left mb-0 display-2">
                    <strong>Find the distance to a park</strong>
                </h4>
                <br>
                <div class="item-content align-left">


                    <form action="findDistance" class ="form-inline">
                        <div class="form-group">
                        <label for="userZipcode">Your zipcode:</label>
                        <input type="text" id="userZipcode" name="userZipcode" value=${User.zipcode} />
                        </div>
                        <div class="form-group">
                            <label for="park">Select Park:</label>
                            <select id="park" name="park">
                                <option value=1>Amnicon Falls</option>
                                <option value=2>Big Bay</option>
                                <option value=3>Big Foot Beach</option>
                                <option value=4>Blue Mounds</option>
                                <option value=5>Brunet Island</option>
                                <option value=6>Buckhorn</option>
                                <option value=7>Copper Falls</option>
                                <option value=8>Council Grounds</option>
                                <option value=9>Devil's Lake</option>
                                <option value=10>Governor Dodge</option>
                                <option value=11>Governor Thompson</option>
                                <option value=12>Harrington Beach</option>
                                <option value=13>Hartmen Creek</option>
                                <option value=14>High Cliff</option>
                                <option value=15>Interstate</option>
                                <option value=16>Kohler-Andrae</option>
                                <option value=17>Lake Kegonsa</option>
                                <option value=18>Lake Wissota</option>
                                <option value=19>Merrick</option>
                                <option value=20>Mill Bluff</option>
                                <option value=21>Mirror Lake</option>
                                <option value=22>Nelson Dewey</option>
                                <option value=23>New Glarus Woods</option>
                                <option value=24>Pattison</option>
                                <option value=25>Peninsula</option>
                                <option value=26>Perrot</option>
                                <option value=27>Potawatami</option>
                                <option value=28>Roche-A-Cri</option>
                                <option value=29>Rock Island</option>
                                <option value=30>Rocky Arbor</option>
                                <option value=31>Straight Lake</option>
                                <option value=32>Tower Hill</option>
                                <option value=33>Wildcat Mountain</option>
                                <option value=34>Willow River</option>
                                <option value=35>Wyalusing</option>
                                <option value=36>Yellowstone Lake</option>
                            </select>
                          </div>
                        <br />
                        <input type="hidden" name="userZipcode" value=${User.zipcode} />
                        <button type="submit" name="edit" value="edit" class="btn btn-primary">Find Distance</button>
                    </form>

                </div>

            </div>
        </div>
    </div>
    </div>
</section>
</body>
<%@include file="footer.jsp"%>

</html>
