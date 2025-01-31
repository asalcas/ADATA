package Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="Likes")
public class Likes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdLikes")
    private int idLike;
    @ManyToOne
    @JoinColumn(name="idUsuarios")
    private int idUsuario;
    @ManyToOne
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
