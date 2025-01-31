package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

@Entity
@Table (name = "Usuarios")
public class Usuarios {
    @Id
    @OneToMany(cascade = CascadeType.ALL)
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
