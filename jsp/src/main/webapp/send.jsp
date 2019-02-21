<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Echoing HTML Request Parameters</title>
</head>
<body>

    <h3>Chose additional options </h3>
    <form method="post">
        <input type="checkbox" name="option" value="Cheese">cheese
        <br>
        <input type="checkbox" name="option" value="Bacon">bacon
        <br>
        <input type="checkbox" name="option" value="Pepper">pepper
        <br>
        <br>

        <p>Comments: <input type="text" name="text"/></p>
        <br>

        <input type="submit" value="Query">
    </form>

    <%
        String text = request.getParameter("text");
        String[] authors = request.getParameterValues("option");

        if (authors != null) {
    %>

    <h3>You have selected options:</h3>
    <ul>
        <% for (int i = 0; i < authors.length; ++i) { %>

        <li><%= authors[i] %></li>

        <% } %>
    </ul>

    <p>Order comments: <%=text%></p>

    <a href="<%= request.getRequestURI() %>">BACK</a>

    <% } %>

</body>
</html>