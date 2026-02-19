package linketinder.service

import linketinder.model.Candidato
import linketinder.data.DadosMock

class CandidatoService {
    // Lista iniciada com os mocks
    private static List<Candidato> candidatos = new ArrayList<>(DadosMock.candidatos())

    static void cadastrar(Candidato candidato) {
        candidatos.add(candidato)
    }

    static List<Candidato> listar() {
        return candidatos
    }
}