package Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Likes")
public class Likes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdLikes")
    private int idLike;
    //@ManyToOne
    @JoinColumn(name="idUsuarios")
    private int idUsuario;
    //@ManyToOne
    @JoinColumn(name="IdPost")
    private int idPost;
    
    public int getIdLike(){
        return idLike;
    }
    public int getIdUsuario(){
        return idUsuario;
    }
    public int getIdPost(){
        return idPost;
    }
}
