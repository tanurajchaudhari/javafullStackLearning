<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="p-5">

<h2>Login Successful!</h2>
<hr>

<h3>Welcome, ${student.name}</h3>

<p><strong>Email:</strong> ${student.email}</p>
<p><strong>Gender:</strong> ${student.gender}</p>
<p><strong>Course:</strong> ${student.course}</p>
<p><strong>Timing:</strong> ${student.timing}</p>

<a href="/home" class="btn btn-primary mt-3">Back to login</a>

</body>
</html>
