/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Menu {

    private Scanner scanner;
    private Empresa empresa;
    private Map<String, Acao> acoesCadastradas;
    private String perfilUsuario;
    private String perfilUsuarioAnterior;
    private Map<String, Area> areasCadastradas;
    private Map<String, Usuario> usuariosCadastrados;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.empresa = new Empresa();
        this.acoesCadastradas = new HashMap<>();
        this.perfilUsuario = definirPerfilUsuario();
        this.perfilUsuarioAnterior = perfilUsuario;
        this.areasCadastradas = new HashMap<>();
        this.usuariosCadastrados = new HashMap<>();
    }

    public void exibirMenu() throws ParseException {
        int escolha;

        do {
            exibirOpcoes();

            System.out.println("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 9) {
                solicitarPerfilUsuario(); // Voltar e Escolher um Perfil novo
                //verifica se o perfil foi alterado
                if (!perfilUsuarioAnterior.equals(perfilUsuario)) {
                    //ajusta as opções do menu de acordo com o novo perfil
                    System.out.println("Perfil de usuario alterado.");
                    //exibirOpcoes();
                    //verificar tipo de usuario e listar o menu baseado no usuario corrent
                    if (perfilUsuario.equals("administrador")) {
                        //chama menu administrador
                        processarOpcaoAdministrador(escolha);
                    } else if (perfilUsuario.equals("lider_projeto")) {
                        // chama menu lider
                        processarOpcaoLiderProjeto(escolha);
                    } else if (perfilUsuario.equals("usuario")) {
                        // chama menu usuario
                        processarOpcaoUsuario(escolha);
                    } else {
                        System.out.println("Perfil de Usuario não Reconhecido.");
                    }
                }
            } else {
                //faz a distribuição das opcoes do menu com base no Perfil do Usuario.
                switch (perfilUsuario) {
                    case "administrador":
                        processarOpcaoAdministrador(escolha);
                        break;

                    case "lider_projeto":
                        processarOpcaoLiderProjeto(escolha);
                        break;

                    case "usuario":
                        processarOpcaoUsuario(escolha);
                        break;
                    default:
                        System.out.println("Perfil de Usuario não Reconhecido.");
                        break;
                }
            }
        } while (escolha != 0);
    }

    private void exibirOpcoes() {
        System.out.println("==== MENU====");

        switch (perfilUsuario) {
            case "administrador":
                System.out.println("1. Cadastrar Empresa");
                System.out.println("2. Cadastrar Área");
                System.out.println("3. Cadastrar Usuário");
                System.out.println("8. Visualizar Quadro Kanban");
                break;
            case "lider_projeto":
                System.out.println("4. Cadastrar Projeto");
                System.out.println("5. Cadastrar Atividade");
                System.out.println("6. Cadastrar Ação");
                System.out.println("8. Visualizar Quadro Kanban");
                break;
            case "usuario":
                System.out.println("7. Atualizar status da Ação");
                System.out.println("8. Visualizar quadro Kanban");
                break;
            default:
                System.out.println("Perfil de usuário não reconhecido.");
                break;
        }

        System.out.println("9. Voltar ao menu anterior.");
        System.out.println("0. Encerrar o programa.");

    }

    private void processarOpcaoAdministrador(int escolha) {
        switch (escolha) {
            case 1:
                cadastrarEmpresa();
                break;
            case 2:
                cadastrarArea();
                break;
            case 3:
                cadastrarUsuario();
                break;
            case 8:
                visualizarQuadroKanban();
                break;
            case 9:
                System.out.println("Voltar ao menu anterior.");
                solicitarPerfilUsuario();
                break;
            case 0:
                System.out.println("Encerrar o programa.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private void processarOpcaoLiderProjeto(int escolha) throws ParseException {
        switch (escolha) {
            case 4:
                cadastrarProjeto();
                break;
            case 5:
                cadastrarAtividade();
                break;
            case 6:
                cadastrarAcao();
                break;
            case 8:
                visualizarQuadroKanban();
                break;
            case 9:
                System.out.println("Voltar ao menu anterior.");
                solicitarPerfilUsuario();
                break;
            case 0:
                System.out.println("Encerrar o programa.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private void processarOpcaoUsuario(int escolha) {
        switch (escolha) {
            case 7:
                atualizarStatusDaAcao();
                break;
            case 8:
                visualizarQuadroKanban();
                break;
            case 9:
                System.out.println("Voltar ao menu anterior.");
                solicitarPerfilUsuario();
                break;
            case 0:
                System.out.println("Encerrar o programa.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private void cadastrarArea() {
        System.out.print("Digite o nome da área: ");
        String nomeArea = scanner.nextLine();
        Area area = new Area(nomeArea);
        areasCadastradas.put(nomeArea, area);
        System.out.println("Área cadastrada com sucesso!");
    }

    public Map<String, Area> getAreasCadastradas() {
        return areasCadastradas;
    }

    private void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nomeUsuario);
        usuariosCadastrados.put(nomeUsuario, usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private void exibirUsuariosCadastrados() {
        System.out.println("Lista de Usuários Cadastrados:");
        for (String nomeUsuario : usuariosCadastrados.keySet()) {
            System.out.println(nomeUsuario);
        }
    }

    private String definirPerfilUsuario() {
        System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
        String perfil = scanner.nextLine().toLowerCase();

        while (!perfil.equals("administrador") && !perfil.equals("lider_projeto") && !perfil.equals("usuario")) {
            System.out.println("Perfil de usuário não reconhecido. Tente novamente.");
            System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
            perfil = scanner.nextLine().toLowerCase();
        }

        return perfil;
    }

    private void solicitarPerfilUsuario() {
        System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
        perfilUsuarioAnterior = perfilUsuario;  // Adicione esta linha
        perfilUsuario = scanner.nextLine().toLowerCase();
        while (!perfilUsuario.equals("administrador") && !perfilUsuario.equals("lider_projeto") && !perfilUsuario.equals("usuario")) {
            System.out.println("Perfil de usuário não reconhecido. Tente novamente.");
            System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
            perfilUsuario = scanner.nextLine().toLowerCase();
        }
    }

    private void cadastrarEmpresa() {
        System.out.print("Digite o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        empresa.setNome(nomeEmpresa);
        System.out.println("Empresa cadastrada com sucesso!");
    }

    private void cadastrarProjeto() throws ParseException {
        System.out.print("Digite o nome do projeto: ");
        String nomeProjeto = scanner.nextLine();
        System.out.print("Digite a descrição do projeto: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite a data de início do projeto(dd/MM/yyyy): ");
        String dataInicioP = scanner.nextLine();
        System.out.println("Digite a data final do projeto(dd/MM/yyyy): ");
        String dataFimP = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicioProjeto = dateFormat.parse(dataInicioP);
        Date dataFimProjeto = dateFormat.parse(dataFimP);

        Projeto projeto = new Projeto(nomeProjeto, descricao, dataInicioProjeto, dataFimProjeto);
        String nomeArea1 = " ";
        

        // Exibir lista de áreas cadastradas
        System.out.println("Lista de Áreas Cadastradas:");
        for (String nomeArea : areasCadastradas.keySet()) {
            System.out.println(nomeArea);
            
            nomeArea = nomeArea1 ;
        }

        // Associar projeto a uma área
        System.out.print("Digite o nome da área em que o projeto será cadastrado: ");
        System.out.println(nomeArea1);
        String nomeAreaProjeto = scanner.nextLine();
        Area areaProjeto = areasCadastradas.get(nomeAreaProjeto);

        if (areaProjeto != null) {
            projeto.adicionarArea(areaProjeto);
            System.out.println("Projeto cadastrado na área '" + nomeAreaProjeto + "' com sucesso!");
            empresa.adicionarProjeto(projeto);
        } else {
            System.out.println("Área não encontrada. Cadastre a área primeiro.");
        }

        System.out.println("Você tem um novo projeto!");

    }

    private Area encontrarAreaPorNome(String nomeArea) {
        for (Area area : empresa.getAreas()) {
            if (area.getNome().equals(nomeArea)) {
                return area;
            }
        }
        return null;
    }

    private void cadastrarAtividade() {
        Projeto projeto = escolherProjeto();
        if (projeto != null) {
            System.out.print("Digite o nome da atividade: ");
            String nomeAtividade = scanner.nextLine();

            // Cria uma nova atividade com o nome fornecido pelo usuário
            Atividades atividade = new Atividades(nomeAtividade);
            projeto.adicionarAtividade(atividade);

            System.out.println("Atividade '" + nomeAtividade + "' cadastrada com sucesso!");
        }
    }

    private Projeto escolherProjeto() {
        System.out.print("Digite o nome do projeto: ");
        String nomeProjeto = scanner.nextLine();
        for (Projeto projeto : empresa.getProjetos()) {
            if (projeto.getNome().equals(nomeProjeto)) {
                return projeto;
            }
        }
        System.out.println("Projeto não encontrado. Cadastre o projeto primeiro.");
        return null;
    }

    private Atividades escolherAtividade(Projeto projeto) {
        System.out.print("Digite o nome da atividade: ");
        String nomeAtividade = scanner.nextLine();
        for (Atividades atividade : projeto.getAtividades()) {
            if (atividade.getDescricao().equals(nomeAtividade)) {
                return atividade;
            }
        }
        System.out.println("Atividade não encontrada. Cadastre a atividade primeiro.");
        return null;
    }

    private void cadastrarAcao() {
        Projeto projeto = escolherProjeto();
        if (projeto != null) {
            Atividades atividade = escolherAtividade(projeto);
            if (atividade != null) {
                System.out.print("Digite o nome da ação: ");
                String nomeAcao = scanner.nextLine();

                System.out.print("Digite a área responsável: ");
                String areaResponsavel = scanner.nextLine();

                // Solicitar o nome do usuário responsável
                System.out.print("Digite o nome do usuário responsável pela ação: ");
                String usuarioResponsavel = scanner.nextLine();

                // Solicitar a data de início
                try {
                    System.out.print("Digite a data de início (formato dd/MM/yyyy): ");
                    String dataInicioStr = scanner.nextLine();
                    //Date dataInicio = DateFormat.parse(dataInicioStr);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataInicio = dateFormat.parse(dataInicioStr);

                    System.out.print("Digite a data de término (formato dd/MM/yyyy): ");
                    String dataTerminoStr = scanner.nextLine();
                    Date dataTermino = dateFormat.parse(dataTerminoStr);

                    // Cria o usuário associado à ação
                    Usuario usuario = new Usuario(usuarioResponsavel);

                    // Cria a ação e associa o mesmo usuário como responsável e associado
                    Acao acao = new Acao(nomeAcao, dataInicio, dataTermino, areaResponsavel, usuarioResponsavel);
                    acao.adicionarUsuario(usuario);

                    // Adiciona a ação à atividade
                    atividade.adicionarAcao(acao);

                    System.out.println("Ação cadastrada com sucesso!");

                } catch (ParseException e) {
                    System.out.println("Erro ao converter a data. Ação não cadastrada. Certifique-se de usar o formato correto (dd/MM/yyyy).");

                }

            }
        }
    }

    private Acao encontrarAcaoPorNome(String nomeAcao) {
        for (Projeto projeto : empresa.getProjetos()) {
            for (Atividades atividade : projeto.getAtividades()) {
                for (Acao acao : atividade.getAcoes()) {
                    if (acao.getNome().equals(nomeAcao)) {
                        return acao;
                    }
                }
            }
        }
        return null;  // Retorna null se a ação não for encontrada
    }

    private void atualizarStatusDaAcao() {
        System.out.println("Digite o nome da ação que deseja atualizar: ");
        String nomeAcaoAtualizar = scanner.nextLine();

        // Verificar se a ação com o nome fornecido existe
        Acao acaoAtualizar = encontrarAcaoPorNome(nomeAcaoAtualizar);

        if (acaoAtualizar != null) {
            System.out.println("Ação encontrada. Digite o percentual de conclusão: ");
            int percentual = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            // Atualizar o status da ação
            acaoAtualizar.concluirAcao(percentual);
            System.out.println("Status da ação '" + nomeAcaoAtualizar + "' atualizado com sucesso!");
        } else {
            System.out.println("Ação não encontrada.");
        }
    }

    private void visualizarQuadroKanban() {
        System.out.println("==== Quadro Kanban ====");

        for (Projeto projeto : empresa.getProjetos()) {
            System.out.println("Projeto: " + projeto.getNome());

            for (Atividades atividade : projeto.getAtividades()) {
                System.out.println("\nAtividade: " + atividade.getDescricao());

                for (Acao acao : atividade.getAcoes()) {
                    System.out.println("\t\tAção: " + acao.getNome());
                    System.out.println("\t\t\tStatus: " + acao.getStatus());
                    System.out.println("\t\t\tProgresso: " + acao.progresso() + "%");
                    System.out.println("\t\t\tData de Início: " + acao.getDataInicio());
                    System.out.println("\t\t\tData de Término: " + acao.getDataFim());
                    System.out.println("\t\t\tÁrea Responsável: " + acao.getAreaResponsavel());
                    System.out.println("\t\t\tUsuário Responsável: " + acao.getUsuarioResponsavel());
                }
            }
        }

        System.out.println("======================");
    }

    public static void main(String[] args) throws ParseException {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
