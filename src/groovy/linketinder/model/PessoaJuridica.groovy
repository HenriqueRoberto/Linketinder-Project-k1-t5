package groovy.linketinder.model

class PessoaJuridica implements Pessoa {

    String nome
    String email
    String cnpj
    String pais
    String estado
    String cep
    String descricao
    List<String> competencias = []

    String getNome() { nome }
    String getEmail() { email }
    String getEstado() { estado }
    String getCep() { cep }
    String getDescricao() { descricao }
    List<String> getCompetencias() { competencias } //que exige

    String getCnpj() { cnpj }
    String getPais() { pais }

    @Override
    String toString() {
        return "Nome: " + nome +
                "\nEmail Corporativo: " + email +
                "\nCNPJ: " + cnpj +
                "\nPaís: " + pais +
                "\nEstado: " + estado +
                "\nCEP: " + cep +
                "\nDescrição: " + descricao +
                "\nCompetências esperadas: " + competencias
    }
}
