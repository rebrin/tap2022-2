public class HiloPrioridad {
    public static void main(String[] args) {
        HiloContador hc1,hc2;
        hc1=new HiloContador("hilo1");
        hc2=new HiloContador("hilo2");
        Thread t1=new Thread(hc1);
        Thread t2=new Thread(hc2);
        HiloContadorHeredado t3=new HiloContadorHeredado();
//        t1.setPriority(10);
//        t2.setPriority(1);
        t1.start();
        t2.start();
        t3.start();
//        System.out.println(t1.getPriority());
//        System.out.println(t2.getPriority());
    }
}
