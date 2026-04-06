package org.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DisplaySurvlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Get result and operation symbol from sumServlet
        Double result = (Double) req.getAttribute("result");
        String opSymbol = (String) req.getAttribute("opSymbol");

        if (result == null || opSymbol == null) {
            out.println("<h2>Error: Please submit the form first.</h2>");
            return;
        }

        // Random footer messages
        String[] footers = {
                "Keep calculating! 🔢",
                "Math is fun! 🎉",
                "Numbers never lie! ✨",
                "Powered by Java Servlets 🚀",
                "Another sum done! ✅"
        };
        Random rand = new Random();
        String randomFooter = footers[rand.nextInt(footers.length)];

        // HTML output
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculation Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background: #f9f9f9; text-align: center; padding: 50px; }");
        out.println(".container { background: #fff; padding: 40px; border-radius: 12px; box-shadow: 0 6px 12px rgba(0,0,0,0.1); display: inline-block; }");
        out.println(".result { font-size: 36px; font-weight: bold; color: #007BFF; }");
        out.println(".footer { margin-top: 30px; font-size: 14px; color: #555; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");

        out.println("<div class='result'>Result: " + result + "</div>");
        out.println("<div class='footer'>" + randomFooter + "</div>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doPost(req, res);
    }
}
