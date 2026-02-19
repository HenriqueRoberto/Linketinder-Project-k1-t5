package linketinder.model

class Empresa extends PessoaJuridica {
    Empresa(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao, List<String> competencias, String senha) {
        super(nome, email, cnpj, pais, estado, cep, descricao, competencias, senha)
    }
}