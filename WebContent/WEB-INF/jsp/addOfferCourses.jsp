<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>Course Registration</title>
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" />
  <script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript">
$(function(){$("a[href^='addCourse']").bind("click",function(event){
	event.preventDefault();
	$.ajaxSetup({ cache: false });
	$.get(this.href,{},function(data){$("div#result").html(data);});
	});});
</script>
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
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="student.html">About Me</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="updateStudent.html">Update</a></sec:authorize></li>
          <li><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="studentCourses.html">My Courses</a></sec:authorize></li>
          <li class="selected"><sec:authorize ifAllGranted="ROLE_STUDENT"><a href="courses.html">Add Course</a></sec:authorize></li>
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
     <script src="http://l.yimg.com/a/i/us/pps/listbadge_1.4.js">{"pipe_id":"5ec67178b28c211b4a66b7fb0a15cf23","_btype":"list","height":"450"}</script>
        <a href="j_spring_security_logout" ">Log Out</a>
        
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <center>
      
         <c:if test="${!empty courseList}">
	      <table>
		      <tr>
		      <th>Course ID</th>
			<th>Course Name</th>
			<th>Credit</th>
			<th>Capacity</th>
			<th>Remain</th>
			<th>Instructor</th>
			<th>&nbsp;</th>
			
		     </tr>

         <c:forEach items="${courseList}" var="course">
		    <tr>
		    <td><c:out value="${course.courseId}"/></td>
			<td><c:out value="${course.courseName}"/></td>
			<td><c:out value="${course.credit}"/></td>
			<td><c:out value="${course.capacity}"/></td>
			<td><c:out value="${course.capacity-selectedList[course.courseId-1]}"/></td>
			<td><c:out value="${course.instructor.instructorName}"/></td>
			<td><sec:authorize ifAllGranted="ROLE_STUDENT">
			<c:if test="${course.capacity-selectedList[course.courseId-1]!=0}">
			    <a href="addCourse/${course.courseId}.html">
			</c:if>add</a>
			    </sec:authorize>
			    
			    <sec:authorize ifAllGranted="ROLE_INSTRUCTOR">
			   <c:if test="${empty course.instructor.instructorName}">
			   <a href="offerCourse/${course.courseId}.html"></c:if>offer</a>
			    </sec:authorize>
			
		</c:forEach>
	    </table>
         </c:if>
         <div id="result"></div>
       </center>
      </div>
    </div>
    <div id="footer">
      Copyright &copy; 2011 by zhiyu | <a href="http://www.neu.edu">Northeastern University</a> 
    </div>
  </div>
</body>
</html>
