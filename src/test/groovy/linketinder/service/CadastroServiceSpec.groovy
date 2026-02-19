package linketinder.service

import spock.lang.Specification
import linketinder.model.Candidato

class CandidatoServiceSpec extends Specification {

    def "Deve cadastrar um novo candidato com sucesso na lista viva"() {
        given: "Um novo candidato"
        def candidato = new Candidato("Henrique", "h@teste.com", "123", 25, "SC", "88", "Dev", ["Groovy"],"123456")
        int totalAntes = CandidatoService.listar().size()

        when: "O método de cadastro é chamado"
        CandidatoService.cadastrar(candidato)

        then: "Verifica se a lista aumentou e se o dado está correto"
        assert CandidatoService.listar().size() == totalAntes + 1
        assert CandidatoService.listar().last().email == "h@teste.com"
        assert CandidatoService.listar().last().senha == "123456"
    }
}