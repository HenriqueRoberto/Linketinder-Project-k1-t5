package linketinder.service

import linketinder.model.Empresa
import linketinder.data.DadosMock

class EmpresaService {
    private static List<Empresa> empresas = DadosMock.empresas()

    static void cadastrar(Empresa empresa) {
        // Verifica duplicidade ignorando maiúsculas/minúsculas
        boolean emailExiste = empresas.any { it.email.equalsIgnoreCase(empresa.email) }

        if (emailExiste) {
            throw new IllegalArgumentException("Erro: O e-mail " + empresa.email + " já está cadastrado.")
        }

        empresas.add(empresa)
    }

    static List<Empresa> listar() {
        return empresas
    }
}