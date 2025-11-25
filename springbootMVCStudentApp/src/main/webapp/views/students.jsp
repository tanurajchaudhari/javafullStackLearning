<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<meta charset="UTF-8">
<title>All Students</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f6fa;
        padding: 20px;
    }

    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
    }

    table {
        width: 90%;
        margin: auto;
        border-collapse: collapse;
        background: #fff;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
    }

    th {
        background: #4a90e2;
        color: white;
        padding: 12px;
        text-align: left;
        font-size: 16px;
    }

    td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
        font-size: 15px;
    }

    tr:nth-child(even) {
        background: #f2f6fc;
    }

    tr:hover {
        background: #e9effd;
        transition: 0.3s;
        cursor: pointer;
    }
</style>
</head>
<body>

<h1>All Students</h1>
<div style="margin-left:66px;"class="mb-3 ms-6">
    <a href="/registration" class="btn btn-info">Add New Student</a>
</div>

<table table table-striped  table-bordered>
 <thead class ="  table table-info">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Gender</th>
        <th>Course</th>
        <th>Timings</th>
        <th>Action</th>
    </tr>
    </thead>
 <tbody cass="table table-success">
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.password}</td>
            <td>${student.gender}</td>
            <td>${student.course}</td>
            <td>${student.timing}</td>
            <td>
            <a href="/edit/${student.id}"class="btn btn-info" style="margin-right:10px;">Edit</a>
          <a href="/delete/${student.id}" 
              class="btn btn-danger"
              onclick="return confirm('Are you sure you want to delete this student right NOW????????');">
              Delete
          </a>
        
            </td>
        </tr>
    </c:forEach>
 </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

<script>
    // Remove leftover Bootstrap modal backdrop
    window.onload = function () {
        document.body.classList.remove("modal-open");
        const backdrops = document.querySelectorAll('.modal-backdrop');
        backdrops.forEach(b => b.remove());
    };
</script>

</body>
</html>
