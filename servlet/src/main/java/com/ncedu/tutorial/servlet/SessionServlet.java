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

        // set HTML page
        PrintWriter writer = response.getWriter();
        writer.append("" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Form input</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<form action=\"session\" method=\"POST\">\n" +
                "\t\tEnter your note:\n" +
                "\t\t<input type=\"text\" name=\"note\"/>\n" +
                "\t\t<input type=\"submit\" value=\"Submit\"/>\n" +
                "\t</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String note = request.getParameter("note");

        HttpSession session = request.getSession();
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }

        int currentCount = (Integer) session.getAttribute("count");
        session.setAttribute("count",  currentCount + 1);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append(
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Welcome message</title>\n" +
                "</head>\n" +
                "\t<body>");

        if (note != null && !note.trim().isEmpty()) {
            writer.append("You added a note:")
                    .append(note)
                    .append(". It is note #")
                    .append(session.getAttribute("count").toString());
        } else {
            writer.append("You did not entered note!\n");
        }

        writer.append(
                "</body>\n" +
                "</html>");
    }
}
