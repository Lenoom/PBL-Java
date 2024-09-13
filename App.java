import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      System.out.println("Bem vindo(a) ao Maximus Ingressos!\n1 - Fazer Login.\n2 - Fazer Sign in");

      Scanner scanner = new Scanner(System.in);
      String nome = scanner.nextLine();
      
      User usuario = new User();
      usuario.setNome(nome);

      scanner.close();
      System.out.println(usuario.getNome());
    }
}
