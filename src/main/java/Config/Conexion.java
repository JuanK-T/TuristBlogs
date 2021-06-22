package Config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;


public class Conexion {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/ejemplo";
    private static final String jdbcUsuario = "root";
    private static final String jdbcClave = "";
    private static Connection connection;

    public static BasicDataSource dataSource = null;

    public static DataSource getDataSource(){
        if(dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername(jdbcUsuario);
            dataSource.setPassword(jdbcClave);
            dataSource.setUrl(jdbcURL);
            //definir el tamaña del pool de conexiones
            dataSource.setInitialSize(50);//50 conexiones iniciales
            dataSource.setMaxIdle(10);//conexiones minimas activas
            dataSource.setMaxTotal(20);//total de conexiones
            dataSource.setMaxWaitMillis(5000);//tiempo de espera
        }
        return dataSource;
    }

    public Connection getConexion(){
        try{
            connection = getDataSource().getConnection();
        }catch (Exception e){
            System.out.println("Error de conexion a la base de Datos " + e.getMessage().toString());
        }
        return connection;
    }
}
