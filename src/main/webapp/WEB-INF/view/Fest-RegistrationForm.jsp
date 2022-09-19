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
input[type=text], select {
  width: 100%;
  padding: 5px;
  height: 30px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}
label{
  padding: 10px;
  color: white;
  font-size: large;
  font-weight: bold;
}
p{
  padding: 10px;
  color: white;
  font-size: x-large;
  font-weight: bold;
}
button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: underline;
  display: inline-block;
  font-size: 20px;
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
<form action="/CollegeFest/students/saveRecord" style="align-items: center;" class="" method="post">
<fieldset>
<legend>Registration Form for College Fest Activities</legend>
<input type="hidden" name="id" id="id" value="${Students.id}"/>
<br>
<label>Name : </label><br>
<input type="text" name="name" id="name" value="${Students.name}" placeholder="Enter Your Name"/>
<br>
<br>
<label>Batch : </label><br>
<input type="text" name ="batch" id="batch" value="${Students.batch}" placeholder="Enter Your Batch"/>
<br>
<br>
<label>Department : </label><br>
<input type="text" name="department" id="department" value="${Students.department}" placeholder="Enter Your Department"/>
<br>
<br>
<label>Activity : </label><br>
<select id="activity" name = "activity" >
<optgroup label="SPORTS">
<option  id="Cricket"  value="${Students.activity}">Cricket   </option>
<option>FootBall  </option>
<option>BasketBall</option>
<option>VolleyBall</option>
<option>Badminton </option>
</optgroup>
<optgroup label="HOBBY">
<option>Sketching</option>
<option>Debate   </option>
<option>Dancing  </option>
<option>Singing  </option>
<option>Crafting </option>
</optgroup>
</select>
<br>
<br>
<label>City : </label><br>
<input type="text" name="city" id="city" value="${Students.city}" placeholder="Enter Your Native City"/>
<br>
<br>
<label>Country : </label><br>
<input type="text" name="country" id="country" value="${Students.country}" placeholder="Enter Your Native Country"/>
<br>
<br>
<label>Submit the Details :</label>
<button type="submit" value="submit">SUBMIT</button>
</fieldset>
</form>
<p style="font: bold;">PLEASE NOTE YOUR REGISTRATION ID FOR FUTURE USE</p>
<br>
</body>
</html>