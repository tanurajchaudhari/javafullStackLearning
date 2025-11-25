<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="search">
   Book Id : <input type="number" placeholder="Enter Book Id..." name="bookId">
   <input type="submit" value="search">

   <hr>
   <h3 style='color:red'>${msg}</h3>
   
   Book ID:- ${book.id} <br>
   Book Name:- ${book.name}<br>
   Book Price :- ${book.price}<br>
   Book qyt :- ${book.qyt}
   
</form>

</body>
</html>