package linketinder.view

import linketinder.model.*

class MenuView {

    // Exibe as opções iniciais do sistema para usuários não autenticados
    static void mostrarMenuInicial() {
        println "\n=== LINKETINDER ==="
        println "1 - Login"
        println "2 - Cadastrar Candidato"
        println "3 - Cadastrar Empresa"
        println "0 - Sair"
        print "Escolha uma opção: "
    }

    // Menu restrito a candidatos após o login bem-sucedido
    static void menuCandidato(String nome) {
        println "\n--- MENU CANDIDATO: " + nome + " ---"
        println "1 - Ver Meus Dados"
        println "2 - Adicionar Competências"
        println "3 - Explorar Empresas"
        println "4 - Ver Meus Matches"
        println "0 - Logout"
        print "Escolha uma opção: "
    }

    // Menu restrito a empresas após o login bem-sucedido
    static void menuEmpresa(String nome) {
        println "\n--- MENU EMPRESA: " + nome + " ---"
        println "1 - Ver Meus Dados"
        println "2 - Adicionar Competências"
        println "3 - Explorar Candidatos"
        println "4 - Ver Meus Matches"
        println "0 - Logout"
        print "Escolha uma opção: "
    }

    // Utiliza o toString() sobrescrito no model para exibir as informações do perfil
    static void exibirPerfilLogado(Object usuario) {
        println "\n--- SEU PERFIL ---"
        println usuario.toString()
    }

    // Padroniza as opções de interação durante a navegação entre perfis
    static void interagirOpcoes() {
        print "\n[L] Curtir | [P] Próximo | [S] Sair: "
    }

    // Itera sobre a lista de matches e exibe nome e e-mail dos contatos correspondentes
    static void exibirMatches(List matches) {
        println "\n--- SEUS MATCHES ---"
        if (matches.isEmpty()) {
            println "Nenhum match encontrado até o momento."
        } else {
            matches.each { println "Match com: " + it.nome + " (" + it.email + ")" }
        }
    }
}