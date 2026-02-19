package linketinder.service

import linketinder.model.Empresa
import linketinder.data.DadosMock

class EmpresaService {
    private static List<Empresa> empresas = new ArrayList<>(DadosMock.empresas())

    static void cadastrar(Empresa empresa) {
        empresas.add(empresa)
    }

    static List<Empresa> listar() {
        return empresas
    }
}