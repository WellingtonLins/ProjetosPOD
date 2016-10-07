package edu.ifpb.pod.passeionocarro;

/**
 * Document Principal
 *
 * @Date 06/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException {

        Passenger passaageiro;
        Car carro = new CarImplementacao();
        carro.executar();

        for (int i = 0; i < 6; i++) {

            passaageiro = new PassengerImplementacao(carro);
            passaageiro.executar();
        }
    }
}
