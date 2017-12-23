package xlist.view;

import java.io.PrintWriter;

public class CreatedView {

    private PathHtmlSingleton pathHtmlSingleton;

    public CreatedView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

    public void outCreatedList(PrintWriter out) {
       out.print(pathHtmlSingleton.getCreateList());
    }

    public void outCreatedTask(PrintWriter out)
    {
        out.print(pathHtmlSingleton.getCreateTask());
    }

}
