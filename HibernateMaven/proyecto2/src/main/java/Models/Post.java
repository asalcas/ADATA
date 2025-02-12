package Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdPost")
    private int idPost;
    @ManyToOne
    @JoinColumn(name="IdUsuarios", nullable=false)
    private Usuarios usuario;
    @Column(name="Created_at")
    private LocalDate created_at;
    @Column(name="Updated_at")
    private LocalDate updated_at;

    public Post(){

    }
    public Post(Usuarios usuario, LocalDate created_at, LocalDate updated_at){
        this.usuario = usuario;
        this.created_at = created_at;
        this.updated_at = null;
    }

    public int getIdPost(){
        return idPost;
    }
    public Usuarios getUsuario(){
        return usuario;
    }
    public LocalDate getCreated_at(){
        return created_at;
    }
    public LocalDate getUpdated_at(){
        return updated_at;
    }
    public void setCreated_at(LocalDate Created_at){
        this.created_at = Created_at;
    }
    public void setUpdated_at(LocalDate Updated_at){
        this.updated_at = Updated_at;
    }


}
