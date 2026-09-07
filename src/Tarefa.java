package src;

// Estado no inicio da 3.2 (veio da revisao de terca):
// ABSTRATA (nao existe "tarefa generica") + metodo abstrato tipo().
public abstract class Tarefa {

    private String nome;
    private String descricao;
    private int prioridade;
    private String responsavel;
    private double horasEstimadas;
    private TarefaStatus status;

    public Tarefa(String nome, String descricao, int prioridade, String responsavel,
                  double horasEstimadas, TarefaStatus status) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.horasEstimadas = horasEstimadas;
        this.status = status;
    }

    // Cada filha e OBRIGADA a dizer qual e o seu tipo.
    public abstract String tipo();

    public void resumo() {
        IO.println("Resumo da " + tipo());
        IO.println("Tarefa: " + this.nome);
        IO.println("Descricão: " + this.descricao);
        IO.println("Prioridade: " + this.prioridade);
        IO.println("Responsável: " + this.responsavel);
        IO.println("Status: " + this.status.getDescricao());
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getPrioridade() { return prioridade; }
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    public double getHorasEstimadas() { return horasEstimadas; }
    public void setHorasEstimadas(double horasEstimadas) { this.horasEstimadas = horasEstimadas; }

    public TarefaStatus getStatus() { return status; }
    public void setStatus(TarefaStatus status) { this.status = status; }
}