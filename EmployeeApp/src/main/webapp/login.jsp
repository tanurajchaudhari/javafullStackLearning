<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    /* Reset some default styles */
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: "Poppins", sans-serif;
    }

    body {
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #74ebd5, #ACB6E5);
    }

    .login-container {
        background: white;
        padding: 40px 35px;
        border-radius: 15px;
        box-shadow: 0 4px 20px rgba(0,0,0,0.2);
        width: 350px;
        text-align: center;
    }

    h2 {
        margin-bottom: 25px;
        color: #333;
        letter-spacing: 1px;
    }

    table {
        width: 100%;
        margin-bottom: 20px;
    }

    td {
        padding: 10px 5px;
        text-align: left;
    }

    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 8px;
        outline: none;
        font-size: 15px;
        transition: 0.3s;
    }

    input[type="email"]:focus,
    input[type="password"]:focus {
        border-color: #74ebd5;
        box-shadow: 0 0 5px rgba(116,235,213,0.5);
    }

    input[type="submit"] {
        background: linear-gradient(to right, #74ebd5, #ACB6E5);
        color: white;
        border: none;
        padding: 10px 0;
        width: 100%;
        border-radius: 8px;
        cursor: pointer;
        font-size: 16px;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: linear-gradient(to right, #5fd1bf, #9baee0);
        transform: scale(1.03);
    }

    .footer {
        margin-top: 15px;
        font-size: 14px;
        color: #555;
    }

    .footer a {
        color: #74ebd5;
        text-decoration: none;
    }

    .footer a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="login-container">
        <h2>Login Here</h2>
        <p style='color:red;font-weight: 400'>${msg }</p>
        <form action="login">
            <table>
                <tr>
                    <td>Enter Email:</td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Enter Password:</td>
                    <td><input type="password" name="password" required></td>
                </tr>
            </table>
            <input type="submit" value="Login">
        </form>
        <div class="footer">
            Don’t have an account? <a href="index.jsp">Register</a>
        </div>
    </div>
</body>
</html>
