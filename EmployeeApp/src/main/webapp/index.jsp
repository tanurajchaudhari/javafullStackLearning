<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #74ebd5, #ACB6E5);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        position: relative;
    }

    /* 🔹 Top-right login button */
    .login-btn {
        position: absolute;
        top: 20px;
        right: 30px;
        background-color: #4a90e2;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 6px;
        font-size: 15px;
        font-weight: bold;
        text-decoration: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .login-btn:hover {
        background-color: #357ABD;
    }

    /* 🔹 Form box */
    .form-container {
        background-color: #fff;
        padding: 30px 40px;
        border-radius: 15px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        width: 400px;
        text-align: center;
    }

    h2 {
        color: #333;
        margin-bottom: 20px;
    }

    p {
        color: green;
        font-weight: 500;
        margin-bottom: 15px;
    }

    table {
        width: 100%;
        border-spacing: 10px;
    }

    td {
        text-align: left;
        font-size: 15px;
        color: #555;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    select {
        width: 100%;
        padding: 8px 10px;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
        transition: border 0.3s;
    }

    input:focus,
    select:focus {
        border-color: #4a90e2;
    }

    input[type="radio"] {
        margin-right: 5px;
    }

    input[type="submit"] {
        margin-top: 20px;
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 6px;
        background-color: #4a90e2;
        color: white;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #357ABD;
    }
</style>
</head>
<body> 
  <!-- 🔹 Login Button -->
  <a href="login-form" class="login-btn">Login</a>

  <!-- 🔹 Registration Form -->
  <div class="form-container">
    <h2>Register Here</h2>
    <p>${message}</p>
    <form action="save">
       <table>
            <tr>
                <td>Enter your name:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Enter your email:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Enter your password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Choose your city:</td>
                <td>
                   <select name="city">
                      <option>Pune</option>
                      <option>Mumbai</option>
                      <option>Chennai</option>
                      <option>Bangalore</option>
                   </select>
                </td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male"> Male
                    <input type="radio" name="gender" value="Female"> Female
                </td>
            </tr>
       </table>
       
       <input type="submit" value="Register">
    </form>
  </div>
</body>
</html>
