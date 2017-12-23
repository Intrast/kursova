package xlist.dao;

import xlist.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

   public List<Task> getTaskByListId(long id) {

        DataSource dataSource = new DataSource();

        List<Task> lstTask = new ArrayList<>();

        try (Connection con = dataSource.createConnection();

             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM task WHERE task.list_id=\"" + id + "\";");) {
            while(rs.next()){

                Task task = new Task(
                        rs.getLong("id"),
                        rs.getString("task"),
                        rs.getLong("list_id"),
                        rs.getBoolean("chek")
                );
                lstTask.add(task);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return lstTask;
    }


    @Override
    public Task createTask(String task, Long list_id) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("INSERT INTO task(task.task,task.list_id," + "task.chek)" +
                    "VALUE ('" + task + "','" + list_id + "'," + "0" + ");");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Task deleteTask(Long list_id) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;

        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("DELETE FROM task WHERE  task.list_id=\"" + list_id + "\";");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


