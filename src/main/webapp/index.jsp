<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery, Ajax and Servlet/JSP integration example</title>

<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>
<script>
$(document).ready(function() {
    $('#userName2').click(function(event) {
            var name = $('#userName').val();
            $.post('GetUser', {
                    userName : name,
                    id : 7
            }, function(responseText) {
                    $('#ajaxGetUserServletResponse').text(responseText);
            });
    });
});
</script>
	<form>
		Enter Your Name: <input type="text" id="userName" />
		
	</form>
	<button id="userName2">Dac </button>
	<br>
	<br>

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>
</body>
</html>