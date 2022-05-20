package conexion.bd;
import java.sql.*;


public class MiBDConexion {
    Connection connection;
    Statement stm;
    ResultSet rst;
    public MiBDConexion(){
        String URL="jdbc:mysql://localhost/ejconsultas";
        try {
            //conectarme a la BD
            connection=DriverManager.getConnection(URL,"root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultaEmp() throws SQLException {
        String query="Select * from emp";
        stm=connection.createStatement();
        rst=stm.executeQuery(query);
        while (rst.next()){
            System.out.println(rst.getInt(1)+" "+rst.getString("ename"));
        }
    }

    public void consultaDeptos() throws SQLException {
        String query="select * from dept";
        rst=stm.executeQuery(query);
        while (rst.next()){
            System.out.println(rst.getInt("depno")+" "+rst.getString("dname")
                    +" "+rst.getString("loc"));
        }
    }

    public boolean insEmpleado(int empno, String nombre, int depno) throws SQLException {
        stm=connection.createStatement();
        String queryIns="insert into emp (empno,ename,depno,hiredate) " +
                "values ("+empno+",'"+nombre+"',"+depno+",now())";
        System.out.println(queryIns);
        int datos=stm.executeUpdate(queryIns);
        return datos>1;
    }

    public boolean borrarEmp(int empno) throws SQLException {
        stm=connection.createStatement();
        String queryIns="Delete from emp where empno="+empno;
        System.out.println(queryIns);
        int datos=stm.executeUpdate(queryIns);
        return datos>1;
    }

    public boolean modifEmp(int empno, String nombre, int depno,String fecha) throws SQLException {
        stm=connection.createStatement();
        //formato de fecha mm-dd-yyyy
        String queryIns="UPDATE emp SET ename='"+nombre+"',depno="+depno+",hiredate='"+fecha
                +"' where empno="+empno;
        System.out.println(queryIns);
        int datos=stm.executeUpdate(queryIns);
        return datos>1;
    }
    public static void main(String[] args) throws SQLException {
        MiBDConexion BD=new MiBDConexion();
        BD.consultaEmp();
        BD.modifEmp(20,"alberto",3,"1983-01-03");

    }
}
