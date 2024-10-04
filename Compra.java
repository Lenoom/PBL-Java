package Classes;

public class Compra {

    Ingresso comprarIngresso(Usuario user, Pagamento pagamento){
        if(ingresso.getEvento().isAtivo()){

        }else{
            return false;
        }
    }
    void enviarEmail(Usuario user,boolean confirm){
        String email = user.getEmail();
        System.out.println("Compra confirmada no email - " + email);
    }

}