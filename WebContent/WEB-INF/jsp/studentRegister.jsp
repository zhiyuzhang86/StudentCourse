<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <title>Course Registration</title>
  
    <script type="text/javascript">
				function Validate()
				  {
					var image =document.studentForm.file.value;
					var x=document.studentForm.email.value
					var atpos=x.indexOf("@");
					var dotpos=x.lastIndexOf(".");
					 
					
					 if(document.studentForm.studentName.value=="" ||
						document.studentForm.email.value=="" ||
						document.studentForm.password.value==""||
						document.studentForm.file.value==""||
						document.studentForm.birthday.value=="")
					 {
						 alert("Please fill out all fields before clicking submit!");
							  return false;
						    }
					 else if(atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
						 
					 {
						  alert("Not a valid e-mail address");
						  return false;
						  }
					 else if (document.studentForm.password.value.length<3 || document.studentForm.password.value.length>12)
					 {
						  alert("Password size must between 3 to 12 characters ");
						  return false;
						  }
					 else if(image.value!=''){
						  var checkimg = image.toLowerCase();
						  if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
							  alert("Enter Image File Extensions .jpg,.png,.jpeg and size is no bigger than 100K");
							  document.studentForm.photo.focus();
							  return false;
						    }
						 }
					 				
					 
						 
					}
</script>
 <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link type="text/css" href="style/jquery-ui-1.8.12.custom.css" rel="Stylesheet" />
    <link rel="Stylesheet" type="text/css" href="style/style.css" />
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
     <script type="text/javascript" src="js/jquery.js"></script> 
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
     <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
   <script>
  $(document).ready(function() {
    $("#date").datepicker({defaultDate: '09/28/1986'});
  });
  </script>
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
        </div>
        <div id="contact_details">
          <p>tel: 347 788 2467</p>
          <p>fax: 347 788 2467</p>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          
        </ul>
      </div>
    </div>
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
        <script src="http://l.yimg.com/a/i/us/pps/listbadge_1.4.js">{"pipe_id":"5ec67178b28c211b4a66b7fb0a15cf23","_btype":"list","height":"500"}</script>      
      </div>
      
      <div id="content">
        <div align=center>
        <h2>Welcome to Course Registration System</h2>
         <form:form method="post" action="saveStudent.html" name="studentForm" enctype="multipart/form-data"
          commandName="student" onSubmit="return Validate();">
    <table>
	<tr>
		<td>Name*</td>
		<td><form:input path="studentName" name="studentName"/></td>

	</tr>
	<tr>
		<td>Email*</td>
		<td><form:input path="email" name="email"/></td>
	
	</tr>
	<tr>
		<td>Password*</td>
		<td><form:password path="password" name="password" /></td>

	</tr>
	<tr>
		<td>Gender </td>
		<td><form:radiobutton path="gender" value="M" label="M" name="gender"/> 
		    <form:radiobutton path="gender" value="F" label="F" name="gender"/></td>

		    
	</tr>
	<tr>
		<td>Birthday*</td>
		<td><form:input path="birthday" name="birthday" id="date"/></td>

		
		</tr>
		<td>Major</td>
			<td><form:select path="major" name="major">
				<form:option value="0" label="Select" />
				<form:option value="1" label="CSE" />
				<form:option value="2" label="IS" />
				<form:option value="3" label="TSM" />
			</form:select></td>
			
			
	<tr>
		<td>About Me </td>
		<td><form:textarea path="aboutMe" /></td>
		</tr>
	<tr>
	    <td>Photo*</td>	
		<td><input name="file"  type="file" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Add Student"/>
		</td>
	</tr>
</table>	
</form:form>

<script type="text/javascript">
document.write("<p>" + Date() + "</p>");
</script>

		</div>
      </div>
    </div>
    <div id="footer">
      Copyright &copy; 2011 by zhiyu | <a href="http://www.neu.edu">Northeastern University</a> 
    </div>
  </div>
  
</body>
</html>
