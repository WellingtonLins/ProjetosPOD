package edu.ifpb.pod;

/**
 * @Date 02/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */

public class Principal {


    public static void main(String[] args){

        Somador somador = new Somador();

        for (int i = 0; i <= 10; i++ ) {


            ProcessoThread a = new ProcessoThread(somador);
            ProcessoThread b = new ProcessoThread(somador);

            a.start();
            b.start();

            System.out.println(somador.getX());

        }

        System.out.println("Valor de x: " + somador.getX());

    }

}