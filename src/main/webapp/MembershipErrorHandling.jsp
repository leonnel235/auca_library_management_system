<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Membership Registration Error</title>
    <style>
        /* General styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        /* Error container */
        .error-container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px 30px;
            width: 400px;
            text-align: center;
        }

        /* Heading */
        h2 {
            color: #e74c3c; /* Red color for error messages */
            margin-bottom: 20px;
        }

        /* Error message styling */
        .error-message {
            color: #555;
            margin-bottom: 20px;
        }

        /* Back button styling */
        .back-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #3498db;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .back-btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<div class="error-container">
    <h2>Registration Error</h2>
    <div class="error-message">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "An unknown error occurred." %>
    </div>
    <a href="MembershipRegistration.html" class="back-btn">Back to Registration</a>
</div>

</body>
</html>
