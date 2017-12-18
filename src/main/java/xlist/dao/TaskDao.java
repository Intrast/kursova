package xlist.dao;

import xlist.models.Task;

import java.util.List;

public interface TaskDao {
    List<Task> getTaskByTaskId(long id);

    Task getTaskById(long id);
}
