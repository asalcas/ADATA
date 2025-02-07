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
    @JoinColumn(name="idUsuarios", nullable=false)
    private Usuarios idUsuario;
    @ManyToOne
    @JoinColumn(name="IdPost", nullable=false)
    private Post idPost;
    
    public int getIdLike(){
        return idLike;
    }
    public Usuarios getIdUsuario(){
        return idUsuario;
    }
    public Post getIdPost(){
        return idPost;
    }
}
