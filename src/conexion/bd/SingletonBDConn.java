package conexion.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SingletonBDConn {
    private  static Connection instanceConn=null;

    SingletonBDConn(){}

    public static Connection getInstanceConn() throws SQLException {
        if(instanceConn==null){
            //inicializamos la conexión
            ResourceBundle bundle=ResourceBundle.getBundle("JDBC");
            String user=bundle.getString("usr");
            String psw=bundle.getString("psw");
            String driver=bundle.getString("driver");
            String url= bundle.getString("url");
            String bd=bundle.getString("bd");
            instanceConn= DriverManager.getConnection(url+bd,user,psw);
        }
        return instanceConn;
    }
}
