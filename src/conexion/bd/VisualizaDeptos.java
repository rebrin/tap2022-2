package conexion.bd;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisualizaDeptos {
    JScrollPane scrollPane;
    JTable tabla;
    JFrame ventana;
    String [] cols={"depno","nombre","localidad"};
    Object [][] data;

    public VisualizaDeptos() throws SQLException {
        Connection con=SingletonBDConn.getInstanceConn();
        String query="select * from dept";
        Statement stm=con.createStatement();
        ResultSet resultSet=stm.executeQuery(query);
        resultSet.last();
        int resultados=resultSet.getRow();
        resultSet.beforeFirst();
        this.data=new Object[resultados][3];
        int i=0,j=0;
        while (resultSet.next()){
            for(j=0;j<3;j++){
                data[i][j]=resultSet.getObject(j+1);
            }
            i++;
        }
        ventana=new JFrame("BD");
        tabla=new JTable(data,cols);
        scrollPane=new JScrollPane(tabla);
        ventana.add(scrollPane, BorderLayout.CENTER);
        ventana.setSize(400,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
            new VisualizaDeptos();
    }
}
