package xlist.models;

public class Task {
    private long id;
    private String listName;
    private Boolean check;


    public Task() {
    }

    public Task(long id, String listName, Boolean check) {
        this.id = id;
        this.listName = listName;
        this.check = check;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
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
                ", listName='" + listName + '\'' +
                ", check=" + check +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (listName != null ? !listName.equals(task.listName) : task.listName != null) return false;
        return check != null ? check.equals(task.check) : task.check == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (listName != null ? listName.hashCode() : 0);
        result = 31 * result + (check != null ? check.hashCode() : 0);
        return result;
    }
}
