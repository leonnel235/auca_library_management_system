<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Fetch any error messages passed as request attributes
    String errorMessage = (String) request.getAttribute("errorMessage");
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
%>
<html>
<head>
    <title>Error Handling - Login</title>
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
        .error-code {
            font-size: 18px;
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
<% if (errorMessage != null) { %>
    <p class="error-message"><%= errorMessage %></p>
<% } %>

<% if (statusCode != null) { %>
    <p class="error-code">Error Code: <%= statusCode %></p>
    <% if (statusCode == 404) { %>
        <p>The page you requested could not be found. Please check the URL.</p>
    <% } else if (statusCode == 500) { %>
        <p>There was an internal server error. Please try again later.</p>
    <% } %>
<% } else if (errorMessage != null && errorMessage.equals("Invalid username or password.")) { %>
    <p class="error-code">Login Error: <%= errorMessage %></p>
<% } %>

<p><a href="Login.html">Go back to login</a></p>
</body>
</html>
