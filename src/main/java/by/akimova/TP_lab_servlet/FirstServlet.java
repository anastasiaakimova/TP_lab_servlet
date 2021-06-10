package by.akimova.TP_lab_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("src/webapp/index.jsp").forward(request, response);
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

            try {
            char parameters = request.getParameter("parameters").charAt(0); // получаем map по input c формы, в котором name - ключ, value - значение
            switch(parameters) {
                case '+':
                    result =  a1 + a2;
                    break;
                case '-':
                    result =  a1 - a2;
                    break;
                case '*':
                    result =  a1 * a2;
                    break;
                case '/':
                    result =  a1 / a2;
                    break;
            }
        }
		catch(ArithmeticException e) {
            error = "Деление на ноль запрещено";
        }
        request.setAttribute("result", Double.toString(result));
        request.setAttribute("error", error);
        this.doGet(request, response);
    }



//            if (parameters.containsKey("+")) {           // проверяем какое действие было выполнено
//                result = a1+a2;
//            } else if (parameters.containsKey("-")) {
//                result = a1-a2;
//            } else if (parameters.containsKey("*")) {
//                result = a1*a2;
//            } else if (parameters.containsKey("/")) {
//                result = a1/a2;
//            }
//            messageResult = String.valueOf((double) result);            // если все ок, конвертируем результат операции в строку и присваиваем messageResult
//        } else {
//            messageResult = "Одно из чисел не было введено. Пожалуйста, попробуйте снова."; // если не введено одно из чисел для вычисления, в messageResult записывается текст ошибки
//        }
//        response(response, messageResult); // запускаем метод response для вывода формы с результатом



//            switch (command) {
//            case "+":
//                result = num1 + num2;
//                operation = "+";
//                break;
//            case "-":
//                result = num1 - num2;
//                operation = "-";
//                break;
//            case "*":
//                result = num1 * num2;
//                operation = "*";
//                break;
//            case "/":
//                result = num1 / num2;
//                operation = "/";
//                break;
//        }
//        String action = String.format("%d %s %d = %d", num1, operation, num2, result);

        }
    }
