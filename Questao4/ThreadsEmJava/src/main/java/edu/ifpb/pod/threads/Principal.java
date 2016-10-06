package edu.ifpb.pod.threads;

/**
 * Document Principal
 *
 * @Date 01/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Principal {
    
    private static int x = 0;
    private static int y = 0;
    
    public static void sum() {
        x = y + 1;
        y = x + 1;
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        for (int i = 1; i <= 10; i++) {
            
            Thread a = new Thread() {
                public void run() {
                    sum();
                }
            };
            a.start();
            
            Thread b = new Thread() {
                public void run() {
                    sum();
                }
            };
            b.start();
//           Thread.sleep(1000);
            System.out.println(x);
            
        }
        
    }
}
