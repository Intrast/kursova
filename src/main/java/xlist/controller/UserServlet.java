package xlist.controller;



import xlist.dao.UserDaoImpl;
import xlist.models.User;
import xlist.view.PathHtmlSingleton;
import xlist.view.RegisterView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(name = "UserServlet", value = {"/user/*"})
public class UserServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(UserServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //створюємо об'єкт для роботи із БД
        UserDaoImpl userDao = new UserDaoImpl();
        HttpSession session = request.getSession();

        switch (request.getPathInfo()) {
            case "/register":
                String email = request.getParameter("registerEmailLogin");
                String password = request.getParameter("registerLoginPassword");
                String name = request.getParameter("inputName");
                User user = userDao.findUserByEmail(email);
                if (user != null) {
                    //записав об'єкт користувача в сесію, щоб перевіряти в інших сервлетах чи зареєстрований користувач
                    out.write("<H1>Користувач з таким eмейлом вже існує</H1>");
                    response.sendRedirect("/user/register");
                }
                if (user == null) {
                    userDao.creatUser(email, password, name);
                    user = userDao.findUserByEmail(email);
                    //записав об'єкт користувача в сесію, щоб перевіряти в інших сервлетах чи зареєстрований користувач
                    session.setAttribute("user", user);
                    response.sendRedirect("/");
                }
                break;
            case "/login":
                email = request.getParameter("emailLogin");
                password = request.getParameter("loginPassword");
                user = userDao.findUserByEmailAndPassword(email,password);
                //якщо емейл є в БД, змінна user буде посилатись на об'єкт класу User, інакше дорівнюватиме null
                if(user != null) {
                    //записав об'єкт користувача в сесію, щоб перевіряти в інших сервлетах чи зареєстрований користувач
                    session.setAttribute("user", user);
                    }
                    response.sendRedirect("/");
                    break;
                }
        }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        RegisterView registerView = new RegisterView();

        switch (request.getPathInfo()) {
            case "/register":
                registerView.outContentRegisterPage(out, session);
                break;
            case "/logout":
                session.removeAttribute("user");
                response.sendRedirect("/");
                break;
        }
    }

}
