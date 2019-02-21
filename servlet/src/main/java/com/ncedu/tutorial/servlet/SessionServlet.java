package com.ncedu.tutorial.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // set response headers
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // create HTML form
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Form input</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n")
                .append("			<form action=\"session\" method=\"POST\">\r\n")
                .append("				Enter your note: \r\n")
                .append("				<input type=\"text\" name=\"note\" />\r\n")
                .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
                .append("			</form>\r\n")
                .append("		</body>\r\n")
                .append("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String note = request.getParameter("note");

        HttpSession session = request.getSession();
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }

        session.setAttribute("count", ((Integer) session.getAttribute("count")) + 1);
        session.getAttribute("count");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // create HTML response
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Welcome message</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n");

        if (note != null && !note.trim().isEmpty()) {
            writer.append("	You added note:")
                    .append(note)
                    .append(". It is note #")
                    .append(session.getAttribute("count").toString());
        } else {
            writer.append("	You did not entered note!\r\n");
        }
        writer.append("		</body>\r\n")
                .append("</html>\r\n");
    }
}
