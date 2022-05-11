public class OperacionCostosa extends Thread{
    public void run(){
        try {
            System.out.println("estoy trabajando");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
