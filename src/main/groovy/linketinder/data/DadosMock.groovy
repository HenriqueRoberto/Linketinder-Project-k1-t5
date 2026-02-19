package linketinder.data

import linketinder.model.Candidato
import linketinder.model.Empresa

class DadosMock {

    static List<Candidato> candidatos() {
        [
                new Candidato("Ana Silva", "ana@email.com", "11111111111", 22, "SC", "88000-000", "Desenvolvedora iniciante", ["Java", "SQL"], "senha123"),
                new Candidato("Bruno Costa", "bruno@email.com", "22222222222", 25, "SP", "01000-000", "Back-end Node", ["Node", "MongoDB"], "senha123"),
                new Candidato("Carla Souza", "carla@email.com", "33333333333", 24, "RS", "90000-000", "Front-end", ["Angular", "CSS"], "senha123"),
                new Candidato("Diego Alves", "diego@email.com", "44444444444", 28, "PR", "80000-000", "Fullstack", ["React", "Node"], "senha123"),
                new Candidato("Elisa Rocha", "elisa@email.com", "55555555555", 21, "RJ", "20000-000", "Estudante de TI", ["Python", "Pandas"], "senha123")
        ]
    }

    static List<Empresa> empresas() {
        [
                new Empresa("TechSul", "rh@techsul.com", "11111111000101", "Brasil", "RS", "90000-100", "Software sob demanda", ["Java", "Spring"], "corp123"),
                new Empresa("DataWave", "jobs@datawave.com", "22222222000102", "Brasil", "SP", "01000-100", "Dados e analytics", ["Python", "SQL"], "corp123"),
                new Empresa("CloudNova", "vagas@cloudnova.com", "33333333000103", "Brasil", "SC", "88000-100", "Infraestrutura cloud", ["Docker", "Linux"], "corp123"),
                new Empresa("WebPrime", "contato@webprime.com", "44444444000104", "Brasil", "PR", "80000-100", "Desenvolvimento web", ["React", "Node"], "corp123"),
                new Empresa("InovaTech", "talentos@inovatech.com", "55555555000105", "Brasil", "RJ", "20000-100", "Soluções digitais", ["Angular", "TypeScript"], "corp123")
        ]
    }
}