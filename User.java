import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User{
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private List<Ingresso> ingressos;


    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getSenha() {return senha;}
    public void setSenha(String senha){this.senha = senha;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf){this.cpf = cpf;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public List<LocalDate> getIngressos() {return ingressos;}
    public void setIngressos(List<LocalDate> ingressos) {this.ingressos = ingressos;}

    public User(String login,String senha, String nome,String email, String cpf){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.ingressos = new ArrayList<>();
    }
}