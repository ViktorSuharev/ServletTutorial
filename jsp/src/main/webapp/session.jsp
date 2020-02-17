<html>
<head>
    <title>Increment</title>
</head>
<body>

<form method="post">
    Enter your note:
    <input type="text" name="note" />
    <input type="submit" value="Increment">
</form>

<%
    HttpSession httpSession = request.getSession();
    if (httpSession.getAttribute("count") == null) {
        httpSession.setAttribute("count", 1);
    }

    int count = (Integer) httpSession.getAttribute("count");

    String note = request.getParameter("note");
%>

<% if (note == null && count != 1) { %>
    <p>You did not entered note!</p>
<% } else if (note != null) { %>
    <p>You added note: <%= note %></p>
    <p>It is note # <%= count %></p>
    <% httpSession.setAttribute("count", count + 1); %>
<% } %>

</body>
</html>
