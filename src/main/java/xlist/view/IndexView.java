package xlist.view;

import xlist.models.User;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Виводить HTML сторінку bootstrap
 */
public class IndexView {

  private PathHtmlSingleton pathHtmlSingleton;
//
    public IndexView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

    public void outTopPage(PrintWriter out){
        out.println(pathHtmlSingleton.getTop());
    }


    public void outBottomPage(PrintWriter out){
        out.println(pathHtmlSingleton.getBottom());
    }

    public  void outMenu(PrintWriter out, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null) {
            out.print(pathHtmlSingleton.getMenu());
        } else {
            out.print(pathHtmlSingleton.getMenuLogin());
        }
    }

    public  void outContentIndexPage(PrintWriter out, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null) {
            out.write("<center><H2>Авторизація</H2></center>");
            out.write(pathHtmlSingleton.getLogin());
        } else {
            out.println("<center><h2>Ви увійшли як  " + user.getName() + "</h2></center>");
        }
    }
}
