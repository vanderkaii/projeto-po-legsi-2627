public abstract class Utilizador{
    private String nome;
    private String email;
    private String profissao;

    public Utilizador(String nomeCompleto, String emailInstitucional, String profissao) {
        this.nome = nomeCompleto;
        this.email = emailInstitucional;
        this.profissao = profissao;
    }
}