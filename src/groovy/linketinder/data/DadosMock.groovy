package groovy.linketinder.data

import groovy.linketinder.model.*

class DadosMock {

    static List<Candidato> candidatos() {
        [
                new Candidato(
                        nome: "Ana Silva",
                        email: "ana@email.com",
                        cpf: "11111111111",
                        idade: 22,
                        estado: "SC",
                        cep: "88000-000",
                        descricao: "Desenvolvedora iniciante",
                        competencias: ["Java", "SQL"]
                ),
                new Candidato(
                        nome: "Bruno Costa",
                        email: "bruno@email.com",
                        cpf: "22222222222",
                        idade: 25,
                        estado: "SP",
                        cep: "01000-000",
                        descricao: "Back-end Node",
                        competencias: ["Node", "MongoDB"]
                ),
                new Candidato(
                        nome: "Carla Souza",
                        email: "carla@email.com",
                        cpf: "33333333333",
                        idade: 24,
                        estado: "RS",
                        cep: "90000-000",
                        descricao: "Front-end",
                        competencias: ["Angular", "CSS"]
                ),
                new Candidato(
                        nome: "Diego Alves",
                        email: "diego@email.com",
                        cpf: "44444444444",
                        idade: 28,
                        estado: "PR",
                        cep: "80000-000",
                        descricao: "Fullstack",
                        competencias: ["React", "Node"]
                ),
                new Candidato(
                        nome: "Elisa Rocha",
                        email: "elisa@email.com",
                        cpf: "55555555555",
                        idade: 21,
                        estado: "RJ",
                        cep: "20000-000",
                        descricao: "Estudante de TI",
                        competencias: ["Python", "Pandas"]
                )
        ]
    }

    static List<Empresa> empresas() {
        [
                new Empresa(
                        nome: "TechSul",
                        email: "rh@techsul.com",
                        cnpj: "11111111000101",
                        pais: "Brasil",
                        estado: "RS",
                        cep: "90000-100",
                        descricao: "Software sob demanda",
                        competencias: ["Java", "Spring"]
                ),
                new Empresa(
                        nome: "DataWave",
                        email: "jobs@datawave.com",
                        cnpj: "22222222000102",
                        pais: "Brasil",
                        estado: "SP",
                        cep: "01000-100",
                        descricao: "Dados e analytics",
                        competencias: ["Python", "SQL"]
                ),
                new Empresa(
                        nome: "CloudNova",
                        email: "vagas@cloudnova.com",
                        cnpj: "33333333000103",
                        pais: "Brasil",
                        estado: "SC",
                        cep: "88000-100",
                        descricao: "Infraestrutura cloud",
                        competencias: ["Docker", "Linux"]
                ),
                new Empresa(
                        nome: "WebPrime",
                        email: "contato@webprime.com",
                        cnpj: "44444444000104",
                        pais: "Brasil",
                        estado: "PR",
                        cep: "80000-100",
                        descricao: "Desenvolvimento web",
                        competencias: ["React", "Node"]
                ),
                new Empresa(
                        nome: "InovaTech",
                        email: "talentos@inovatech.com",
                        cnpj: "55555555000105",
                        pais: "Brasil",
                        estado: "RJ",
                        cep: "20000-100",
                        descricao: "Soluções digitais",
                        competencias: ["Angular", "TypeScript"]
                )
        ]
    }
}
