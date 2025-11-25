<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

<style>
    body {
        font-family: Arial;
        background: #eef2ff;
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
        margin-bottom: 20px;
        color: #333;
    }
    table { width: 100%; }
    td { padding: 10px; }
    input, select {
        width: 98%;
        padding: 8px;
        border: 1px solid #bbb;
        border-radius: 6px;
    }
    input[type="submit"] {
        width: 100%;
        background: #0066ff;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 6px;
        cursor: pointer;
        margin-top: 15px;
    }
</style>

</head>
<body>

<div class="container">

<a href="/students">⬅ Back</a>

<h2>Edit Student</h2>

<form:form action="/update" modelAttribute="student" method="post">

    <form:hidden path="id"/>

    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
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
            <td>Timing:</td>
            <td>
                <form:checkbox path="timing" value="Morning"/> Morning <br>
                <form:checkbox path="timing" value="Afternoon"/> Afternoon <br>
                <form:checkbox path="timing" value="Evening"/> Evening
            </td>
        </tr>
    </table>

    <input type="submit" value="Update Student"/>
</form:form>

</div>

</body>
</html>
