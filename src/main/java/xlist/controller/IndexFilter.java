package xlist.controller;

import xlist.view.IndexView;
import xlist.view.PathHtmlSingleton;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Головний фільтр для виводу статичних частин html сторінки
 */
@WebFilter(filterName = "IndexFilter", value = {"/", "/list/*", "/user/*"})
public class IndexFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PathHtmlSingleton pathHtmlSingleton = PathHtmlSingleton.getInstance();
//        System.out.println("Filter path\t" + pathHtmlSingleton.getPath());
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = ((HttpServletRequest) request).getRequestURI();
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null ) {
            switch (path) {
                case "/user/register":
                case "/user/login":
                case "/":
                    break;
                default:
                    response.sendRedirect("/");
                    break;
            }
        }
        IndexView indexView = new IndexView();
        indexView.outTopPage(out);
        indexView.outMenu(out, session);
        //servlet
        chain.doFilter(request, response);
        //низ html сторінки
        indexView.outBottomPage(out);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}