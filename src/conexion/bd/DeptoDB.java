package conexion.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptoDB {
    Integer id;
    String dname;
    String loc;

    public DeptoDB(Integer id, String dname, String loc) {
        this.id = id;
        this.dname = dname;
        this.loc = loc;
    }

    //metodo para insertar los departamentos, usando preparedStatement
    public int insertaDepto(int id, String dname,String loc) throws SQLException {
        Connection con=SingletonBDConn.getInstanceConn();
        String query="insert into dept (depno,dname,loc) values (?,?,?)";
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,dname);
        pst.setString(3,loc);
        int afectados=pst.executeUpdate();
        return afectados;
    }

    public int borrarDepto(int id) throws SQLException {
        Connection con=SingletonBDConn.getInstanceConn();
        String query="delete from dept where depno=?";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,id);
        int afected=pst.executeUpdate();
        return afected;
    }

    public int AcutalizaDepto(int depto, String dname, String loc) throws SQLException {
        Connection con=SingletonBDConn.getInstanceConn();
        String query = "update dept set dname = ?, loc = ? where depno = ? ";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setString(1, dname);
        pst.setString(2, loc);
        pst.setInt(3, depto);
        int Afected = pst.executeUpdate();

        return Afected;
    }
    public void multTrans() throws SQLException {
        Connection con = null;
        try {
             con = SingletonBDConn.getInstanceConn();
            con.setAutoCommit(false);
            String query = "insert into dept (depno,dname,loc) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            /*insertar 3 elementos*/
            pst.setInt(1, 8);
            pst.setString(2, "transacciones1");
            pst.setString(3, "México");
            int filasop1 = pst.executeUpdate();
            pst.setInt(1, 9);
            pst.setString(2, "transacciones2");
            pst.setString(3, "México");
            int filasop2 = pst.executeUpdate();
            pst.setInt(1, 9);
            pst.setString(2, "transacciones3");
            pst.setString(3, "México");
            int filasop3 = pst.executeUpdate();
            if (filasop1 > 0 && filasop2 > 0 && filasop3 > 0)
                con.commit();
            else con.rollback();
        }catch (SQLException ex){
            ex.printStackTrace();
            con.rollback();
        }
    }
    public static void main(String[] args) throws SQLException {
        DeptoDB obj=new DeptoDB(4,"direccion","mex");
        //-obj.insertaDepto(obj.id,obj.dname, obj.loc);
        //obj.borrarDepto(4);
//        int affect=obj.AcutalizaDepto(3,"rh","La plata");
//        if(affect>0)
//            System.out.println("si se pudo!!!!");
        obj.multTrans();
    }
}
