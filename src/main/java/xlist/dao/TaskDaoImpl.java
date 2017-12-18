/*package xlist.dao;

import xlist.models.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl {

    public List<Task> getTaskByListId(long id) {
        //створює об'єкт для завантаження драйвера
        DataSource dataSource = new DataSource();
        //Контейнер для заміток
        List<Task> lstTask = new ArrayList<>();
        //отримує зв'язок з БД
        try (Connection con = dataSource.createConnection();
             //створює об'єкт для виконання SQL запитів
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM task WHERE task.list_id=\"" + id + "\";");) {
            while(rs.next()){
                //створюємо об'єкт класу User на основі даних отриманих із БД
                Task task = new Task(
                        rs.getLong("id"),
                        rs.getString("task"),
                        rs.getLong("list_id"),
                        rs.getInt("chek")
                );
                lstTask.add(task);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return lstTask;
    }

    @Override
    public Task getTaskById(long id) {
        //створює об'єкт для завантаження драйвера
        DataSource dataSource = new DataSource();
        //Контейнер для заміток
        List<Task> lstTask = new ArrayList<>();
        //отримує зв'язок з БД
        try (Connection con = dataSource.createConnection();
             //створює об'єкт для виконання SQL запитів
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM task WHERE task.id=\"" + id + "\";");) {
            if(rs.next()){
                //створюємо об'єкт класу User на основі даних отриманих із БД
                Task task = new Task(
                        rs.getLong("id"),
                        rs.getString("task"),
                        rs.getLong("list_id"),
                        rs.getInt("chek")
                        );
                return task;
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
}
*/