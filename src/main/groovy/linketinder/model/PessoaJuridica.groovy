package linketinder.model

class PessoaJuridica implements Pessoa {

    String nome
    String email
    String cnpj
    String pais
    String estado
    String cep
    String descricao
    List<String> competencias
    String senha // Adicionado para permitir o Login

    // Construtor completo: Essencial para o TDD e os Services
    PessoaJuridica(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao, List<String> competencias, String senha) {
        this.nome = nome
        this.email = email
        this.cnpj = cnpj
        this.pais = pais
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.competencias = competencias
        this.senha = senha
    }

    // Implementação exigida pela Interface Pessoa
    @Override String getNome() { return nome }
    @Override String getEmail() { return email }
    @Override String getEstado() { return estado }
    @Override String getCep() { return cep }
    @Override String getDescricao() { return descricao }
    @Override List<String> getCompetencias() { return competencias }

    // Getters específicos de Pessoa Jurídica
    String getCnpj() { return cnpj }
    String getPais() { return pais }

    @Override
    String toString() {
        String compTexto = (competencias == null || competencias.isEmpty()) ?
                "sem competências exigidas" : competencias.join(", ")

        return "Nome: " + nome +
                "\nEmail Corporativo: " + email +
                "\nCNPJ: " + cnpj +
                "\nPaís: " + pais +
                "\nEstado: " + estado +
                "\nCEP: " + cep +
                "\nDescrição: " + (descricao ?: "Sem descrição") +
                "\nCompetências esperadas: " + compTexto
    }
}
