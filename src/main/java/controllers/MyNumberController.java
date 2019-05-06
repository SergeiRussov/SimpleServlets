package controllers;

import entity.MyNumber;
import util.Calculations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyNumberController", urlPatterns = "/Calculations")
public class MyNumberController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestMyNumber requestMyNumber = RequestMyNumber.fromRequestParameters(request);
        requestMyNumber.setAsRequestAttributes(request);

        String url = "/WEB-INF/views/answer.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    private static class RequestMyNumber {

        private double x;
        private double y;
        private double answer;

        public RequestMyNumber(double x, double y, double answer) {
            this.x = x;
            this.y = y;
            this.answer = answer;
        }

        public static RequestMyNumber fromRequestParameters(HttpServletRequest request) {
            return new RequestMyNumber(
                    Double.parseDouble(request.getParameter("x")),
                    Double.parseDouble(request.getParameter("y")),
                    getAnswer(request));
        }

        public void setAsRequestAttributes(HttpServletRequest request) {
            request.setAttribute("x", x);
            request.setAttribute("y", y);
            request.setAttribute("answer", answer);
        }

        public static double getAnswer(HttpServletRequest request) {
            Calculations calculations = new Calculations();
            double x = Double.parseDouble(request.getParameter("x"));
            double y = Double.parseDouble(request.getParameter("y"));
            double answer = 0;

            String operation = request.getParameter("operation");

            switch (operation) {
                case "To add":
                    answer = calculations.toAdd(x, y);
                    break;
                case "To substract":
                    answer = calculations.toSubstract(x, y);
                    break;
                case "To multiply":
                    answer = calculations.toMultiply(x, y);
                    break;
                case "To split":
                    answer = calculations.toSplit(x, y);
                    break;
                case "Calculate percentage":
                    answer = calculations.calculatePercentage(x, y);
                    break;
            }

            return answer;
        }
    }
}
