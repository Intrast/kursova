package xlist.controller;

import xlist.dao.ListDao;
import xlist.dao.ListDaoImpl;
import xlist.models.AllList;
import xlist.models.User;
import xlist.view.AllListView;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ListDao listDao = new ListDaoImpl();
        AllListView listView = new AllListView();


        switch (request.getPathInfo()) {
            case "/all-list":
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
        }
    }
}
