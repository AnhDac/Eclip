<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
*{
	font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
}

aside {
    margin-left: 17px;
    width:19%;
}
section{
    width:78%;
}
.view-content {
	font-size: 18px;
	/*padding: 10px;*/
}
.table-content tbody td:first-child {
	max-width: 40px;
	word-wrap:break-word;
}
.table-content tbody td:nth-child(2){
	min-width: 140px;
	max-width: 200px;
	word-wrap: break-word;
}
.table-content tbody td:nth-child(3){
	min-width: 240px;
	max-width: 600px;
	word-wrap: break-word;
}
.table-content tbody td:nth-child(4){
	min-width: 30px;
	max-width: 60px;
	word-wrap: break-word;
}
.table-content tbody td:nth-child(5){
	min-width: 60px;
	max-width: 60px;
	word-wrap: break-word;
	text-align: center;
}
.table-content tbody td:nth-child(5) a:first-child{
	margin-right: 10px;
}

td p{
	display:inline-block;
	cursor: pointer;
}
.hide {
    display: none
}
</style>

<script>
    $(document).ready(function () {
    	var timeDelay = 1000;           // MILLISECONDS (5 SECONDS).
    	setTimeout( function (){
        		$(".view-content").removeClass("hide");
        		$(".loading").addClass("hide");
        	}, timeDelay);
    });	

   
</script>
</head>
<form>
		Enter Your Name: <input type="text" id="userName" />
		
	</form>
	<button id="userName2" onclick="$.post('delete', { id : 7});">Dac </button>
	<br>
	<br>

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>
<div class="loading">...Loading</div>
<div class="delete-done">dac</div>
<div class="view-content hide">
				<h1 id="h1">View Content</h1>
				<hr style="border-top: 2px solid #eee;">
				<div class ="table-content" style="border:  2px solid #eee;padding: 12px 12px 24px; border-radius: 10px;">					
					<table class="table table-bordered">
						<thead>
						  <tr>
							<th scope="col" >#</th>
							<th scope="col">Title</th>
							<th scope="col">Brief</th>
							<th scope="col">Create Date</th>
							<th scope="col">Action</th>
	
						
						  </tr>
						</thead>
						<tbody>
						<c:forEach var="content" items="${listContent}">
						  <tr>
						    <td><c:out value="${content.id}"/></td>
							<td><c:out value="${content.title}"/></td>
							<td><c:out value="${content.brief}"/></td>
							<td><c:out value="${content.datecreate}"/></td>				
							<!--  <td> <a href="#">Edit</a> <a href="delete?id=<c:out value='${content.id}' />">Delete</a></td>-->
							<td> <a href="#">Edit</a> <p onclick="$.post('delete', { id :<c:out value='${content.id}' />}); $(this).parent().parent().addClass('hide');"> Delete </p></td>
						        	
						  </tr>
						  </c:forEach>
						
						</tbody>
					  </table>
				</div>
