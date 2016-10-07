package edu.ifpb.dac.questao7;

/**
 * Document Somador
 *
 * @Date 06/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Somador implements Runnable {

    private static int x = 0;
    private static int y = 0;
    private Thread thread1;
    private Thread thread2;

    public synchronized void sum() {

        x = y + 1;
        y = x + 1;

    }

    public void constroiThreads() {

        thread1 = new Thread() {

            @Override
            public void run() {
                    sum();
                    System.out.println("Prazer Thread1");
                       
            }
        };

        thread2 = new Thread() {

            @Override
            public void run() {
                    sum();
                    System.out.println("Eu sou  a Thread2");
                
            }
        };
        thread1.start();
        thread2.start();

    }

    @Override
    public void run() {

        constroiThreads();

    }

    public static int getX() {
        return x;
    }


    public static int getY() {
        return y;
    }


}
