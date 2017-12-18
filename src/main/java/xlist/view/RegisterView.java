package xlist.view;

import xlist.models.User;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class RegisterView {
    private PathHtmlSingleton pathHtmlSingleton;

    public RegisterView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }
    public void outContentRegisterPage(PrintWriter out, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            out.write("<center><H2>Реєстрація</H2></center>");
            out.print(pathHtmlSingleton.getRegistration());
        } else {
            out.println("<h2>Ви зареєструвались як  " + user.getName() + "</h2>");
        }
    }
}
