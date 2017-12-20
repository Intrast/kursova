package xlist.view;



import xlist.models.AllList;
import xlist.models.User;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
public class AllListView {
    /**
     * Створює  сторінки із замітками
     */


        /**
         * Виводить замітки у сторінку
         * @param out виводить текст в HTML
         * @param lists список заміток, що будуть виведені
         */


    private PathHtmlSingleton pathHtmlSingleton;
    //
    public AllListView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

        public void outAllList(PrintWriter out, List<AllList> lists){
            String listsStr = lists.stream().map(l -> {
                return "<div class=\"col-xs-12 col-md-4\" >\n" +
                        "<a href=\"/list/edit?id=" + l.getId()  + "\">" +
                        "<h4>" + (l.getNameList().length() > 20 ? l.getNameList().substring(0, 20) : l.getNameList())  + "</h4>\n" +
                        "<p>" + (l.getComments().length() > 50 ? l.getComments().substring(0, 50) : l.getComments()) + "</p>\n" +
                        "</a></div>\n\n";
            }).collect(Collectors.joining(" "));

            out.println("<div class=\"row\">");
            out.println(listsStr);
            out.println("</div>");
        }

        /**
         * Виводимо форму із заміткою
         * @param out
         * @param list
         */
        public void outList(PrintWriter out, AllList list) {
            out.println("<div class=\"row\">");
            out.println(" <form action=\"/list/edit\" method=\"POST\" class=\"form-horizontal\">");
            out.println("<div class=\"col-xs-12 col-sm-12 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4\">\n" +
                    "            <div class=\"form-group\">\n" +
                    "                <label for=\"commentlist\">Заголовок</label>");
            out.println("<input type=\"email\" class=\"form-control\" id=\"commentlist\" name=\"commentlist\" value=\"" + list.getComments() + "\">");
            out.println("</div></div>");
            out.println("</form>");
            out.println("</div>");
        }
    }


