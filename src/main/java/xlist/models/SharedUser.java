package xlist.models;

public class SharedUser {

    private long id;
    private long list_id;
    private long user_id;

    public SharedUser() {
    }

    public SharedUser(long id, long list_id, long user_id) {
        this.id = id;
        this.list_id = list_id;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getList_id() {
        return list_id;
    }

    public void setList_id(long list_id) {
        this.list_id = list_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "SharedUser{" +
                "id=" + id +
                ", list_id=" + list_id +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SharedUser that = (SharedUser) o;

        if (id != that.id) return false;
        if (list_id != that.list_id) return false;
        return user_id == that.user_id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (list_id ^ (list_id >>> 32));
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        return result;
    }
}
