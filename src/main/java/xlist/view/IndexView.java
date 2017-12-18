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
            out.println(pathHtmlSingleton.getMenu());
        } else {
            String menu = pathHtmlSingleton.getMenu();
            String logout = " <ul class=\"nav navbar-nav navbar-right\">\n" +
                    "                <li><a class=\"btn btn-primary\" href=\"/user/logout\">" + "Logout " + user.getEmail() +
                    "                </a></li>\n" +
                    "         </ul>";

            menu = menu.replace("<!--insert-logout-->", logout);
            out.println(menu);
        }
    }

    public  void outContentIndexPage(PrintWriter out, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null) {
            out.write("<center><H2>Авторизація</H2></center>");
            out.write(pathHtmlSingleton.getLogin());
        } else {
            out.println("<h2>Ви увійшли як  " + user.getName() + "</h2>");
        }
    }
}
