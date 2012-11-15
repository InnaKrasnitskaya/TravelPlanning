<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>

    <a href="/TravelPlan/pages/register.xhtml">Register</a>
    
	<h3>Login with username and password</h3>
 
	<c:if test="${not empty (param.error)}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
 
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value='' required="true" />
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' required="true" />
				</td>
			</tr>
			<tr>
				<td colspan='1'><input name="submit" type="submit"
					value="Submit" style="width:80px"/>
				</td>
				<td colspan='1'><input name="reset" type="reset" 
					value="Reset" style="width:80px"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>