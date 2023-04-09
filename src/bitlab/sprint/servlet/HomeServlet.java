package bitlab.sprint.servlet;

import bitlab.sprint.db.DBManager;
import bitlab.sprint.db.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList<Task> tasks = DBManager.getAllTasks();
        request.setAttribute("tusks", tasks);//причисляю ключ
        request.getRequestDispatcher("/tasks.jsp").forward(request, response);//перенаправляю на сайт
    }
}
