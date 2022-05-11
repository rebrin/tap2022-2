import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestServiceExecutor {
    public static void main(String[] args) {
        ExecutorService servicio= Executors.newSingleThreadExecutor();
        /*los executors pueden usar lambdas*/
        servicio.execute(()->{
            int i=0;
            int suma = 0;

            while(i<=1000) {
                suma=suma+i;
                i++;

                //System.out.println(++i);
            }
            System.out.println(suma);
        });
       if(servicio!=null) servicio.shutdown();
    }
}
