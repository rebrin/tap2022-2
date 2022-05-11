import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUITrabada {
    JFrame Ventana;
    JButton Boton;
    JComboBox<String> CBOpciones;

    public GUITrabada(){
        Ventana=new JFrame("trabada");
        Boton=new JButton("aceptar");
        CBOpciones=new JComboBox<>();
        CBOpciones.addItem("opcion1");
        CBOpciones.addItem("opcion2");
        CBOpciones.addItem("opcion3");
        /*elementos
        * */
        Ventana.setLayout(new FlowLayout());
        Ventana.add(CBOpciones);
        Ventana.add(Boton);

        /*evento al boton*/
        Boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }

                OperacionCostosa o=new OperacionCostosa();
                o.start();
            }
        });
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setSize(400,300);
        Ventana.setVisible(true);

    }

    public static void main(String[] args) {
        new GUITrabada();
    }
}
