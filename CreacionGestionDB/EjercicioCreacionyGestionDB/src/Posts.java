import java.sql.Date;

public class Posts {
    private int idPost;
    private int idUsuarios;
    private Date created_at;
    private Date updated_at;

    public Posts(int idUsuarios, Date created_at, Date updated_at){
        this.idUsuarios = idUsuarios;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    // Getters
    public int getIdPost() {
        return idPost;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    //// Setters
    //public void setIdPost(int newIdPost) {
    //    this.idPost = newIdPost;
    //}
//
    //public void setIdUsuarios(int newIdUsuarios) {
    //    this.idUsuarios = newIdUsuarios;
    //}
//
    //public void setCreated_at(Date newCreated_at) {
    //    this.created_at = newCreated_at;
    //}
//
    //public void setUpdated_at(Date newUpdated_at) {
    //    this.updated_at = newUpdated_at;
    //}
}
