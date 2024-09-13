import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Evento {
    private String nome;
    private String descricao;
    private LocalDate data;
    private HashMap<String,Boolean> assentos;
    private boolean status;
    

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descr) {
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;}

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Construtor
    public Evento(String nome, String descricao, LocalDate data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.assentos = new HashMap<>();
        this.status = true;
    }

    public boolean isAtivo() {
        LocalDate dataAtual = LocalDate.now();

        if (dataAtual.isAfter(data) || dataAtual.isEqual(data)) {
            this.status = false; // Se a data atual for maior ou igual à data do evento, retorna falso;
            return false;
        } else {
            this.status = true; // Se a data atual for menor retorna true;
            return true;
        }
    }

    // Método para adicionar um assento
    public void adicionarAssento(String nomeAssento) {
        assentos.put(nomeAssento, true); // O assento é adicionado sempre como disponível.
    }
    // Método para remover assento
    public boolean removerAssento(String nomeAssento) {
        if (assentos.containsKey(nomeAssento)) {
            assentos.remove(nomeAssento);
            return true;
        } else {
            return false;
        }

    // Método para retornar assentos disponíveis
    public List<String> getAssentosDisponiveis() {
        List<String> assentosDisponiveis = new ArrayList<>();
        for (String assento : assentos.keySet()) {
            if (assentos.get(assento)) { // Se o valor da key assento for true;
                assentosDisponiveis.add(assento); // Adiciona ele na lista;
            }
        }
        return assentosDisponiveis;
    }

}
