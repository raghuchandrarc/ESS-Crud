<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Employee Management Application</title>
	<style>
	h1 {
    padding-top: 80px;
    color: white;
	text-shadow: 0 0 3px #F10D58, 0 0 7px #4578D5;
}
	h2 {
    padding-top: 20px;
    text-shadow: 2px 2px 5px crimson;
}
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
tr{

}

th, td {
  text-align: left;
  padding: 8px;
  color: black;
   border-radius:5px
   
}







.example_b {
color: #fff !important;
text-transform: uppercase;
background: #60a3bc;
padding: 14px;
border-radius: 50px;
display: inline-block;
border: none;
}

.example_b:hover {
text-shadow: 0px 0px 6px rgba(255, 255, 255, 1);
-webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
-moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
transition: all 0.4s ease 0s;
}

.shadow {

 -webkit-box-shadow: 0 8px 6px -6px black;
	   -moz-box-shadow: 0 8px 6px -6px black;
	        box-shadow: 0 8px 6px -6px black;
}

	</style>
</head>

<body bgcolor="#CFCCCC" background="../../images/devOps.jpg">

 <div >AUTOMATION LIFE CYCLE DEMO</div>
 
	<center>
		<h1>Employee Management</h1>
        <h2>
        	<a href="new">Add New Employee</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Employee</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${emp != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${emp == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5" >
            <caption>
            	<h2>
            		<c:if test="${emp != null}">
            			Edit Employee
            		</c:if>
            		<c:if test="${emp == null}">
            			Add New Employee
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${emp != null}">
        			<input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
        		</c:if>            
            <tr>
                <th>Employee Name:* </th>
                <td>
                	<input class="shadow" type="text" name="empname" size="45"
                			value="<c:out value='${emp.empname}' />" 
                		required />
                </td>
            </tr>
            <tr>
                <th>Designation:* </th>
                
                <td>
                	<input class="shadow" type="text" name="empdesignation" size="45"
                			value="<c:out value='${emp.empdesignation}' />"
                	required />
                </td>
            </tr>
            <tr>
                <th>Location:* </th>
                <td>
                	<input class="shadow" type="text" name="location" size="45"
                			value="<c:out value='${emp.location}' />"
                	required />
                </td>
            </tr>
            <!-- <tr>
				<td colspan="2" align="center">
				
					<div id="btnwrap">
						<button class="clsActionButton" id="idAddButton"
							onclick="idAddButton_onclick();">Add</button>
							<input type="submit"
					value="Save" class="btn-3d-sub" style="font-size: 18px" />
					</div></td>


			</tr> -->
			<tr>
        <td  colspan="2" style="text-align:center;">
            <div id="btnwrap">
                 <input class="example_b" type="submit" value="Save" class="clsActionButton"   style="font-size: 15px" />
                  <input class="example_b" type="reset" value="Reset" class="clsActionButton"  style="font-size: 15px" />
               
            </div>
        </td>
    </tr>
             
        </table>
        </form>
    </div>	
</body>
</html>
