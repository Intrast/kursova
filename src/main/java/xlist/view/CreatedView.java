package xlist.view;

import java.io.PrintWriter;

public class CreatedView {

    private PathHtmlSingleton pathHtmlSingleton;
    public CreatedView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

    public  void outCreated(PrintWriter out)
    {
    out.print("<div class=\"row\">");
    out.print("<form action=\"/list/create\" method=\"POST\" class=\"form-horizontal\">");
    out.print("<div class=\"col-xs-12 col-sm-12 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4\">");
    out.print("<div class=\"form-group\">");
    out.print("<label for=\"name\">Заголовок</label>");
    out.print("<input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"Text input\">");
    out.print("</div>");
        out.print("</div>");
    out.print("<div class=\"col-xs-12 col-sm-12 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4\">");
    out.print("<div class=\"form-group\">");
    out.print("<label for=\"comments\">Коментар</label>");
    out.print("<input type=\"text\" class=\"form-control\" id=\"comments\" name=\"comments\" placeholder=\"Text input\">");
    out.print("</div>");
        out.print("</div>");
        out.print("<div class=\"col-xs-12 col-sm-12 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4\">");
        out.print("<div class=\"form-group\">");
    out.print("<label for=\"task\">Завдання </label>");
    out.print(" <textarea class=\"form-control\" rows=\"3\" id=\"task\" name=\"task\" placeholder=\"Text input\">");
    out.print("</textarea>");
        out.print("</div>");
        out.print("</div>");
       out.print("<div class=\"col-xs-6 col-xs-offset-6 col-md-3 col-md-offset-6 col-lg-2 col-lg-offset-6\">");
    out.print("<button type=\"submit\" class=\"btn btn-default btn-block btn-margin\">Створити</button>");
        out.print("</div>");
    out.print("</form>");
    out.print("<div>");


    out.print(pathHtmlSingleton.getCreate());
    }
}
