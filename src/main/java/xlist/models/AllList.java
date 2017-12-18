package xlist.models;

public class AllList {

    private long id;
    private String nameList;
    private String comments;
    private Long user_id;
    private String dataCreated;

    public AllList() {
    }

    public AllList(long id, String nameList, String comments, Long user_id, String dataCreated) {
        this.id = id;
        this.nameList = nameList;
        this.comments = comments;
        this.user_id = user_id;
        this.dataCreated = dataCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(String dataCreated) {
        this.dataCreated = dataCreated;
    }

    @Override
    public String toString() {
        return "AllList{" +
                "id=" + id +
                ", nameList='" + nameList + '\'' +
                ", comments='" + comments + '\'' +
                ", user_id=" + user_id +
                ", dataCreated='" + dataCreated + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllList allList = (AllList) o;

        if (id != allList.id) return false;
        if (nameList != null ? !nameList.equals(allList.nameList) : allList.nameList != null) return false;
        if (comments != null ? !comments.equals(allList.comments) : allList.comments != null) return false;
        if (user_id != null ? !user_id.equals(allList.user_id) : allList.user_id != null) return false;
        return dataCreated != null ? dataCreated.equals(allList.dataCreated) : allList.dataCreated == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nameList != null ? nameList.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (dataCreated != null ? dataCreated.hashCode() : 0);
        return result;
    }
}
