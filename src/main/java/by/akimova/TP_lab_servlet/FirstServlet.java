package by.akimova.TP_lab_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@WebServlet("/CalculateServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double result = 0;
        String error = "";

    //    String messageResult;                                   // строка результата
        String num1 = request.getParameter("num1"); //получаем первое число для операции
        String num2 = request.getParameter("num2"); //получаем второе число для операции

        if (!num1.isEmpty() && !num2.isEmpty()) {  // проверяем пришедшие значения на наличие
            double a1 = Double.parseDouble(num1);  // конвертируем строку в double
            double a2 = Double.parseDouble(num2);

String str = new String("");

            try {
            char parameters = request.getParameter("parameters").charAt(0); // получаем map по input c формы, в котором name - ключ, value - значение
            switch(parameters) {
                case '+':
                    result =  a1 + a2;
                    str = new String(a1 + "+" + a2 + "=" + result);
                    break;
                case '-':
                    result =  a1 - a2;
                    str = new String(a1 + "-" + a2 + "=" + result);
                    break;
                case '*':
                    result =  a1 * a2;
                    str = new String(a1 + "*" + a2 + "=" + result);
                    break;
                case '/':
                    result =  a1 / a2;
                    str = new String(a1 + "/" + a2 + "=" + result);
                    break;
            }
        }
		catch(ArithmeticException e) {
            error = "Деление на ноль запрещено";
        }
        request.setAttribute("result", Double.toString(result));
        request.setAttribute("str", (str));
        request.setAttribute("error", error);
        this.doGet(request, response);
    }

        }
    }
