<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            color: #333;
            margin-top: 20px;
        }

        a {
            display: inline-block;
            margin: 20px 0;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        a:hover {
            background-color: #2980b9;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 600px;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        td:first-child {
            font-weight: bold;
            width: 200px;
        }

        input[type="text"], input[type="email"], input[type="tel"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .message {
            margin-top: 20px;
            font-size: 1.2em;
        }

        .success {
            color: green;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Manage Contacts</h1>

    <a href="viewContacts">View All Contacts</a>

    <form:form action="saveContact" method="post" modelAttribute="contact">
        <table>
            <tr>
                <td>Contact ID</td>
                <td><form:hidden path="cId"/></td>
            </tr>
            <tr>
                <td>Contact Name</td>
                <td><form:input path="cName" type="text" placeholder="Enter Name"/></td>
            </tr>
            <tr>
                <td>Contact Email</td>
                <td><form:input path="cEmail" type="email" placeholder="Enter Email"/></td>
            </tr>
            <tr>
                <td>Contact Number</td>
                <td><form:input path="cNumber" type="tel" placeholder="Enter Contact Number"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save Contact"/>
                </td>
            </tr>
        </table>
    </form:form>

    <div class="message">
        <font class="success">${successMsg}</font>
        <font class="error">${failedMsg}</font>
    </div>
</body>
</html>
