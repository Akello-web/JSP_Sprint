package bitlab.sprint.servlet;

import bitlab.sprint.db.DBManager;
import bitlab.sprint.db.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-task")
public class addTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String deadline = request.getParameter("task_deadline");
        String status = request.getParameter("task_status");

        Task newtask = new Task();
        newtask.setName(name);
        newtask.setDescription(description);
        newtask.setDeadlineDate(deadline);

        DBManager.addTask(newtask);
        response.sendRedirect("/");
    }
}
