<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login - Student App</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: #eef2ff;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: Arial;
    }
    .box {
        width: 400px;
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0px 4px 20px rgba(0,0,0,0.15);
    }
</style>

</head>
<body>

<div class="box">
    <h3 class="text-center">Login</h3>
    <hr>

    <form action="/loginStudent" method="post">

        <div class="mb-3">
            <label>Email:</label>
            <input type="email" name="email" class="form-control" required>
        </div>

        <div class="mb-3">
            <label>Password:</label>
            <input type="password" name="password" class="form-control" required>
        </div>

        <button class="btn btn-primary w-100">Login</button>

        <p class="text-danger mt-3">${error}</p>

    </form>
</div>

</body>
</html>
