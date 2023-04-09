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
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String deadline = request.getParameter("task_deadline");
        boolean status = Boolean.parseBoolean(request.getParameter("task_status"));

        Task newtask = new Task();
        newtask.setName(name);
        newtask.setDescription(description);
        newtask.setDeadlineDate(deadline);
        newtask.setStatus(status);

        DBManager.addTask(newtask);
        System.out.print(newtask.getDeadlineDate());
        response.sendRedirect("/");
    }
}
