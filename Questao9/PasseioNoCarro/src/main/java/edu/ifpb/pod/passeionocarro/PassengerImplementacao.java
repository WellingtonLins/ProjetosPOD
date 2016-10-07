package edu.ifpb.pod.passeionocarro;

/**
 * Document Passenger
 *
 * @Date 06/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class PassengerImplementacao extends Thread implements Passenger {

    private Car car;

    public PassengerImplementacao(Car car) {
        this.car = car;
    }

    public PassengerImplementacao() {
    }

    @Override
    public void run() {

        getInTheCar();
        waitRideAway();
        getOutTheCar();
        rideInThePark();

    }

    @Override
    public void getInTheCar() {

        car.adicionar(this);
        System.out.println("entrando no carro");
    }

    @Override
    public void waitRideAway() {

        synchronized (car) {

            try {
                System.out.println("esperando  terminar");
                car.wait();
            } catch (InterruptedException ex) {
            };

        }

    }

    @Override
    public void getOutTheCar() {

        System.out.println("saindo do carro");
        car.remover(this);

    }

    @Override
    public void rideInThePark() {

        System.out.println("passeando no parque");

    }

    @Override
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void executar() {
        this.start();
    }

}
