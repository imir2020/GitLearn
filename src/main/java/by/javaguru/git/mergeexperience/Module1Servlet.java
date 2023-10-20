package by.javaguru.git.mergeexperience;

import java.io.*;

import by.javaguru.git.mergeexperience.topics.Module1Topics;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * Запушить изменения в отдалённый репозиторий и скинуть на проверку
 */
@WebServlet("/module1")
public class Module1Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Модуль 1";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println("<table>");
        for (Module1Topics value : Module1Topics.values()) {
            out.println("<tr><td>"
                    + value.getOrder() + "</td><td>"
                    + value.getTopic() + "</td><td>"
                    + value.getDesc()
                    + "</td><td><a href=''>Подробнее</a>"
                    + "</td></tr>");

            out.println("</table>");
        }

        //Добавка кнопок
        out.println("""
                <br/>
                <br/>
                <button type="button">
                    <a href="description.html">Описание</a>
                </button>
                <br/>
                <br/>                
                """);

        out.println("</body></html>");

        out.println("""
                <form>
                <button type='submit' formaction='module4'> <- </button>
                <button type='submit' formaction='module2'> -> </button>
                </form>
                """
        );
    }

    public void destroy() {
    }
}