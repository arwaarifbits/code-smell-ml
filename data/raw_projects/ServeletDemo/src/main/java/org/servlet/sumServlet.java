package org.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class sumServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 1. Get numbers from form
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        // 2. Get the operation from the form
        String operation = req.getParameter("operation");

        // 3. Calculate result based on selected operation
        double result = 0;
        String opSymbol = "";

        switch (operation) {
            case "add":
                result = num1 + num2;
                opSymbol = "+";
                break;
            case "subtract":
                result = num1 - num2;
                opSymbol = "-";
                break;
            case "multiply":
                result = num1 * num2;
                opSymbol = "×";
                break;
            case "divide":
                if (num2 != 0) {
                    result = (double) num1 / num2;
                } else {
                    result = Double.NaN; // division by zero
                }
                opSymbol = "÷";
                break;
        }

        // 4. Get servlet and context info (optional)
        ServletConfig conf = getServletConfig();
        String servletDesc = conf.getInitParameter("ServletDescription");

        ServletContext cnxt = getServletContext();
        String appName = cnxt.getInitParameter("appName");

        // 5. Set attributes to forward
        req.setAttribute("fNum", num1);
        req.setAttribute("sNum", num2);
        req.setAttribute("operation", operation);
        req.setAttribute("opSymbol", opSymbol);
        req.setAttribute("result", result);
        req.setAttribute("servletDesc", servletDesc);
        req.setAttribute("appName", appName);

        // 6. Forward to DisplayServlet
        RequestDispatcher rd = req.getRequestDispatcher("display");
        rd.forward(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res); // support GET if needed
    }
}
