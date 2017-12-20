package xlist.models;

public class Task {
    private long id;
    private String task;
    private Long list_id;
    private Boolean check;


    public Task() {
    }

    public Task(long id, String task, Long list_id, Boolean check) {
        this.id = id;
        this.task = task;
        this.list_id = list_id;
        this.check = check;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Long getList_id() {
        return list_id;
    }

    public void setList_id(Long list_id) {
        this.list_id = list_id;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", list_id=" + list_id +
                ", check=" + check +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task1 = (Task) o;

        if (id != task1.id) return false;
        if (task != null ? !task.equals(task1.task) : task1.task != null) return false;
        if (list_id != null ? !list_id.equals(task1.list_id) : task1.list_id != null) return false;
        return check != null ? check.equals(task1.check) : task1.check == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (list_id != null ? list_id.hashCode() : 0);
        result = 31 * result + (check != null ? check.hashCode() : 0);
        return result;
    }
}