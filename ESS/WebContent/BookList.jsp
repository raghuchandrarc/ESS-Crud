<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Employee Management Application</title>
	<style>
	* {
  margin: 4;
  padding: 4;
}
.clsActionButton{
    width: 100px;
}
.w3-padding.w3-display-topright
{

    color: white;
	text-shadow: 0 0 3px #F10D58, 0 0 7px #4578D5;
}

table {
  border-radius:15px
 

}

th, td {
  text-align: center;
  padding: 8px;
  border-radius:5px;
  border: 1px solid pink;
}
tr {
    background-color: #f2f2f2;
}

th {
  background-color:#8a8a5c;
  color: white;
}
 
h1 {
    padding-top: 80px;
    color: white;
	text-shadow: 0 0 3px #F10D58, 0 0 7px #4578D5;
}
	h2 {
    padding-top: 20px;
    text-shadow: 2px 2px 5px crimson;
}
#example2 {
  border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px 18px #888888;
}
.bg {
  /* The image used */
  background-image: url("https://xenovation-105b8.kxcdn.com/images/sliders/software-engineering/slider-devOps.jpg");

  /* Full height */
  height: 100%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

	</style>
</head>
<body bgcolor="#e6e6ff" class="bg">
<div class="w3-padding w3-display-topright">AUTOMATION LIFE CYCLE DEMO</div>
	<center>
		<h1>Employee Management</h1>
        <h2>
        	<a href="new">Add New Employee</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Employees</a>
        	
        </h2>
	</center>
    <div align="center">
        <table cellpadding="9" id="example2">
            <caption><h2>List of Employees</h2></caption>
            <tr>
                <th width="100">Employee ID</th>
                <th >Employee Name</th>
                <th width="100">Designation</th>
                <th width="100">Location</th>
                <th width="100">Actions</th>
            </tr>
            <c:forEach var="emp" items="${listEmp}">
                <tr >
                    <td width="100"><c:out value="${emp.id}" /></td>
                    <td width="100"><c:out value="${emp.empname}" /></td>
                    <td width="100"><c:out value="${emp.empdesignation}" /></td>
                    <td width="100"><c:out value="${emp.location}" /></td>
                    <td width="140">
                    	<a href="edit?id=<c:out value='${emp.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${emp.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    
</body>
</html>
