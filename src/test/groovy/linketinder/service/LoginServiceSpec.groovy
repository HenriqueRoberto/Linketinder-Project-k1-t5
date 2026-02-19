package linketinder.service

import spock.lang.Specification
import linketinder.model.Candidato
import linketinder.model.Empresa

class LoginServiceSpec extends Specification {

    def "Deve realizar login de um candidato com sucesso"() {
        given: "Um candidato cadastrado no sistema"
        Candidato c = new Candidato("Teste", "candidato@teste.com", "123", 20, "SC", "88", "Desc", [], "senha123")
        CandidatoService.cadastrar(c)

        when: "Tentamos realizar o login com as credenciais corretas"
        def resultado = LoginService.realizarLogin("candidato@teste.com", "senha123")

        then: "O sistema deve retornar o objeto do candidato"
        resultado instanceof Candidato
        resultado.email == "candidato@teste.com"
    }

    def "Deve retornar null para credenciais inválidas"() {
        when: "Tentamos logar com uma senha incorreta"
        def resultado = LoginService.realizarLogin("candidato@teste.com", "senha_errada")

        then: "O resultado deve ser nulo"
        resultado == null
    }
}