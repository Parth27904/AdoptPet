<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Pet Adoption Center</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: #f4f4f9;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 90%;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #4CAF50;
            text-align: center;
            margin-bottom: 20px;
        }
        .filter-form {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
            justify-content: center;
        }
        .filter-form input {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 8px;
            width: 150px;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .add-btn {
            background-color: #28a745;
            color: white;
        }
        .add-btn:hover {
            background-color: #218838;
        }
        .delete-btn {
            background-color: #dc3545;
            color: white;
        }
        .delete-btn:hover {
            background-color: #c82333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            border-radius: 12px;
            overflow: hidden;
        }
        table th, table td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        table th {
            background-color: #4CAF50;
            color: white;
        }
        table tr:hover {
            background-color: #f1f1f1;
        }
        .image-preview {
            max-width: 80px;
            height: auto;
            border-radius: 8px;
        }
        .action-buttons a {
            text-decoration: none;
        }
        .top-actions {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Available Pets for Adoption</h2>

    <div class="top-actions">
        <form action="pets" method="get" class="filter-form">
            <input type="text" name="name" placeholder="Name">
            <input type="text" name="breed" placeholder="Breed">
            <input type="text" name="type" placeholder="Type">
            <input type="text" name="status" placeholder="Status">
            <button type="submit" class="btn" style="background-color:#4CAF50; color:white;">Filter</button>
        </form>
        <a href="addPet" class="btn add-btn">+ Add New Pet</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Breed</th>
            <th>Type</th>
            <th>Health Status</th>
            <th>Center ID</th>
            <th>Status</th>
            <th>Created At</th>
            <th>Image</th>
            <th>Action</th>
        </tr>
        <c:forEach var="pet" items="${pets}">
            <tr>
                <td>${pet.id}</td>
                <td>${pet.name}</td>
                <td>${pet.age}</td>
                <td>${pet.breed}</td>
                <td>${pet.type}</td>
                <td>${pet.health_status}</td>
                <td>${pet.center_id}</td>
                <td>${pet.status}</td>
                <td>${pet.created_at}</td>
                <td><img src="${pet.image_url}" alt="Pet Image" class="image-preview"></td>
                <td class="action-buttons">
                    <a href="deletePet/${pet.id}" class="btn delete-btn" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
