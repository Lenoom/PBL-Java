/*
***************************
Sistema Operacional: Windows 10 - 64 Bits
Versão Da Linguagem: Java 1.8.0_411
Autor: Leonardo Oliveira Almeida da Cruz
Componente Curricular: EXA863 - MI - PROGRAMAÇÃO
Concluido em: 14/09/2024
Declaro que este código foi elaborado por mim de forma
individual e não contém nenhum trecho de código de outro
colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet.
Qualquer trecho de código de outra autoria que não a minha
está destacado com uma citação para o autor e a fonte do código,
e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************
*/

package Classes;

import java.util.*;
import java.time.LocalDate;
import Classes.Ingresso;
import Classes.Usuario;
import Classes.Evento;

public class Controller {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();

    // Cadastrar um usuário
    public Usuario cadastrarUsuario(String login, String senha, String nome, String cpf, String email, boolean isAdmin) {
        Usuario usuario = new Usuario(login, senha, nome, email, cpf, isAdmin);
        usuarios.add(usuario);
        return usuario;
    }

    // Metodo que cadastra eventos
    public Evento cadastrarEvento(Usuario usuario, String nome, String descricao, Date data) {
        if (!usuario.isAdmin()) {
            throw new SecurityException("Somente administradores podem cadastrar eventos.");
        }

        Evento evento = new Evento(nome, descricao, data);
        eventos.add(evento);
        return evento;
    }

    // Metodo para adicionar novo assento
    public void adicionarAssentoEvento(String nomeEvento, String assento) {
        Evento evento = buscarEvento(nomeEvento);
        if (evento != null) {
            evento.adicionarAssento(assento);
        }
    }

    // Metodo para comprar um ingresso
    public Ingresso comprarIngresso(Usuario usuario, String nomeEvento, String assento) {
        Evento evento = buscarEvento(nomeEvento);
        if (evento != null && evento.getAssentosDisponiveis().contains(assento)) {
            Ingresso ingresso = new Ingresso(evento, 100.0f, assento);
            evento.removerAssento(assento);
            usuario.getIngressos().add(ingresso); // Adiciona o ingresso ao usuário
            return ingresso;
        }
        return null;
    }

    // Cancelar a compra de um ingresso
    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
        if (usuario.getIngressos().contains(ingresso)) {
            ingresso.cancelar();
            usuario.getIngressos().remove(ingresso);
            Evento evento = ingresso.getEvento();
            evento.adicionarAssento(ingresso.getAssento()); // Assento volta a ficar disponível
            return true;
        }
        return false;
    }

    // Listar Eventos Disponíveis
    public List<Evento> listarEventosDisponiveis() {
        List<Evento> eventosDisponiveis = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.isAtivo()) {
                eventosDisponiveis.add(evento);
            }
        }
        return eventosDisponiveis;
    }

    // Metodo para listar ingressos comprados de um usuário
    public List<Ingresso> listarIngressosComprados(Usuario usuario) {
        return usuario.getIngressos();
    }

    // Buscar evento com base no seu nome
    private Evento buscarEvento(String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nomeEvento)) {
                return evento;
            }
        }
        return null;
    }
}