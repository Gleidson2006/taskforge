// TaskForge v0 - projeto do curso "Do Código ao Contrato"
// Aula 01.1: Java, a JVM e as primeiras variáveis.
//
// Este é o ponto de partida. Durante a aula você constrói este código,
// e no desafio você evolui ele (veja COMO-ENTREGAR.md).
//
// Como rodar:
//   - No IntelliJ: abra este arquivo e clique em Run.
//   - No terminal: java TaskForge.java

import src.Tarefa;

void main() {
    IO.println("=== TaskForge v0 ===");

    Tarefa tarefa = new Tarefa("estudar Java", "Descricao Tarefa", 1,
            "Eu mesmo", 2, 1);

    Tarefa tarefa2 = new Tarefa("estudar frontende", "Estudar react", 1,
            "Gleidson Gabriel", 2, 1);

    IO.println("Tarefa criada: " + tarefa.getNome());
    IO.println("tarefa criada:" + tarefa2.getNome() );

    String nome = IO.readln("Nome da tarefa: ");
    String descricao = IO.readln("Descrição: ");
    int prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
    String responsavel = IO.readln("responsavel: ");
    double horasEstimadas = Double.parseDouble(IO.readln("Horas estimadas: "));
    String status = "pendente";

    IO.println("");
    IO.println("------ TAREFA CRIADA ------");
    IO.println("Tarefa:     " + nome);
    IO.println("Descrição:  " + descricao);
    IO.println("Prioridade: " + prioridade);
    IO.println("Status:     pendente");
    IO.println("---------------------------");
}
