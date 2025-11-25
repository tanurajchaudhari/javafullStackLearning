<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f2f6ff;
        display: flex;
        justify-content: center;
        padding-top: 40px;
    }

    .container {
        width: 430px;
        background: white;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0px 4px 20px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        margin-bottom: 15px;
        color: #333;
    }

    table {
        width: 100%;
    }

    td {
        padding: 10px 5px;
        font-size: 14px;
        color: #222;
    }

    input[type="text"],
    input[type="password"],
    select {
        width: 98%;
        padding: 8px;
        border: 1px solid #bbb;
        border-radius: 6px;
        font-size: 14px;
        outline: none;
    }

    input[type="text"]:focus,
    input[type="password"]:focus,
    select:focus {
        border-color: #005af0;
        box-shadow: 0 0 3px #80aaff;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-top: 15px;
        background: #005af0;
        color: white;
        font-size: 15px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: #003fba;
    }

    .message {
        text-align: center;
        color: green;
        font-weight: bold;
        margin-bottom: 10px;
    }
</style>

</head>
<body>

<div class="container">
<a href="students" style="color:pink">All Students</a>

<h2>Student Registration Form</h2>
<p class="message">${msg}</p>

<form:form action="register" modelAttribute="student" method="post">

   <table>
      <tr>
        <td>Student Name:</td>
        <td><form:input path="name"/></td>
      </tr>

      <tr>
        <td>Student Email:</td>
        <td><form:input path="email" type="email"/></td>
      </tr>

      <tr>
        <td>Password:</td>
        <td><form:input path="password" type="password"/></td>
      </tr>

      <tr>
        <td>Gender:</td>
        <td>
            <form:radiobutton path="gender" value="Male"/> Male
            <form:radiobutton path="gender" value="Female"/> Female
        </td>
      </tr>

      <tr>
        <td>Course:</td>
        <td>
            <form:select path="course">
                <form:option value="JAVA">JAVA</form:option>
                <form:option value="PYTHON">PYTHON</form:option>
                <form:option value="SPRING">SPRING</form:option>
            </form:select>
        </td>
      </tr>

      <tr>
        <td>Timings:</td>
        <td>
            <form:checkbox path="timing" value="Morning"/> Morning<br>
            <form:checkbox path="timing" value="Afternoon"/> Afternoon<br>
            <form:checkbox path="timing" value="Evening"/> Evening
        </td>
      </tr>

   </table>

   <input type="submit" value="Register">
</form:form>

</div>

</body>
</html>
