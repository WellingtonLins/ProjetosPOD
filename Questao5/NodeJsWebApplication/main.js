var x = 0;
var y = 0;

function sum() {
  x = y + 1;
  y = x + 1;
}

function main() {

  for (i = 1; i <= 10; i++) {
    var a = setTimeout(function(){ sum() }, 0);
    var b = setTimeout(function(){ sum() }, 0);
  }

  console.log(x);

  // Complementar: Valor de X depois de 1 segundo.
  setTimeout(function(){ console.log(x); }, 1000);

}

main();