public class Likes {
    private int idLikes;
    private int idUsuarios;
    private int idPost;

    public Likes(){

    }
    public Likes(int idLikes, int idUsuarios, int idPost){
        this.idLikes = idLikes;
        this.idUsuarios = idUsuarios;
        this.idPost = idPost;

    }

    // Getters
    public int getIdLikes(){
        return idLikes;
    }
    public int getIdUsuarios(){
        return idUsuarios;
    }
    public int getIdPost(){
        return idPost;
    }


    //// Setters
    //public void setIdLikes(int newIdLikes){
    //    this.idLikes = newIdLikes;
    //}
    //public void setIdUsuariso(int newIdUsuarios){
    //    this.idUsuarios = newIdUsuarios;
    //}
    //public void setIdPost(int newIdPost){
    //    this.idPost = newIdPost;
    //}
}
