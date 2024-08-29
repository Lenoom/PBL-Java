import java.time.LocalDate;
import java.util.List;

public class Evento {
    private String nome;
    private String descr;
    private LocalDate data;
    private List<Ingresso> ingressos;
    private int qtdingressos;
    private boolean status;
    

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public List<Ingresso> getIngressos() {
        return ingressos;
    }
    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQtdingressos() {
        return qtdingressos;
    }
    public void setQtdingressos(int qtdingressos) {
        this.qtdingressos = qtdingressos;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
