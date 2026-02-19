package linketinder.service

import spock.lang.Specification
import linketinder.model.Empresa

class EmpresaServiceSpec extends Specification {

    def "Deve cadastrar uma nova empresa com sucesso na lista"() {
        given: "Uma nova empresa"
        def empresa = new Empresa("Tech Corp", "rh@tech.com", "999", "Brasil", "SP", "01000", "TI", ["Java"], "senhaEmpresa123")
        int totalAntes = EmpresaService.listar().size()

        when: "O método de cadastro da empresa é chamado"
        EmpresaService.cadastrar(empresa)

        then: "Verifica se a lista aumentou e se o dado está correto"
        assert EmpresaService.listar().size() == totalAntes + 1
        assert EmpresaService.listar().last().email == "rh@tech.com"
        assert EmpresaService.listar().last().senha == "senhaEmpresa123"

    }
}