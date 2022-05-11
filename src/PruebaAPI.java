import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaAPI {
    public static void main(String[] args) throws Exception {
        ExecutorService servicio= Executors.newSingleThreadExecutor();
        servicio.execute(()->{
            URL oracle = null;
            try {
               // oracle = new URL("https://disease.sh/v3/covid-19/all");
                oracle = new URL("https://api.datos.gob.mx/v1/data-core");
                URLConnection yc = oracle.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        yc.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
                in.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        if(servicio!=null) servicio.shutdown();

    }
}
