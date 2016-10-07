package edu.ifpb.pod.passeionocarro;

import java.util.ArrayList;
import java.util.List;

/**
 * Document   Car
 * @Date  06/10/2016 
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 

public class CarImplementacao extends Thread implements Car  {

    public List<Passenger> passageiros;

    public CarImplementacao() {

        passageiros = new ArrayList<>();
    }

    @Override
    public void run() {

        waitFill();
        takeAWalk();
        waitGetOutAll();

    }

    @Override
    public boolean adicionar(Passenger passenger) {

        if (passageiros.add(passenger)) {

            passenger.setCar(this);

            return true;
        }

        return false;
    }

    @Override
    public boolean remover(Passenger passenger) {

        if (passageiros.remove(passenger)) {

            passenger.setCar(null);

            return true;
        }

        return false;
    }

    @Override
    public void waitFill() {

        System.out.println("preenchendo lotação do carrinho.");

        while (passageiros.size() < 6) {

            try {
               Thread.sleep(400);
            } catch (InterruptedException ex) {}
        }
        
        System.out.println("passeio iniciado");

    }

    @Override
    public void takeAWalk() {

        synchronized (this) {

            System.out.println("uma volta completa.");
            notifyAll();
        }

    }

    @Override
    public void waitGetOutAll() {
        
        System.out.println("Esperando todos desembarcarem");

        while (passageiros.size() > 0) {

            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {}
        }
        
        System.out.println("Carro livre");
        
    }

    @Override
    public void executar() {
       this.start();
    }
  

}
