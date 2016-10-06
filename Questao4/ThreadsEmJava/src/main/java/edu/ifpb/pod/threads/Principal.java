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

    public static void main(String[] args) {

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

            System.out.println(x);

        }

    }
}

//Da maneira como esta escrito o algoritmo , ficamos com uma situação de corrida , onde as duas threads em
//questão estão acessando as mesmas variaveis , enquanto uma esta escrevendo a outra ja esta lendo ...

//resultados: de três execuções consecutivas
//Primeira execução
//0
//3
//5
//7
//11
//15
//17
//19
//23
//25

//Segunda execução
//0
//3
//5
//9
//13
//15
//19
//23
//27
//33

//Terceira execução
//0
//3
//3
//5
//9
//13
//15
//19
//25
//27