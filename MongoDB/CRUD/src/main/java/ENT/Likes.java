package ENT;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "Likes")
public class Likes {
    @Id
    private int idLike;
    @DBRef
    @Field("IdUsuario")
    private Usuarios usuario;
    @DBRef
    @Field("IdPost")

    private Posts post;

    public Likes() {

    }

    public Likes(Usuarios Usuario, Posts Post) {
        this.usuario = Usuario;
        this.post = Post;
    }

    public int getIdLike() {
        return idLike;
    }

    public Usuarios getUsuarios() {
        return usuario;
    }

    public Posts getPosts() {
        return post;
    }

    public void setUsuario(Usuarios usuarioNuevo) {
        this.usuario = usuarioNuevo;
    }

    public void setPost(Posts postNuevo) {
        this.post = postNuevo;
    }
}