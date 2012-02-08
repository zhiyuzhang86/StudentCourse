<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>Course Registration</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" />
  <script type="text/javascript" src="js/jquery.js"></script> 
  <script type="text/javascript">
  $(function(){
	  $("div#content").hide();
	  $("div#content").toggle(1000);
  });
  </script>
</head>

<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.jsp">Northeastern<span class="logo_colour">University</span></a></h1>
          <h2>Course Registration System</h2>
          <p>User ID: <sec:authentication property="principal.username"/></p>
        </div>
        <div id="contact_details">
          <p>tel: 347 788 2467</p>
          <p>fax: 347 788 2467</p>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li><a href="index.jsp">Home</a></li>
          <li class="selected"><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="student.html">About Me</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="updateStudent.html">Update</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="studentCourses.html">My Courses</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="courses.html">Add Course</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="searchCourses.html">Search Courses</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_INSTRUCTOR"><a href="instructorCourses.html">My Courses</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_INSTRUCTOR"><a href="createCourse.html">Create Course</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_INSTRUCTOR"><a href="courses.html">Offer Course</a></sec:authorize></li>
        </ul>
      </div>
    </div>
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
     <script src="http://l.yimg.com/a/i/us/pps/listbadge_1.4.js">{"pipe_id":"5ec67178b28c211b4a66b7fb0a15cf23","_btype":"list","height":"400"}</script>
        <a href="j_spring_security_logout" ">Log Out</a>
        
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <center>
        
        <img src="${pageContext.request.contextPath}/images/${student.studentId}" 
	width="200" height="130" alt=""  alt="Upload Image" />
	
	</center>
        <table style="width:100%; border-spacing:0;">
          <tr><th>Item</th><th>Description</th></tr>
          <tr><td>Student ID</td><td>${student.studentId}</td></tr>
          <tr><td>Name</td><td>${student.studentName}</td></tr>
          <tr><td>Email</td><td>${student.email}</td></tr>
          <tr><td>Gender</td><td>${student.gender}</td></tr>
          <tr><td>Birthday</td><td>${student.birthday}</td></tr>
		  <tr><td>Major</td><td>${student.major.majorName}</td></tr>
		  <tr><td>About ME</td><td>${student.aboutMe}</td></tr>
        </table>
       <td>
	
	
</td>
      </div>
    </div>
    <div id="footer">
      Copyright &copy; 2011 by zhiyu | <a href="http://www.neu.edu">Northeastern University</a> 
    </div>
  </div>
</body>
</html>
