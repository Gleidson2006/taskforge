package src.exercicios.modulo01.aula02;

public class Exercicio01 {
    void main(){
        int idade = Integer.parseInt(IO.readln("Sua idade: "));
        if(idade >=18){
            IO.println("Você é maior de idade");
        }else{
            IO.println("Você é menor de idade");
        }
    }
}

