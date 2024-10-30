<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Fetch any error messages passed as request attributes
    String errorMessage = (String) request.getAttribute("errorMessage");
    String username = (String) request.getAttribute("username");
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

    // Check if statusCode is null and set a default value or handle it
    if (statusCode == null) {
        statusCode = 500; // Default to 500 Internal Server Error
    }
%>
<html>
<head>
    <title>Error Handling</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
        .success-message {
            color: green;
            font-weight: bold;
        }
        a {
            text-decoration: none;
            color: blue;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<% if (errorMessage == null) { %>
    <!-- Registration success message -->
    <p class="success-message">Registration successful! Welcome, <%= username != null ? username : "User" %>.</p>
<% } else { %>
    <!-- Display the error message -->
    <p class="error-message">Error: <%= errorMessage %></p>

    <% if (statusCode == 404) { %>
        <p>The page you requested could not be found. Please check the URL.</p>
    <% } else if (statusCode == 500) { %>
        <p>There was an internal server error. Please try again later.</p>
    <% } else { %>
        <p>An unexpected error occurred. Status Code: <%= statusCode %></p>
    <% } %>
    
    <p><a href="UserRegistration.html">Go back to registration</a></p>
<% } %>
</body>
</html>
