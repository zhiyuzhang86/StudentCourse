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
	  $("div#logo_text").hide();
	  $("div#content").toggle(1000);
	  $("div#logo_text").toggle(1000); 
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
          <li class="selected"><a href="index.jsp">Home</a></li>
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="student.html">About Me</a></sec:authorize></li>
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
      <script src="http://l.yimg.com/a/i/us/pps/listbadge_1.4.js">{"pipe_id":"5ec67178b28c211b4a66b7fb0a15cf23","_btype":"list"}</script>
       <br>
       <script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script><fb:like href="" show_faces="true" width="20" font=""></fb:like>
       <br>
       <a href="j_spring_security_logout" ">Log Out</a>
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <h1>Welcome to Course Registration System</h1>
        <p>This Course Registration System is a web-based program aimed
            to make easier and more convenient the class registration process, a
            hassle through which students go every semester.</p>
        <p>Course Registration System (CRS) attempts to alleviate hassles by providing several services to students and instructors through the internet.</p>
        <p>CRS provides a way to search, add and drop classes without having to open a course catalog. Students can update personal information and check remain seat for each course on it</p>
        <p>Instructor can create a new course and choose which courses to offer each semester.</p>
       
       
        
      </div>
    </div>
    <div id="footer">
      Copyright &copy; 2011 by zhiyu | <a href="http://www.neu.edu">Northeastern University</a> 
    </div>
  </div>
  
  
</body>
</html>
