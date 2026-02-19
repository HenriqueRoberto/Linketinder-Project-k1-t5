package linketinder.service

import linketinder.model.Candidato
import linketinder.model.Empresa
import linketinder.data.DadosMock

class LoginService {
    // Retorna um usuário específico da lista mada para simular "sessão ativa"
    static Candidato obterCandidatoMocado() {
        return DadosMock.candidatos().first()
    }

    static Empresa obterEmpresaMocada() {
        return DadosMock.empresas().first()
    }
}