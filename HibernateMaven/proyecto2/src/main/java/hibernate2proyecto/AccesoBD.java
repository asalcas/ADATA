package hibernate2proyecto;
import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AccesoBD {
    
    private SessionFactory sf; // Es el creador de la sesión que da acceso a la base de datos.
    private Session sesion; // Es el 'puente' que conecta la BD, ya que el que activa la sesion.
    private Transaction transaction; // Se encarga de hacer un rollback si algo sale mal.

    // Tenemos que crear un método que lo que hará será configurar todo lo necesario
    // para conectar con la base de datos usando Hibernate

    /**
     * función que configura la conexión a la base de datos
     * pre: none
     * pos: 'sf' no debe ser NULL
     * return: none, pero asigna un valor a 'sf'
     */
    protected void setUp(){
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        final StandardServiceRegistry registro = new StandardServiceRegistryBuilder()
                                                .configure() // por defecto usa la configuración de: hibernate.cfg.xml
                                                .build();

        try{
            // Aqui estamos creando un 'SessionFactory' que permite iniciar sesion y trabajar con la base de datos.
            // Es como el 'gestor' de las sesiones que nos ayudará a conectar cada vez que lo necesitemos
            sf = new MetadataSources(registro).buildMetadata().buildSessionFactory();
        }catch(Exception e){
            System.err.println(e.getMessage());
            StandardServiceRegistryBuilder.destroy(registro);
        }
    }
    /**
     * Funcion que utiliza 'sf' de la funcion "setUp()" para abrir una sesion con la que realizaremos ciertos
     * cambios en la base de datos, para prevenir errores abrimos una transacción tambien
     * @throws Exception
     * pre: 'sf' no puede ser NULL
     * pos: none
     */
    public void abrir() throws Exception{
        
        setUp();
        sesion = sf.openSession();
        transaction = sesion.beginTransaction();
        
    }
    /**
     * Funcion que se encarga de hacer Commit o Rollback según si la ejecución es correcta o no
     */
    public void cerrar(){
        try {
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
        }
        sf.close();
    }
    /**
     * Funcion que recibe un Object que guardaremos en la base de datos
     * @param cosa
     * pre: cosa no puede ser NULL
     */
    public void guardar(Object cosa){
        sesion.persist(cosa);
        System.out.println("Has guardado el Objeto con exito: \n"+ cosa);
    }
    public Session get_sesion(){
        return sesion;
    }
}


// Logica de la clase: 
/*  1º SetUp(): 
        Configuramos el acceso a la base de datos, con "StandarServiceRegistry", 
        .configure() se encarga de seleccionar el archivo de configuración que queramos o el por defecto (hibernate.cfg.xml)
        .build() para que construya el acceso a la base de datos y lo retorne.

        Creamos una SessionFactory que nos permite iniciar sesión y trabajar en la base de datos, los datos anteriores se los pasamos
        por parametros a MetadataSources
        .buildMetadata() hacemos posible que podamos utilizar los metadatos predeterminados 
        .buildSessionFactory() Creamos la sesion que nos permitirá realizar las operaciones necesarias dentro de la base de datos.

    2º Abrir():

 */