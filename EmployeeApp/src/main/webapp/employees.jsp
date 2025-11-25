<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
<style>
    body {
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #f8f8f8, #ffecec);
        margin: 0;
        padding: 40px;
    }

    h2 {
        text-align: center;
        color: #e74c3c; /* red accent */
        margin-bottom: 30px;
        font-size: 28px;
        text-transform: uppercase;
        letter-spacing: 1px;
    }

    table {
        width: 80%;
        margin: auto;
        border-collapse: collapse;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        background: white;
        border-radius: 10px;
        overflow: hidden;
    }

    th, td {
        padding: 14px 18px;
        text-align: left;
    }

    th {
        background-color: #e74c3c; /* red header */
        color: white;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #ffe5e0; /* light red hover */
        transition: 0.3s;
    }

    td {
        color: #333;
    }

    /* Add subtle border lines */
    tr {
        border-bottom: 1px solid #ddd;
    }

    /* Responsive table */
    @media (max-width: 768px) {
        table {
            width: 100%;
        }

        th, td {
            padding: 10px;
            font-size: 14px;
        }
    }
</style>
</head>
<body>
    <h2>All Employees</h2>

    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>City</th>
            <th>Gender</th>
        </tr>

        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.password}</td>
                <td>${employee.city}</td>
                <td>${employee.gender}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
