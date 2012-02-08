<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
          <h1><a href="index.html">Northeastern<span class="logo_colour">University</span></a></h1>
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
        
        <script src="http://l.yimg.com/a/i/us/pps/listbadge_1.4.js">{"pipe_id":"5ec67178b28c211b4a66b7fb0a15cf23","_btype":"list"}</script>
        
       
       
       
      </div>
      <div id="content">
        <div align=center><br><br>
        <form name='f' action='j_spring_security_check' method='POST'>
			<h4>Course Registration(New<a href="studentRegister.html"> Student?</a> <a href="instructorRegister.html">Instructor?</a>)</h4>
			<span id="error" style="color:red;display:none">Incorrect Login. Try Again.</span>
 			<table>
    			<tr><td>Username (email):</td><td><input type='text' name='j_username' value=''/></td></tr>
    			<tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
    			<tr></tr>
    			<tr>
    				<td><input name="submit" type="submit" value="Login"/></td>
    				<td><input name="reset" type="reset"/></td>
    			</tr>
    		</table>
		</form>
		
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
  <script type="text/javascript">
			if (window.location.href.slice(window.location.href.indexOf('?')).split(/[&?]{1}[\w\d]+=/) == "?login_error")
				document.getElementById("error").style.display = "block";
		</script>
</body>
</html>
