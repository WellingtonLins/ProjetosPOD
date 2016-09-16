#!/usr/bin/env node

var pg = require("pg");

var conString = "pg://postgres:123@localhost:5432/NODEJS_BANCO";

var client = new pg.Client(conString);
client.connect();

// client.query("CREATE TABLE IF NOT EXISTS empregados(nome varchar(64), sobrenome varchar(64))");
// client.query("INSERT INTO empregados(nome, sobrenome) values($1, $2)", ['Ronaldo', 'McDonald']);
// client.query("INSERT INTO empregados(nome, sobrenome) values($1, $2)", ['Maria', 'Fernanda']);

var query = client.query("SELECT nome, sobrenome FROM empregados ORDER BY sobrenome, nome");
query.on("row", function (row, result) {
    result.addRow(row);
});
query.on("end", function (result) {
    console.log(JSON.stringify(result.rows, null, "    "));
    client.end();
});