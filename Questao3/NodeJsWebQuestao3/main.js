var x = 1;


function setValue() {
  x = 2;

}

function main() {

    var a = setTimeout(function(){ setValue() }, 0);


  console.log(x);

  // Complementar: Valor de X depois de 1 segundo.
  setTimeout(function(){ console.log(x); }, 1000);

}

main();