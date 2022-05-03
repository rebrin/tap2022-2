public class HiloContadorHeredado extends Thread{
    public void run(){
        int cont=0;
        while (cont<20){
            System.out.println(cont++);
        }
    }
}
