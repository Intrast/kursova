package xlist.dao;

import xlist.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

 /*  public List<Task> getTaskByListId(long id) {
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
    }*/

@Override
    public Task createTask(String task)
    {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;

        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("INSERT INTO task(task.task,"+ "task.list_id,task.chek)" +
                    "VALUE ('" + task + "'," + "0" + ");");
            stmt.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }
}

