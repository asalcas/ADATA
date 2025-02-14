package Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Likes")
public class Likes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdLikes")
    private int idLike;
    @ManyToOne
    @JoinColumn(name="IdUsuarios", nullable=false)
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(name="IdPost", nullable=false)
    private Post post;

    public Likes(Usuarios usuario, Post post){
        this.usuario = usuario;
        this.post = post;
    }
    
    public int getIdLike(){
        return idLike;
    }
    public Usuarios getUsuario(){
        return usuario;
    }
    public Post getPost(){
        return post;
    }
}
