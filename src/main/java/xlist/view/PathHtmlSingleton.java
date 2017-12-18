package xlist.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Має змінні String, які містять html файли. Реалізує патерн Singleton
 */
public class PathHtmlSingleton {

    /**
     * Шлях до папки HTML із файлами
     */
    private String path = "";
    /**
     * Змінні, що містять значення відповідних файлів з папки HTML
     */
    private String top;
    private String menu;
    private String registration;
    private String bottom;
    private String login;

    private static PathHtmlSingleton ourInstance = new PathHtmlSingleton();

    public static PathHtmlSingleton getInstance() {
        return ourInstance;
    }

    private PathHtmlSingleton() {
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = getPartialHtml(top);
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = getPartialHtml(menu);
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = getPartialHtml(bottom);
    }

    public String getLogin() {return login; }

    public void setLogin(String login) { this.login = getPartialHtml(login); }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = getPartialHtml(registration);
    }

    /**
     * Зчитує файл
     * @param filename назва  файлу
     * @return вміст зчитаного файлу
     */
    private String getPartialHtml(String filename){
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.path + filename);
        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return strb.toString();
    }
}
