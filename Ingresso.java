import java.time.LocalDate;

public class Ingresso {
    private Evento evento;
    private float preco;
    private String assento;
    private boolean isAtivo;

    public Ingresso(Evento evento, float preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
        isAtivo = true;
    }

    public boolean isAtivo() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataEvento = evento.getData();

        if (dataAtual.isAfter(dataEvento) || dataAtual.isEqual(dataEvento)) {
            return false;
        } else {
            return true;
        }
    }
    public boolean reativar(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataEvento = evento.getData();

        if (dataAtual.isAfter(dataEvento) || dataAtual.isEqual(dataEvento)) {
            return false;
        } else {
            isAtivo = true;
            return true;
        }
    }
    }

    public boolean cancelar(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataEvento = evento.getData();

        if(dataAtual.isAfter(dataEvento) || dataAtual.isEqual(dataEvento)){
            return false;
        }else{
            isAtivo = false;
            return true;
        }
    }

    // Teste de ingresso duplicados;
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingresso ingresso = (Ingresso) obj;
        return Float.compare(ingresso.preco, preco) == 0 &&
                Objects.equals(evento, ingresso.evento) &&
                Objects.equals(assento, ingresso.assento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evento, preco, assento);
    }

    // Getters
    public Evento getEvento() {
        return evento;
    }
    public float getPreco() {
        return preco;
    }
    public String getAssento() {
        return assento;
    }
    public boolean isAtivo() {
        return isAtivo;
    }

    // Setters
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public void setAssento(String assento) {
        this.assento = assento;
    }
    public void setAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }
}
