package xlist.controller;

import xlist.dao.ListDao;
import xlist.dao.ListDaoImpl;
import xlist.dao.TaskDaoImpl;
import xlist.dao.UserDaoImpl;
import xlist.models.AllList;
import xlist.models.User;
import xlist.view.AllListView;
import xlist.view.CreatedView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

/**
 * Створює, відображає і видаліє замітку
 */
@WebServlet(name = "ListServlet", value = {"/list/*"})
public class ListServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(ListServlet.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        switch (request.getPathInfo()) {
            case "/create":
                ListDaoImpl listDao = new ListDaoImpl();
                TaskDaoImpl taskDao = new TaskDaoImpl();
                String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
                String comment = new String(request.getParameter("comments").getBytes("iso-8859-1"),"UTF-8");
                String task = new String(request.getParameter("task").getBytes("iso-8859-1"),"UTF-8");
                Long user_id = user.getId();
                listDao.createList(name,comment,user_id);
                taskDao.createTask(task);
                response.sendRedirect("/list/all-list");
                break;
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ListDao listDao = new ListDaoImpl();
        AllListView listView = new AllListView();
        CreatedView createdView = new CreatedView();


        switch (request.getPathInfo()) {
            case "/all-list":
                out.write("<a class=\"btn btn-default\" href=\"/list/create\" role=\"button\">Новий список</a>");
                List<AllList> list = listDao.getListByUserId(user.getId());
                out.write("<H1>List Note!</H1>");
                listView.outAllList(out, list);
                break;
            case "/view-note":
                out.write("<H1>Hello Note!</H1>");
                out.println("<button type=\"button\" class=\"btn btn-primary\">Підготовлена</button>");
                break;
            case  "/edit":
                AllList allList = listDao.getListsById(Long.parseLong(request.getParameter("id")));
                listView.outList(out, allList);
                break;
            case "/create":
                createdView.outCreated(out);
                break;
        }
    }
}
