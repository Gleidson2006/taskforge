package src.exercicios.modulo01.aula02;

public class Exercicio06 {

    void main() {
        int numero = Integer.parseInt(IO.readln("Me informe um numero: "));
        int soma = 0;
        for (int aux = 1; aux <= numero; aux++) {
            soma = soma + aux;
        }
        IO.println (" A soma de 1 até " + numero + " é " + soma);
    }
}
