package org.klozevitz.lesson_08;

import org.klozevitz.lesson_08.dao.DbConnection;
import org.klozevitz.lesson_08.dao.NotepadService;
import org.klozevitz.lesson_08.model.Notepad;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/id")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // исполнение логики запроса
        //completeRequest(request);
        idRequest(request);
        // перенаправление с заполненными параметрами на другую страницу
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request
                .getServletContext()
                .getRequestDispatcher("/id.jsp");
        dispatcher.forward(request, response);

    }

    private void completeRequest(HttpServletRequest request) {
        DbConnection service = new NotepadService();
        List<Notepad> all = service.all();
        service.close();
        request.setAttribute("allNotepads", all);
    }
    private void idRequest(HttpServletRequest request) {
        DbConnection service = new NotepadService();
        int idGet = Integer.parseInt(request.getParameter("id"));
        Notepad id = service.idRequest(idGet);

        service.close();
        request.setAttribute("id", id);
    }

}