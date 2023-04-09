package bitlab.sprint.servlet;

import bitlab.sprint.db.DBManager;
import bitlab.sprint.db.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("task_id"));//присвоил айди
        }catch (Exception e){
        }

        Task task = DBManager.getTask((long) id);//Нашел с базы подходящую книгу по айди
        request.setAttribute("tAssk", task);//записал под ключ
        request.getRequestDispatcher("/details.jsp").forward(request, response);//перенаправил на сайт
    }
}
