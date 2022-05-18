package game.dino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Escenario extends Canvas implements Runnable{
    Image fondo;
    Personaje personaje;
    Enemigo enemigo;
    int ancho,alto;
    boolean jugando,salta;


    Escenario(int ancho,int alto){
        ImageIcon fondoIcon=new ImageIcon(this.getClass().getResource("fondo.jpg"));
        fondo=fondoIcon.getImage();
        this.ancho=ancho;
        this.alto=alto;
        personaje=new Personaje(10,alto/2,80,150);
        enemigo=new Enemigo(ancho-80,alto/2,80,150);
        jugando=true;
        salta=false;
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    salta=true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo,0,0,ancho,alto,null);
        personaje.pinta(g);
        enemigo.pinta(g);
    }

    @Override
    public void run() {
        int avanceEnemigo=-20;
        int tamSalto=200;
        while (jugando){
            enemigo.pos.x=enemigo.pos.x+avanceEnemigo;

            if(personaje.pos.y<alto/2 && !salta){
                personaje.pos.y+=40;
            }
            if(salta){
                personaje.pos.y-=tamSalto;
                salta=false;
            }

            //todo me faltan las colisiones
            if(personaje.getLimites().intersects(enemigo.getLimites()))
                System.out.println("colision");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repaint();
        }
    }
}
