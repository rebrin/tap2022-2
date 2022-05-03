public class HiloContador implements Runnable{
    String nom;
    public HiloContador(String n){
        nom=n;
    }
    @Override
    public void run() {
        int cont=0;
        while(cont<50){
            System.out.println(nom+":"+cont++);
        }
    }
}
