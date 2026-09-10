package src.exercicios.modulo01.aula02;

public class Desafio {
    void main() {
        IO.println("=== TaskForge v0 ===");

        int opcao = 0;
        int quantidadeTarefas = 0;
        do {
            IO.println("Escolha uma opção");
            IO.println("1 - criar tarefa");
            IO.println("2 - Ver resumo");
            IO.println("3 - Sair");
            opcao = Integer.parseInt(IO.readln());
            switch (opcao) {

                case 1:
                    criarTarefa();
                    quantidadeTarefas++;
                    break;
                case 2:
                    IO.println("Quantidade de tarefas:" + quantidadeTarefas);
                    break;
                case 3:
                    //sair
                    break;

                default:
                    IO.println("Opção inválida.");
            }

        } while (opcao != 3);

        IO.println("Obrigado por usar o TaskForge!");


    }

    void criarTarefa() {
        String nome = IO.readln("Nome da tarefa: ");
        String descricao = IO.readln("Descrição: ");

        int prioridade = 0;
        do {
            prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
            if (prioridade < 1 || prioridade > 5) {
                IO.println("Prioridade inválida.");
            }
        } while (prioridade < 1 || prioridade > 5);

        IO.println();
        String responsavel = IO.readln("Responsável: ");
        double horasEstimadas = Double.parseDouble(IO.readln("Horas estimadas: "));

        int status;
        do {
            IO.println("Escolha uma opção: ");
            IO.println("1 - Pendente");
            IO.println("2 - Em Andamento");
            IO.println("3 - Concluída");
            IO.println("4 - Cancelada");
            status = Integer.parseInt(IO.readln());
            if (status < 1 || status > 4) {
                IO.println("Status inválido.");
            }
        } while (status < 1 || status > 4);

        IO.println("");
        IO.println("------ TAREFA CRIADA ------");
        IO.println("Tarefa:     " + nome);
        IO.println("Descrição:  " + descricao);
        IO.print("Prioridade: ");
        for (int aux = 0; aux < prioridade; aux++) {
            IO.print("*");
        }
        IO.println();
        String statusNome = "";
        switch (status) {
            case 1 -> statusNome = "Pendente";
            case 2 -> statusNome = "Em Andamento";
            case 3 -> statusNome = "Concluída";
            case 4 -> statusNome = "Cancelada";
            default -> statusNome = "Status Inválido";
        }
        IO.println("Status:    " + statusNome);
        IO.println("---------------------------");
    }
}
