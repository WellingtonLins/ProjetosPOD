var net = require('net');
   
  var HOST = '127.0.0.1'; // parametrizar o IP do Listen
  var PORT = 6969; // porta TCP LISTEN
   
  // Cria a instância do Server e aguarda uma conexão
  net.createServer(function(sock) {
   
      // Opa, recebemos uma conexão - um objeto socket é associado à conexão automaticamente
      console.log('CONNECTED: ' + sock.remoteAddress +':'+ sock.remotePort);
   
      // Adiciona um 'data' - "event handler" nesta instância do socket
      sock.on('data', function(data) {
          // dados foram recebidos no socket 
          // Escreve a mensagem recebida de volta para o socket (echo)
          sock.write(data);
      });
   
      // Adiciona um 'close' - "event handler" nesta instância do socket
      sock.on('close', function(data) {
          // conexão fechada
          console.log('CLOSED: ' + sock.remoteAddress +' '+ sock.remotePort);
      });
   
  }).listen(PORT, HOST);
   
  console.log('Server listening on ' + HOST +':'+ PORT);