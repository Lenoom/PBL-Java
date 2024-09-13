import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario{
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private boolean isAdmin;
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

    public Usuario(String login,String senha, String nome,String email, String cpf, boolean isAdmin){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.isAdmin = isAdmin;
        this.ingressos = new ArrayList<>();
    }
    public boolean isAdmin(){
        return isAdmin;
    }

    public boolean login(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User usuario = (User) o;
        return cpf.equals(usuario.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
}