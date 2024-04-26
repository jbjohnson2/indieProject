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
                    <h4 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                        <strong>My Reviews</strong>
                    </h4>
                </div>
            </div>
        </div>
        <c:forEach var="review" items="${userReviews}" varStatus="loopCounter">

        <c:out value="${loopCounter.count}"/>

            <div class="row">
                <div class="item features-image col-12 col-md-6 col-lg-4 active">
                    <div class="item-wrapper">
                        <div class="item-content align-left">
                            <h6 class="item-subtitle mbr-fonts-style mb-3 display-5">
                                <strong><a class="text-black fw-bold">${review.park}</a></strong>
                            </h6>
                            <p class="mbr-text mbr-fonts-style mb-3 display-7">Campground: ${review.campground}  Campsite: ${recentReview1.campsite}</p>
                            <p class="mbr-text mbr-fonts-style mb-3 display-7">Grades<ul>
                            <li>Shade: ${review.shade}</li>
                            <li>Size: ${review.size}</li>
                            <li>Bathroom Access: ${review.bathroomAccess}</li>
                            <li>Kid Friendliness: ${review.kidFriendliness}</li>
                            <li>Dog Friendliness: ${review.dogFriendliness}</li>
                        </ul></p>
                            <div class="mbr-text mbr-fonts-style mb-3 display-7">Review: ${review.reviewText}</div>
                                <form action="editReview" class ="form-inline">
                                    <button type="submit" name="edit" value="edit" class="btn btn-primary">Edit Review</button>
                                </form>
                                <form action="deleteReview" class="form-inline">
                                    <input type="hidden" name="reviewID" value=${review.id} />
                                    <button type="submit" name="delete" value="delete" class="btn btn-primary">Delete Review</button>
                                </form>
                        </div>

                        </div>
                    </div>
                </div>
         </div>
        </c:forEach>
    </div>
</section>
</body>
<%@include file="footer.jsp"%>

</html>