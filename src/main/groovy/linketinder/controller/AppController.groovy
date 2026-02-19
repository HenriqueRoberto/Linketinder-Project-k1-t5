package linketinder.controller

import linketinder.service.*
import linketinder.model.*
import linketinder.view.MenuView
import java.util.Scanner

class AppController {

    private static Scanner scanner = new Scanner(System.in)

    // Armazena o objeto do usuário logado para persistência de sessão durante a execução
    private static Object usuarioLogado = null

    static void iniciar() {
        while (true) {
            MenuView.mostrarMenuInicial()
            // Lê o inteiro e consome a quebra de linha para evitar erros no próximo scanner.nextLine()
            int opcao = scanner.nextInt()
            scanner.nextLine()

            switch (opcao) {
                case 1: fluxoLogin(); break
                case 2: fluxoCadastroCandidato(); break
                case 3: fluxoCadastroEmpresa(); break
                case 0: return
            }
        }
    }

    private static void fluxoLogin() {
        println "\n--- LOGIN ---"
        print "Email: "; String email = scanner.nextLine().trim()
        print "Senha: "; String senha = scanner.nextLine().trim()

        // Invoca o serviço de autenticação para validar as credenciais informadas
        usuarioLogado = LoginService.realizarLogin(email, senha)

        if (usuarioLogado != null) {
            // Verifica o tipo de classe da instância para determinar qual menu carregar
            if (usuarioLogado instanceof Candidato) fluxoCandidato()
            else if (usuarioLogado instanceof Empresa) fluxoEmpresa()
        } else {
            println "Erro: Credenciais invalidas."
        }
    }

    private static void fluxoCandidato() {
        while (usuarioLogado != null) {
            MenuView.menuCandidato(usuarioLogado.nome)
            int op = scanner.nextInt()
            scanner.nextLine()

            switch (op) {
                case 1: MenuView.exibirPerfilLogado(usuarioLogado); break
                case 2: adicionarCompetencias(); break
                case 3: explorarEmpresas(); break
                case 4:
                    // Busca matches baseados no e-mail do candidato logado
                    def matches = MatchService.obterMatchesCandidato(usuarioLogado.email)
                    MenuView.exibirMatches(matches)
                    break
                case 0:
                    // Limpa a variável de sessão para efetuar o logoff
                    usuarioLogado = null
                    break
            }
        }
    }

    private static void fluxoEmpresa() {
        while (usuarioLogado != null) {
            MenuView.menuEmpresa(usuarioLogado.nome)
            int op = scanner.nextInt()
            scanner.nextLine()

            switch (op) {
                case 1: MenuView.exibirPerfilLogado(usuarioLogado); break
                case 2: adicionarCompetencias(); break
                case 3: explorarCandidatos(); break
                case 4:
                    def matches = MatchService.obterMatchesEmpresa(usuarioLogado.email)
                    MenuView.exibirMatches(matches)
                    break
                case 0: usuarioLogado = null; break
            }
        }
    }

    private static void adicionarCompetencias() {
        // Permite que o usuário adicione múltiplas competências em um loop contínuo
        while (true) {
            print "Digite a competencia (ou 'sair' para voltar): "
            String entrada = scanner.nextLine().trim()
            if (entrada.equalsIgnoreCase("sair")) break

            if (!entrada.isEmpty()) {
                // Adiciona a string diretamente à lista de competências do objeto logado
                usuarioLogado.competencias.add(entrada)
                println "Sucesso: '" + entrada + "' adicionada!"
            }
        }
    }

    private static void explorarEmpresas() {
        // Itera sobre a lista dinâmica de empresas fornecida pelo serviço
        for (empresa in EmpresaService.listar()) {
            println "\n------------------------"
            println empresa.toString()
            MenuView.interagirOpcoes()
            String acao = scanner.nextLine().toUpperCase()

            if (acao == "L") {
                // Registra o interesse do candidato logado e verifica reciprocidade
                MatchService.registrarLikeCandidato(usuarioLogado.email, empresa.email)
                if (MatchService.houveMatch(usuarioLogado.email, empresa.email)) {
                    println "MATCH com " + empresa.nome + "!"
                }
            } else if (acao == "S") break
        }
    }

    private static void explorarCandidatos() {
        for (candidato in CandidatoService.listar()) {
            println "\n------------------------"
            println candidato.toString()
            MenuView.interagirOpcoes()
            String acao = scanner.nextLine().toUpperCase()

            if (acao == "L") {
                // Registra o interesse da empresa logada e verifica reciprocidade
                MatchService.registrarLikeEmpresa(usuarioLogado.email, candidato.email)
                if (MatchService.houveMatch(candidato.email, usuarioLogado.email)) {
                    println "MATCH com " + candidato.nome + "!"
                }
            } else if (acao == "S") break
        }
    }

    private static void fluxoCadastroCandidato() {
        println "\n--- NOVO CANDIDATO ---"
        print "Nome: "; String nome = scanner.nextLine()
        print "Email: "; String email = scanner.nextLine()
        print "CPF: "; String cpf = scanner.nextLine()
        print "Idade: "; int idade = scanner.nextInt(); scanner.nextLine()
        print "Estado: "; String estado = scanner.nextLine()
        print "CEP: "; String cep = scanner.nextLine()
        print "Senha: "; String senha = scanner.nextLine()
        print "Descricao: "; String desc = scanner.nextLine()

        try {
            // Tenta cadastrar o novo objeto; o Service validará a unicidade do e-mail
            Candidato novo = new Candidato(nome, email, cpf, idade, estado, cep, desc, [], senha)
            CandidatoService.cadastrar(novo)
            println "Sucesso: Cadastrado com sucesso!"
        } catch (IllegalArgumentException e) {
            // Captura a exceção lançada pelo Service caso o e-mail já exista
            println "Erro: " + e.getMessage()
        }
    }

    private static void fluxoCadastroEmpresa() {
        println "\n--- NOVA EMPRESA ---"
        print "Nome: "; String nome = scanner.nextLine()
        print "Email: "; String email = scanner.nextLine()
        print "CNPJ: "; String cnpj = scanner.nextLine()
        print "Pais: "; String pais = scanner.nextLine()
        print "Estado: "; String estado = scanner.nextLine()
        print "CEP: "; String cep = scanner.nextLine()
        print "Senha: "; String senha = scanner.nextLine()
        print "Descricao: "; String desc = scanner.nextLine()

        try {
            Empresa nova = new Empresa(nome, email, cnpj, pais, estado, cep, desc, [], senha)
            EmpresaService.cadastrar(nova)
            println "Sucesso: Cadastrada com sucesso!"
        } catch (IllegalArgumentException e) {
            println "Erro: " + e.getMessage()
        }
    }
}