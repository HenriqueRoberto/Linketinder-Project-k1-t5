package linketinder.service

import linketinder.model.Candidato
import linketinder.model.Empresa

class MatchService {
    private static Set<String> likesCandidatos = [] as Set
    private static Set<String> likesEmpresas = [] as Set

    static void registrarLikeCandidato(String emailCandidato, String emailEmpresa) {
        likesCandidatos.add("${emailCandidato}:${emailEmpresa}")
    }

    static void registrarLikeEmpresa(String emailEmpresa, String emailCandidato) {
        likesEmpresas.add("${emailEmpresa}:${emailCandidato}")
    }

    static boolean houveMatch(String emailCandidato, String emailEmpresa) {
        return likesCandidatos.contains("${emailCandidato}:${emailEmpresa}") &&
                likesEmpresas.contains("${emailEmpresa}:${emailCandidato}")
    }

    static List obterMatchesCandidato(String emailCandidato, List todasEmpresas) {
        return todasEmpresas.findAll { houveMatch(emailCandidato, it.email) }
    }

    static List obterMatchesEmpresa(String emailEmpresa, List todosCandidatos) {
        return todosCandidatos.findAll { houveMatch(it.email, emailEmpresa) }
    }
}