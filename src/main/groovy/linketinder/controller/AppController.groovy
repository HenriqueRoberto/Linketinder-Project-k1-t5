package linketinder.controller

import linketinder.service.LoginService
import linketinder.view.MenuView
import linketinder.data.DadosMock

class AppController {

    static void iniciar() {
        while (true) {
            int opcao = MenuView.mostrarMenuInicial()

            switch (opcao) {
                case 1:
                    // Login automático: já pega o candidato mocado e abre o menu dele
                    def candidatoLogado = LoginService.obterCandidatoMocado()
                    fluxoCandidato(candidatoLogado)
                    break
                case 2:
                    // Login automático: já pega a empresa mocada e abre o menu dela
                    def empresaLogada = LoginService.obterEmpresaMocada()
                    fluxoEmpresa(empresaLogada)
                    break
                case 0:
                    return
            }
        }
    }

    private static void fluxoCandidato(candidato) {
        while (true) {
            int op = MenuView.menuCandidato(candidato.nome)
            if (op == 1) MenuView.exibirPerfil(candidato)
            else if (op == 2) MenuView.listarEmpresas(DadosMock.empresas())
            else if (op == 0) break
        }
    }

    private static void fluxoEmpresa(empresa) {
        while (true) {
            int op = MenuView.menuEmpresa(empresa.nome)
            if (op == 1) MenuView.exibirPerfil(empresa)
            else if (op == 2) MenuView.listarCandidatos(DadosMock.candidatos())
            else if (op == 0) break
        }
    }
}