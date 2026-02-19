package linketinder.service

import linketinder.model.Candidato
import linketinder.model.Empresa

class LoginService {

    // Procura o candidato mocado pelo e-mail
    static Candidato autenticarCandidato(List<Candidato> candidatos, String email) {
        return candidatos.find { it.email.equalsIgnoreCase(email) }
    }

    // Procura a empresa mocada pelo e-mail
    static Empresa autenticarEmpresa(List<Empresa> empresas, String email) {
        return empresas.find { it.email.equalsIgnoreCase(email) }
    }
}