package edu.ifpb.pod;

/**
 * @Date 02/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */

public class ProcessoThread extends Thread{

    private Somador somador;

    public ProcessoThread(Somador somador) {

        super();

        this.somador = somador;

    }

    @Override
    public void run() {

        synchronized (somador) {
            somador.sum();
        }

    }

}
