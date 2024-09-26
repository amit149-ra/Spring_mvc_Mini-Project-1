<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Contacts</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        
        .message {
            margin-top: 20px;
            font-size: 1.2em;
        }

        h2 {
            color: #333;
        }

        a {
            display: inline-block;
            margin: 10px 0;
            padding: 10px 20px;
            color:#f2fffe;
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
            max-width: 800px;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        td {
            color: #555;
        }

        td a {
            background-color: #3498db;
            color: white;
            padding: 5px 10px;
            border-radius: 4px;
            text-decoration: none;
            margin-right: 10px;
        }

        td a:hover {
            text-decoration: underline;
        }

        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <a href="/mini_project_one/">Add New Contact</a>

    <h2>All Contacts</h2>
    
    <div class="message">
        <font class="success">${successMsg}</font>
        <font class="error">${failedMsg}</font>
    </div>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Contact</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${contacts}" var="con">
                <tr>
                    <td>${con.cName}</td>
                    <td>${con.cNumber}</td>
                    <td>${con.cEmail}</td>
                    <td>
                        <a href="editContact?cId=${con.cId}">Edit</a>
                        <a href="deleteContact?cId=${con.cId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
