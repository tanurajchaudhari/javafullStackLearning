<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Profile</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #74ebd5, #ACB6E5);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .profile-container {
        background-color: #ffffff;
        border-radius: 16px;
        box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
        padding: 30px 40px;
        width: 450px;
        text-align: center;
        transition: transform 0.3s ease;
    }

    .profile-container:hover {
        transform: translateY(-5px);
    }

    h1 {
        color: #333;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }

    th, td {
        padding: 12px 15px;
        border-bottom: 1px solid #ddd;
        text-align: left;
        font-size: 15px;
    }

    th {
        background-color: #4CAF50;
        color: white;
        border-radius: 6px 6px 0 0;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    .welcome {
        font-size: 18px;
        font-weight: 600;
        color: #444;
        margin-bottom: 10px;
    }

    .logout-btn {
        margin-top: 20px;
        display: inline-block;
        background-color: #4CAF50;
        color: white;
        padding: 10px 18px;
        border-radius: 6px;
        text-decoration: none;
        transition: background-color 0.3s ease;
    }

    .logout-btn:hover {
        background-color: #45a049;
    }

</style>
</head>
<body>

<div class="profile-container">
    <div class="welcome">Welcome, ${employee.name} 👋</div>
    <a href="employees">All Employees</a>
    <h1>Employee Profile</h1>

    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>City</th>
            <th>Gender</th>
        </tr>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.password}</td>
            <td>${employee.city}</td>
            <td>${employee.gender}</td>
        </tr>
    </table>

    <a href="login.jsp" class="logout-btn">Logout</a>
</div>

</body>
</html>
