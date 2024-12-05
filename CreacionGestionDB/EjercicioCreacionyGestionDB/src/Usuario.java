public class Usuario {
    private int idUsuarios;
    private String Nombre;
    private String Apellidos;
    private String Username;
    private String Password;
    private String Email;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String username, String password, String email) {
        Nombre = nombre;
        Apellidos = apellidos;
        Username = username;
        Password = password;
        Email = email;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

}
