package game.dino;

import javax.swing.*;
import java.awt.*;

public class Enemigo {
    Point pos;
    int ancho,alto;
    Image img;
    public Enemigo(int x,int y,int ancho,int alto){
        ImageIcon imageIcon=new ImageIcon(this.getClass().getResource("enemigo.png"));
        img=imageIcon.getImage();
        pos=new Point(x,y);
        this.ancho=ancho;
        this.alto=alto;
    }

    public void pinta(Graphics g){
        g.drawImage(img, pos.x, pos.y, ancho,alto,null);
    }

    public Rectangle getLimites(){
        return new Rectangle(ancho,alto);
    }
}
