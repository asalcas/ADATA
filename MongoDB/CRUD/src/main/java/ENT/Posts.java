package ENT;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Posts")
public class Posts {

    @Id
    @Field("IdPost")
    private int idPost;
    @DBRef
    @Field("IdUsuario")
    private Usuarios usuario;
    @Field("Created_at")
    private LocalDate created_at;
    @Field("Updated_at")
    private LocalDate updated_at;

    @Field("Likes")
    private List<Likes> listaLikes;

    public Posts(){

    }
    public Posts(Usuarios Usuario, LocalDate Created_at, LocalDate Updated_at){
        this.usuario = Usuario;
        this.created_at = Created_at;
        this.updated_at = Updated_at;
    }


    public int getIdPost(){
        return idPost;
    }
    public Usuarios getIdUsuarios(){
        return usuario;
    }
    public LocalDate getCreated_at(){
        return created_at;
    }
    public LocalDate getUpdated_at(){
        return updated_at;
    }

    public List<Likes> getListaLikes(){
        return listaLikes;
    }

    public void setIdUsuario(Usuarios nuevoUsuario){
        this.usuario = nuevoUsuario;
    }
    public void setCreated_at(LocalDate nuevoCreated_at){
        this.created_at = nuevoCreated_at;
    }
    public void setUpdated_at(LocalDate nuevoUpdated_at){
        this.updated_at = nuevoUpdated_at;
    }
}
