package xlist.controller;

import xlist.dao.ListDao;
import xlist.dao.ListDaoImpl;
import xlist.dao.TaskDaoImpl;
import xlist.dao.UserDaoImpl;
import xlist.models.AllList;
import xlist.models.Task;
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
   private Long listId;
    private static Logger log = Logger.getLogger(ListServlet.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ListDaoImpl listDao = new ListDaoImpl();
        TaskDaoImpl taskDao = new TaskDaoImpl();
        switch (request.getPathInfo()) {
            case "/createList":
                String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
                String comment = new String(request.getParameter("comments").getBytes("iso-8859-1"),"UTF-8");
                Long user_id = user.getId();

                listDao.createList(name,comment,user_id);
                response.sendRedirect("/list/all-list");
                break;
            case "/createTask":

                String task = new String(request.getParameter("task").getBytes("iso-8859-1"),"UTF-8");
                taskDao.createTask(task,listId);
                response.sendRedirect("/list/edit?id="+listId);
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
        TaskDaoImpl taskDao = new TaskDaoImpl();
        CreatedView createdView = new CreatedView();


        switch (request.getPathInfo()) {
            case "/all-list":
                out.write("<a class=\"btn btn-default\" href=\"/list/createList\" role=\"button\">Новий список</a>");
                List<AllList> list = listDao.getListByUserId(user.getId());
                listView.outAllList(out, list);
                break;
            case  "/edit":
               // out.print("<div class=\"col-lg-10 col-lg-offset-1\">");
                out.print("<a class=\"btn btn-default\" href=\"/list/createTask\" role=\"button\">Додати завдання</a>" +
                          "  <a class=\"btn btn-default \" href=\"/list/delete\" role=\"button\">Видалити cписок</a>");
              //  out.print("</div>");
                AllList allList = listDao.getListsById(Long.parseLong(request.getParameter("id")));
                listId = allList.getId();
                List<Task> task = taskDao.getTaskByListId(listId);
                listView.outList(out, allList, task);
                break;
            case "/createList":
                createdView.outCreatedList(out);
                break;
            case "/createTask":
                createdView.outCreatedTask(out);
                break;
            case "/delete":
                taskDao.deleteTask(listId);
                listDao.deleteList(listId);
                response.sendRedirect("/list/all-list");
                break;
        }
    }
}
