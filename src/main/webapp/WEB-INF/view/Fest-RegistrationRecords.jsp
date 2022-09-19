<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('https://i0.wp.com/www.thestartupjournal.com/wp-content/uploads/2015/11/Top-10-Colege-Fests-India.jpg?w=820&ssl=1');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
input[type=search], select {
  width: 100%;
  height: 30px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}
table {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  align-content: center;
}
table td,table th {
  border: 1px solid #ddd;
  padding: 8px;
}
table tr:nth-child(even){background-color: #ccffcc;}
table tr:nth-child(odd){background-color: #e6ffff;}
table tr:hover {background-color: #ddd;}
table th {
  padding-top: 5px;
  padding-bottom: 5px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
label{
padding: 10px;
color: white;
font-size: large;
font-weight: bold;
}
button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 5px 5px;
  text-align: center;
  text-decoration: underline;
  display: inline-block;
  font-size: 15px;
  margin: 2px 2px;
  cursor: pointer;
  align:center;
  font-weight: bold;
}
</style>
<meta charset="UTF-8">
<title>College Fest : Spandan 2K22</title>
</head>
<body>
<form action="/CollegeFest/students/searchRecord" class="" style="align-items: center;">
<fieldset>
<legend>Database of Registered Students</legend>
<label>SEARCH STUDENT'S RECORDS BY ANY PARAMETERS REQUIERED - </label>
<br>
<br>
<label>BY ID         :</label>
<input type="search" name="id" value="id" placeholder="Enter Registration ID"/><br><br>
<label>BY NAME       :</label>
<input type="search" name="name" value="name" placeholder="Enter Name"/><br><br>
<label>BY BATCH      :</label>
<input type="search" name="batch" value="batch" placeholder="Enter Batch"/><br><br>
<label>BY DEPARTMENT :</label>
<input type="search" name="department" value="department" placeholder="Enter Department"/><br><br>
<label>BY ACTIVITY   :</label>
<input type="search" name="activity" value="activity" placeholder="Enter Activity"/><br><br>
<label>BY CITY       :</label>
<input type="search" name="city" value="city" placeholder="Enter City"/><br><br>
<label>BY COUNTRY    :</label>
<input type="search" name="country" value="country" placeholder="Enter Country"/><br><br>
<button type="submit">Search Records</button>
<br>
<br>
</fieldset>
</form>
<br>
<br>
<table align="center" border="1" style="color:green;font-size-adjust: inherit;font-weight: bold;border-style: solid;">
			<thead class="thead-dark">
				<tr>
				    <th>Reg-Id</th>
					<th>Name</th>
					<th>Batch</th>
					<th>Department</th>
					<th>Activity</th>
					<th>City</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="tempStudent">
					<tr>
					    <td><c:out value="${tempStudent.id}" /></td>
						<td><c:out value="${tempStudent.name}" /></td>
						<td><c:out value="${tempStudent.batch}" /></td>
						<td><c:out value="${tempStudent.department}" /></td>
						<td><c:out value="${tempStudent.activity}" /></td>
						<td><c:out value="${tempStudent.city}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td>
					<a href="/CollegeFest/students/updateRecord?RegId=${tempStudent.id}"><button>UPDATE</button></a>
						
					<a href="/CollegeFest/students/deleteRecord?RegId=${tempStudent.id}"><button>DELETE</button></a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
<br>
<br>
<a href="/CollegeFest/students/addRecord" style="align-self: center;"><button>REGISTER NEW STUDENT</button></a>
</body>
</html>