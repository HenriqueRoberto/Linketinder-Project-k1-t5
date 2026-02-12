package groovy.linketinder.model

class PessoaFisica implements Pessoa {

    String nome
    String email
    String cpf
    int idade
    String estado
    String cep
    String descricao
    List<String> competencias = []

    String getNome() { nome }
    String getEmail() { email }
    String getEstado() { estado }
    String getCep() { cep }
    String getDescricao() { descricao }
    List<String> getCompetencias() { competencias }

    String getCpf() { cpf }
    int getIdade() { idade }

    @Override
    String toString() {
        return "Nome: " + nome +
                "\nEmail: " + email +
                "\nCPF: " + cpf +
                "\nIdade: " + idade +
                "\nEstado: " + estado +
                "\nCEP: " + cep +
                "\nDescrição: " + descricao +
                "\nCompetências: " + competencias
    }
}
