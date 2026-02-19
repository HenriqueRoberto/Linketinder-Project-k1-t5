package linketinder.service

import linketinder.model.Candidato
import linketinder.model.Empresa

class MatchService {
    // Armazena os likes: [emailOrigem: [emailDestino1, emailDestino2]]
    private static Map<String, Set<String>> likesCandidatos = [:]
    private static Map<String, Set<String>> likesEmpresas = [:]

    static void registrarLikeCandidato(String emailCandidato, String emailEmpresa) {
        if (!likesCandidatos[emailCandidato]) likesCandidatos[emailCandidato] = [] as Set
        likesCandidatos[emailCandidato].add(emailEmpresa)
    }

    static void registrarLikeEmpresa(String emailEmpresa, String emailCandidato) {
        if (!likesEmpresas[emailEmpresa]) likesEmpresas[emailEmpresa] = [] as Set
        likesEmpresas[emailEmpresa].add(emailCandidato)
    }

    static boolean houveMatch(String emailCandidato, String emailEmpresa) {
        // Verifica se ambos deram like um no outro
        return likesCandidatos[emailCandidato]?.contains(emailEmpresa) &&
                likesEmpresas[emailEmpresa]?.contains(emailCandidato)
    }

    static List<Empresa> obterMatchesCandidato(String emailCandidato) {
        // Filtra as empresas que resultaram em match
        return EmpresaService.listar().findAll { empresa ->
            houveMatch(emailCandidato, empresa.email)
        }
    }

    static List<Candidato> obterMatchesEmpresa(String emailEmpresa) {
        // Filtra os candidatos que resultaram em match
        return CandidatoService.listar().findAll { candidato ->
            houveMatch(candidato.email, emailEmpresa)
        }
    }
}