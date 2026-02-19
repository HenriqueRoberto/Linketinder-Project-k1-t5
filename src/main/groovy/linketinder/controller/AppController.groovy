package linketinder.controller

import linketinder.data.DadosMock
import linketinder.view.MenuView
import linketinder.model.Candidato
import linketinder.model.Empresa

class AppController {
    private static List<Candidato> candidatos = DadosMock.candidatos()
    private static List<Empresa> empresas = DadosMock.empresas()

    static void iniciar() {
        while (true) {
            int opcao = MenuView.mostrarMenuInicial()
            switch (opcao) {
                case 1: processarLoginCandidato(); break
                case 2: processarLoginEmpresa(); break
                case 0: return
                default: MenuView.exibirMensagem("Opção inválida.")
            }
        }
    }

    private static void processarLoginCandidato() {
        String email = MenuView.pedirEmail()
        Candidato logado = candidatos.find { it.email == email }

        if (logado) {
            fluxoCandidato(logado)
        } else {
            MenuView.exibirMensagem("Candidato não encontrado.")
        }
    }

    private static void processarLoginEmpresa() {
        String email = MenuView.pedirEmail()
        Empresa logada = empresas.find { it.email == email }

        if (logada) {
            fluxoEmpresa(logada)
        } else {
            MenuView.exibirMensagem("Empresa não encontrada.")
        }
    }

    private static void fluxoCandidato(Candidato c) {
        while (true) {
            int op = MenuView.menuCandidato(c.nome)
            if (op == 1) MenuView.exibirPerfil(c)
            else if (op == 2) MenuView.listarEmpresas(empresas)
            else if (op == 0) break
        }
    }

    private static void fluxoEmpresa(Empresa e) {
        while (true) {
            int op = MenuView.menuEmpresa(e.nome)
            if (op == 1) MenuView.exibirPerfil(e)
            else if (op == 2) MenuView.listarCandidatos(candidatos)
            else if (op == 0) break
        }
    }
}