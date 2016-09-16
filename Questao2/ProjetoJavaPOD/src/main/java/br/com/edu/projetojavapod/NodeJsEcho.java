package br.com.edu.projetojavapod;

/**
 * Document NodeJsEcho
 *
 * @Date 16/09/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Classe Java (client) para Comunicação com servidor NodeJS
 */
public class NodeJsEcho {
    // objeto sockeck
    private Socket socket = null;

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // instancia classe
        NodeJsEcho client = new NodeJsEcho();

        // conexão socket tcp
        String ip = "127.0.0.1";
        int port = 6969;
        client.socketConnect(ip, port);

        // escreve e recebe mensagem 
        String message = "Teste com apllicação Node";

        System.out.println("Enviando: " + message);
        String retorno = client.echo(message);
        System.out.println("Recebendo: " + retorno);
    }

    // realiza a conexão com o socket
    private void socketConnect(String ip, int port) throws UnknownHostException, IOException {
        System.out.println("[Conectando socket...]");
        this.socket = new Socket(ip, port);
    }

    // escreve e recebe mensagem  no socket
    public String echo(String message) {
        try {
            // out & in 
            PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));

            // escreve string no socket e lê
            out.println(message);
            String retorno = in.readLine();
            return retorno;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // obtem instância do socket
    private Socket getSocket() {
        return socket;
    }
}
