package linketinder.service

import linketinder.model.Candidato
import linketinder.model.Empresa

class LoginService {

    /**
     * Varre as listas de candidatos e empresas para validar as credenciais.
     * Retorna o objeto encontrado ou null caso não exista correspondência.
     */
    static Object realizarLogin(String email, String senha) {

        // Busca na lista de candidatos
        def candidato = CandidatoService.listar().find { it.email == email && it.senha == senha }
        if (candidato) {
            return candidato
        }

        // Busca na lista de empresas caso não encontre na de candidatos
        def empresa = EmpresaService.listar().find { it.email == email && it.senha == senha }
        if (empresa) {
            return empresa
        }

        return null
    }
}