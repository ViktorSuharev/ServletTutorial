<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    Integer count = (Integer) httpSession.getAttribute("count");

    String note = request.getParameter("note");
%>


<% if (note != null) { %>
    <p>You added note: </p>
    <%= note %>
<% } %>

<% if (count != null) { %>
    <p>It is note #</p>
    <%= count %>
<% } %>

<%
    count = 0;
    httpSession.setAttribute("count", count + 1);
%>

</body>
</html>
