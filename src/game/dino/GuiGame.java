package game.dino;

import javax.swing.*;
import java.awt.*;

public class GuiGame {
    JFrame ventana;
    Escenario escenario;

    GuiGame(){
        ventana=new JFrame("juego");
        escenario= new Escenario(900,400);
        Thread hilogame=new Thread(escenario);
        ventana.add(escenario, BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(900,400);
        ventana.setVisible(true);
        hilogame.start();
    }

    public static void main(String[] args) {
        new GuiGame();
    }
}
