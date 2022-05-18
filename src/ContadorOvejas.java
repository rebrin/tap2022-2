import java.security.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorOvejas {
    private int contOv=0;
    private synchronized void incrementAndReport(){
        System.out.print(++contOv+" ");
    }

    public static void main(String[] args) {
        ExecutorService service=
                Executors.newFixedThreadPool(10);
        ContadorOvejas c=new ContadorOvejas();
        for (int i = 0; i < 10; i++) {
            service.submit(()->c.incrementAndReport());
        }
        if(service!=null) service.shutdown();
    }

}
