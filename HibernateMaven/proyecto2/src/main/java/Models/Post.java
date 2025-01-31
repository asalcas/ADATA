package Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Posts")
public class Post {
    @Id
    @OneToMany(cascade=CascadeType.ALL)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdPost")
    private int idPost;
    @ManyToOne
    @JoinColumn(name="IdUsuarios")
    private int idUsuarios;
    @Column(name="Created_at")
    private Date created_at;
    @Column(name="Updated_at")
    private Date updated_at;

    public int getIdPost(){
        return idPost;
    }
    public int getIdUsuario(){
        return idUsuarios;
    }
    public Date getCreated_at(){
        return created_at;
    }
    public Date getUpdated_at(){
        return updated_at;
    }
    public void setCreated_at(Date Created_at){
        this.created_at = Created_at;
    }
    public void setUpdated_at(Date Updated_at){
        this.updated_at = Updated_at;
    }


}
