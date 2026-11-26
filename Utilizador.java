public abstract class Utilizador
{
  private String nome;
  private String email;
  private String password; // Necessário para a funcionalidade de autenticação. Por razões de segurança, as
                           // passwords não devem ser armazenadas em texto simples.
                           /*
                            PROVAVELMENTE FOI UM LLM QUE SUGERIU ISSO. NO MUNDO REAL USARIA-SE UMA HASH,
                            MAS COMO ISTO É UM PROJETO DE
                            UNIVERSIDADE, NÃO VAMOS SER HACKEADOS, POR ISSO NAO É NECESSÁRIO. FICA EM
                            TEXTO SIMPLES NUM HASHMAP.
                            */
  
  public Utilizador(String nome, String email, String password)
  {
    setNome(nome);
    setEmail(email);
    setPassword(password);
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    if (nome == null || nome.isEmpty())
    {
      throw new IllegalArgumentException("O nome não pode estar vazio");
    }
    
    this.nome = nome;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    if (email == null || email.isEmpty() || !email.contains("@") || !email.contains("."))
    {
      throw new IllegalArgumentException("Email inválido");
    }

    this.email = email;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    if (password == null || password.isEmpty())
    {
      throw new IllegalArgumentException("Password inválida");
    }
    this.password = password;
  }

  public boolean autenticar(String password)
  {
    return this.password.equals(password);
  }
}