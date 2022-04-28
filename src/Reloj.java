import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.BitSet;

public class Reloj  {
    JFrame ventana;
    JLabel lblTime;
    JButton BInicio,BStop;
    Thread h1;
    HiloReloj h;

    public Reloj(){
        ventana=new JFrame("reloj");
        lblTime=new JLabel("0");
        BInicio=new JButton("iniciar");
        BStop=new JButton("parar");
        lblTime.setFont(new Font("Agency FB", Font.BOLD, 48));
        ventana.add(lblTime, BorderLayout.NORTH);
        JPanel panelBotones=new JPanel(new FlowLayout());
        panelBotones.add(BInicio);
        panelBotones.add(BStop);
        BStop.setEnabled(false);
        ventana.add(panelBotones,BorderLayout.SOUTH);

        /**/


        BInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h=new HiloReloj(lblTime);
                h1=new Thread(h);
                h1.start();
               BInicio.setEnabled(false);
               BStop.setEnabled(true);
            }
        });

        BStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               h.parar();
               BStop.setEnabled(false);
               BInicio.setEnabled(true);
            }
        });

        ventana.setSize(400,400);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Reloj();
    }
}
