package Models;

import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table (name = "Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuarios")
    private int idUsuario;

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Username")
    private String username;
    @Column(name ="Password")
    private String password;
    @Column(name = "Email")
    private String email;

    public Usuarios()
    {
        
    }

    public Usuarios(String Nombre, String Apellidos, String Username, String Password, String Email) {
        this.nombre = Nombre;
        this.apellidos = Apellidos;
        this.username= Username;
        this.password = Password; // Hashed al hacer la consulta
        this.email = Email;
    }

    // Getters y Setters

    public int getIdUsuario(){
        return idUsuario;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }

    public void setNombre(String Nombre){
        this.nombre = Nombre;
    }
    public void setApellidos(String Apellidos){
        this.apellidos = Apellidos;
    }
    public void setUsername(String Username){
        this.username = Username;
    }
    public void setPassword(String Password){
        this.password = Password;
    }
    public void setEmail(String Email){
        this.email = Email;
    }
}
