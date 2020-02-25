package com.taotao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>名称</th>");
        out.println("<th>实际的值</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            for (String value : entry.getValue()) {
                tr(out, entry.getKey(), value);
            }
        }
        System.out.println(req.getParameter("你好"));
        System.out.println(Arrays.toString(req.getParameterValues("你好")));

        /*
        String method = req.getMethod();
        tr(out, "HTTP 方法", method);

        String pathInfo = req.getPathInfo();
        tr(out, "PathInfo", pathInfo);

        String pathTranslated = req.getPathTranslated();
        tr(out, "PathTranslated", pathTranslated);

        String contextPath = req.getContextPath();
        tr(out, "ContextPath", contextPath);

        String url = req.getRequestURI();
        tr(out, "RequestURI", url);

        String queryString = req.getQueryString();
        tr(out, "QueryString", queryString);
        */

        out.println("</tbody");
        out.println("</table");

        //Enumeration<String> headerNames = req.getHeaderNames();
    }

    private void tr(PrintWriter out, String name, String value) {
        out.println("<tr>");
        out.printf("<td>%s</td>%n", name);
        out.printf("<td>%s</td>%n", value);
        out.println("</tr>");
    }
}

