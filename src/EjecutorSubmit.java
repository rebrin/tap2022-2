import java.util.concurrent.*;

public class EjecutorSubmit {
    int cont;
    EjecutorSubmit() throws ExecutionException, InterruptedException, TimeoutException {
        //cont=0;
        ExecutorService service= Executors.newSingleThreadExecutor();
        Future<Integer> resultado=
                service.submit(()->{
                    for (int i = 0; i < 500; i++) {
                        cont++;
                    }
                    //Thread.sleep(9000);
                    return cont;
                });
        resultado.get(10, TimeUnit.SECONDS);
        if(service!=null) service.shutdown();
        System.out.println("Resultado en hilo:"+ cont);
    }

    public static void main(String[] args) {
        try {
            new EjecutorSubmit();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
