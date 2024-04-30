<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<%@include file="head.jsp"%>
<body>


<%@include file="nav.jsp"%>

<h3>${loginError}</h3>
<c:remove var="loginError" ></c:remove>

<section class="header16 cid-u7iIcWYjMC mbr-fullscreen mbr-parallax-background" id="hero-17-u7iIcWYjMC">
  <div class="mbr-overlay" style="opacity: 0.3; background-color: rgb(0, 0, 0);"></div>
  <div class="container-fluid">
    <div class="row">
      <div class="content-wrap col-12 col-md-10">
        <h1 class="mbr-section-title mbr-fonts-style mbr-white mb-4 display-1">
          <strong>Campsite Reviewer</strong>
        </h1>
        <p class="mbr-fonts-style mbr-text mbr-white mb-4 display-7">Unleash Your Inner Explorer and Share Your Campsite Adventures with the World!</p>
        <div class="mbr-section-btn"><a class="btn btn-white-outline display-7" href="logIn">Get Started</a></div>
      </div>
    </div>
  </div>
</section>




<%--<%@include file="faq.jsp"%>--%>
<%--<%@include file="gallery.jsp"%>--%>







<%@include file="footer.jsp"%>
<%@include file="scripts.jsp"%>





</body>
</html>