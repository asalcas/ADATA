package hibernate1;

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

    protected void setUp(){
        final StandardServiceRegistry registro = new StandardServiceRegistryBuilder()
                                                .configure() // por defecto usa la configuración de: hibernate.cfg.xml
                                                .build();

        try{
            // Aqui estamos creando un 'SessionFactory' que permite iniciar sesion y trabajar con la base de datos.
            // Es como el 'gestor' de las sesiones que nos ayudará a conectar cada vez que lo necesitemos
            sf = new MetadataSources(registro).buildMetadata().buildSessionFactory();
        }catch(Exception e){
            StandardServiceRegistryBuilder.destroy(registro);
        }
    }
    public void abrir() throws Exception{
        setUp();
        sesion = sf.openSession();
        transaction = sesion.beginTransaction();
    }
    public void cerrar(){
        try {
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        sf.close();
    }
    public Object guardar(Object cosa){
        return sesion.save(cosa);
    }
}
