package edu.ifpb.pod.questao7;

/**
 * Document Principal
 *
 * @Date 06/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException {
        Somador somador = new Somador();
        for (int i = 0; i < 10; i++) {

            somador.constroiThreads();

        }
        Thread.sleep(4 * 1000);
        System.out.println(Somador.getX());

    }

}
