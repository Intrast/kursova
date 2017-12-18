/*package xlist.view;


import xlist.models.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class TaskView {

    public void outTask(PrintWriter out, List<Task> tasks){
        String taskStr = tasks.stream().map(l -> {
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
}
*/