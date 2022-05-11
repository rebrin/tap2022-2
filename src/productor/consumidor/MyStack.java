package productor.consumidor;

public class MyStack {
    int cont;
    char [] data;
    public MyStack(){
        cont=0;
        data=new char[200];
    }

    public void push(char c){
      synchronized (this) {
          notify();
          data[cont] = c;
          cont++;
      }
    }

    public synchronized char pop(){
        if(cont==0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        cont--;
        return data[cont];
    }
}
