package xlist.controller;

import xlist.view.IndexView;
import xlist.view.PathHtmlSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.*;

@WebServlet(name = "StartServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class StartServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(StartServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        HttpSession session = request.getSession();
        indexView.outContentIndexPage(out, session);
        log.fine("Output index page");
    }
    @Override
    public void init() throws ServletException {
        super.init();
        PathHtmlSingleton pathHTML = PathHtmlSingleton.getInstance();
        if(pathHTML.getPath().equals("")) {
            pathHTML.setPath(getServletContext().getRealPath("/html/"));
        }
        pathHTML.setTop("top.html");
        pathHTML.setMenu("menu.html");
        pathHTML.setMenuLogin("menuLogin.html");
        pathHTML.setBottom("bottom.html");
        pathHTML.setRegistration("registration.html");
        pathHTML.setLogin("login.html");
        pathHTML.setCreateList("createList.html");
        pathHTML.setCreateTask("createTask.html");

        try {

            Handler fh = new FileHandler(getServletContext()
                    .getRealPath("/logs/app.log"));
            Logger.getLogger("").addHandler(fh);
            Logger.getLogger("").addHandler(new ConsoleHandler());
            Logger.getLogger("").setLevel(Level.ALL);

        } catch (IOException e) {
            e.printStackTrace();
        }

        log.config("Created log file " + getServletContext()
                .getRealPath("/logs/app.log"));
    }
}
