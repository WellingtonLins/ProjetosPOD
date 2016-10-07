
package edu.ifpb.pod.passeionocarro;

/**
 *
 * @author Wellington
 */
public interface Car {

    void waitFill();

    void takeAWalk();

    void waitGetOutAll();

    boolean adicionar(Passenger passenger);

    boolean remover(Passenger passenger);

    void executar();
}
