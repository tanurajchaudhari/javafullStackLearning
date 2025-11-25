<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student App - Home</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
      rel="stylesheet">

<style>
    body {
        background: #eef2ff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        font-family: Arial, sans-serif;
    }
    .container-box {
        width: 450px;
        background: white;
        padding: 30px;
        border-radius: 12px;
        text-align: center;
        box-shadow: 0px 4px 20px rgba(0,0,0,0.15);
    }
    h1 {
        color: #333;
        margin-bottom: 20px;
        font-size: 28px;
    }
    a.btn {
        width: 180px;
        margin: 10px;
    }
</style>

</head>
<body>

<div class="container-box">
    <h1>Student App</h1>
    <p class="text-muted mb-4">Manage student registrations and view records easily</p>

    <a href="/login" class="btn btn-primary">Login</a>
    <a href="/registration" class="btn btn-success">Register</a>
</div>

</body>
</html>
