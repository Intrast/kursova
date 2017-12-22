package xlist.dao;

import xlist.models.Task;

import java.util.List;

public interface TaskDao {
   // List<Task> getTaskByTaskId(long id);
   // Task getTaskById(long id);


    Task  createTask(String task, Long list_id);
    Task  deleteTask(Long list_id);
}
