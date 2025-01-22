package models;
import javax.persistence.*;
import java.io.Serializable;
import  hibernate1.Principal.*;

@Entity
@Table(name= "Personas")
public class Persona implements Serializable{
        //#region Atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idPersona")
        private int idPersona;

        @Column(name="nombre")
        private String nombre;

        @Column(name="saldo")
        private double saldo;
        //#endregion
    
        //#region Constructores
        public Persona(){
    
        }
        public Persona(String nombre, double saldo){
            set_Nombre(nombre);
            set_Saldo(saldo);
        }
        //#endregion
        
        //#region GETTERS y SETTERS
        public int getId(){
            return idPersona;
        }
        public String getNombre(){
            return nombre;
        }
        public double getSaldo(){
            return saldo;
        }
        public void set_Id(int idPersona){
            this.idPersona = idPersona;
        }
        public void set_Nombre(String nombre){
            this.nombre = nombre;
        }
        public void set_Saldo(double saldo){
            this.saldo = saldo;
        }
    
    }
    
