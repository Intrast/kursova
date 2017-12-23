package xlist.dao;

import xlist.models.Task;

import java.util.List;

public interface TaskDao {
   List<Task> getTaskByListId(long id);
   Task  createTask(String task, Long list_id);
   Task  deleteTask(Long list_id);
}
