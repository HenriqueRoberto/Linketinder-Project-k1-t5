package linketinder.controller

import linketinder.service.*
import linketinder.model.*
import linketinder.view.MenuView
import linketinder.data.DadosMock

class AppController {

    static void iniciar() {
        while (true) {
            int opcao = MenuView.mostrarMenuInicial()

            switch (opcao) {
                case 1:
                    def candidatoLogado = LoginService.obterCandidatoMocado()
                    fluxoCandidato(candidatoLogado)
                    break
                case 2:
                    def empresaLogada = LoginService.obterEmpresaMocada()
                    fluxoEmpresa(empresaLogada)
                    break
                case 0:
                    println "Encerrando sistema..."
                    return
            }
        }
    }

    private static void fluxoCandidato(Candidato logado) {
        while (true) {
            int op = MenuView.menuCandidato(logado.nome)

            switch (op) {
                case 1: // Ver Meus Dados
                    MenuView.exibirPerfilLogado(logado)
                    break

                case 2: // Explorar Empresas (Sistema de Like)
                    println "\n--- Explorando Empresas Disponíveis ---"
                    for (empresa in DadosMock.empresas()) {
                        String acao = MenuView.interagirComPerfil(empresa)

                        if (acao == "L") {
                            MatchService.registrarLikeCandidato(logado.email, empresa.email)
                            // Verifica imediatamente se a empresa já deu like neste candidato
                            if (MatchService.houveMatch(logado.email, empresa.email)) {
                                println "\n🔥 MATCH! A empresa ${empresa.nome} também se interessou por ti!"
                            } else {
                                println "Interesse registado! Se a empresa retribuir, terás um Match."
                            }
                        } else if (acao == "S") {
                            break
                        }
                    }
                    println "\n[Fim da lista de empresas]"
                    break

                case 3: // Ver Meus Matches (Reciprocidade)
                    def matches = MatchService.obterMatchesCandidato(logado.email, DadosMock.empresas())
                    MenuView.exibirMatches(matches)
                    break

                case 0: // Logout
                    return
            }
        }
    }

    private static void fluxoEmpresa(Empresa logada) {
        while (true) {
            int op = MenuView.menuEmpresa(logada.nome)

            switch (op) {
                case 1: // Ver Meus Dados
                    MenuView.exibirPerfilLogado(logada)
                    break

                case 2: // Explorar Candidatos (Sistema de Like)
                    println "\n--- Analisando Candidatos ---"
                    for (candidato in DadosMock.candidatos()) {
                        String acao = MenuView.interagirComPerfil(candidato)

                        if (acao == "L") {
                            MatchService.registrarLikeEmpresa(logada.email, candidato.email)
                            // Verifica se o candidato já deu like nesta empresa
                            if (MatchService.houveMatch(candidato.email, logada.email)) {
                                println "\n🔥 MATCH! O candidato ${candidato.nome} tem interesse na tua empresa!"
                            } else {
                                println "Interesse registado! Aguarda a retribuição do candidato."
                            }
                        } else if (acao == "S") {
                            break
                        }
                    }
                    println "\n[Fim da lista de candidatos]"
                    break

                case 3: // Ver Meus Matches (Reciprocidade)
                    def matches = MatchService.obterMatchesEmpresa(logada.email, DadosMock.candidatos())
                    MenuView.exibirMatches(matches)
                    break

                case 0: // Logout
                    return
            }
        }
    }
}