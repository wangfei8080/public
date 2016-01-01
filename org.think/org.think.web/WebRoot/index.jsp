<%-- <%@ page language="java" contentType="text/html; charset=utf-8" --%>
<%--     pageEncoding="utf-8"%> --%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%= this.getServletContext().getContextPath()%>/js/jquery-2.1.4.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
    $('#ddel').click(function(){
    	$.ajax({
    		url:'/think/helloServlet',
    		type:'get',
    		success:function(){
    			alert('ajax success!');
    		}
    	});
    });
});
</script>
</head>
<body>
	<h1>Hello Word!!!</h1>
	<button id='ddel'>DDEL</button>
	<form action="<%= this.getServletContext().getContextPath()%>/web/getwebtest" method="post">
		<input type="submit">
	</form>
</body>
</html>