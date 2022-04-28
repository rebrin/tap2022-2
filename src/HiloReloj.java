import javax.swing.*;

public class HiloReloj implements Runnable{
    Integer segundos;
    Integer minutos;
    JLabel refLbl;
    boolean para=false;
    public  HiloReloj(JLabel lbl){
        refLbl=lbl;
        segundos=0;
        minutos=0;
    }

    @Override
    public void run() {
        while (!para){
            try {
                segundos++;
                if(segundos==60){
                    segundos=0;
                    minutos++;
                }


                refLbl.setText(minutos.toString()+":"+segundos.toString());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void parar(){
        para=true;
    }
}
