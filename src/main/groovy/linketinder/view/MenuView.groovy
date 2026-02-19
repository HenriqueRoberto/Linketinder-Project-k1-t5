package linketinder.view

import java.util.Scanner
import linketinder.model.Candidato
import linketinder.model.Empresa

class MenuView {
    private static final Scanner scanner = new Scanner(System.in)

    static int mostrarMenuInicial() {
        println "\n=== LINKETINDER - LOGIN ==="
        println "1 - Login como Candidato"
        println "2 - Login como Empresa"
        println "0 - Sair"
        print "Escolha: "
        return scanner.nextInt()
    }

    static String pedirEmail() {
        print "Digite seu email: "
        return scanner.next()
    }

    static int menuCandidato(String nome) {
        println "\n--- Menu do Candidato: $nome ---"
        println "1. Ver Meus Dados"
        println "2. Explorar Empresas (Dar Like)"
        println "3. Ver Meus Matches"
        println "0. Logout"
        print "Escolha: "
        return scanner.nextInt()
    }

    static int menuEmpresa(String nome) {
        println "\n--- Menu da Empresa: $nome ---"
        println "1. Ver Meus Dados"
        println "2. Explorar Candidatos (Dar Like)"
        println "3. Ver Meus Matches"
        println "0. Logout"
        print "Escolha: "
        return scanner.nextInt()
    }

    /* Método genérico para exibir o perfil logado */

    static void exibirPerfilLogado(Object perfil) {
        println "\n=== SEU PERFIL ==="
        println perfil
        println "===================="
    }

    static void listarCandidatos(List<Candidato> candidatos) {
        println "\n=== CANDIDATOS CADASTRADOS ==="
        candidatos.each { candidato ->
            // Ao passar o objeto direto, o Groovy usa o toString() da classe PessoaFisica
            println candidato
            println "-----------------------"
        }
    }

    static void listarEmpresas(List<Empresa> empresas) {
        println "\n=== EMPRESAS CADASTRADAS ==="
        empresas.each { empresa ->
            // Ao passar o objeto direto, o Groovy usa o toString() da classe PessoaJuridica
            println empresa
            println "-----------------------"
        }
    }

    static String interagirComPerfil(Object perfil) {
        println "\n" + perfil
        print "\n[L] Like | [P] Próximo | [S] Sair: "
        return scanner.next().toUpperCase()
    }

    static void exibirMatches(List matches) {
        println "\n --- SEUS MATCHES --- "

        if (matches.isEmpty()) {
            println "Ainda não houve nenhum match. Continue dando likes!"
        } else {
            matches.each { perfil ->
                // Ao imprimir o objeto direto, o Groovy usa o seu toString() completo
                // com CPF/CNPJ, Competências, Descrição, etc.
                println perfil
                println "------------------------------------------"
            }
        }
    }
    static void exibirMensagem(String msg) {
        println msg
    }
}