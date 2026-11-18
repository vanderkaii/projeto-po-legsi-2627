public abstract class Habitante {

    private int id;
    private String nomeCompleto;
    private String emailInstitucional;
    private String profissao;
    private String password; // Necessário para a funcionalidade de autenticação. Por razões de segurança, as passwords não devem ser armazenadas em texto simples.
    private Colonia colonia;

    private static int contadorId = 1; // Variável que serve de contador para o número do ID.
                                       // static significa que é uma variável artilhada
                                       // por esta classe e todas as suas instâncias.

    public Habitante(String nomeCompleto, String emailInstitucional, String profissao, String password) {
        this.nomeCompleto = nomeCompleto;
        this.emailInstitucional = emailInstitucional;
        this.profissao = profissao;
        this.password = password;
        this.id = contadorId++;
    }

    public int getId() {
        return this.id;
    }

    public void setNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar vazio");
        }
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        if (emailInstitucional == null || emailInstitucional.isEmpty() || !emailInstitucional.contains("@") || !emailInstitucional.contains(".")){           
            throw new IllegalArgumentException("Email inválido");  
        }
        this.emailInstitucional = emailInstitucional; 
    }

    public String getEmailInstitucional() {
        return this.emailInstitucional;
    }

    public void setProfissao(String profissao) {
        if (profissao == null || profissao.isEmpty()) {
            throw new IllegalArgumentException("Profissão inválida");
        }
        this.profissao = profissao;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password inválida"); 
        }
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public Colonia getColonia() {
        return this.colonia;
    }

    public void setColonia(Colonia colonia) {
        if (colonia == null) {
            throw new IllegalArgumentException("Colónia inválida");
        }
        this.colonia = colonia;
    }

    public boolean autenticar(String password) {
      return this.password.equals(password);
    }
}

