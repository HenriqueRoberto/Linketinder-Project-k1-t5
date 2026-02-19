package linketinder.model

class Candidato extends PessoaFisica{
    Candidato(String nome, String email, String cpf, int idade, String estado, String cep, String descricao, List<String> competencias, String senha){
        super(nome, email, cpf, idade, estado, cep, descricao, competencias, senha)
    }
}
