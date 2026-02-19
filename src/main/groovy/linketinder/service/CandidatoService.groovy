package linketinder.service

import linketinder.model.Candidato
import linketinder.data.DadosMock

class CandidatoService {
    private static List<Candidato> candidatos = DadosMock.candidatos()

    static void cadastrar(Candidato candidato) {
        // Verifica se já existe alguém com o mesmo e-mail na lista
        boolean emailExiste = candidatos.any { it.email.equalsIgnoreCase(candidato.email) }

        if (emailExiste) {
            // Lança uma exceção para o Controller avisar o usuário
            throw new IllegalArgumentException("Erro: O e-mail " + candidato.email + " já está cadastrado.")
        }

        candidatos.add(candidato)
    }

    static List<Candidato> listar() {
        return candidatos
    }
}