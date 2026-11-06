public class Administrador
{
  private String idAdministrador;
  private String nomeCompleto;
  private String email;
  private static int contadorIdAdministrador = 1;

  public Administrador(String nomeCompleto, String email)
  {
    this.idAdministrador = "A" + contadorIdAdministrador;
    contadorIdAdministrador++;
    this.setNomeCompleto(nomeCompleto);
    this.setEmail(email);
  }

  public String getIdAdministrador()
  {
    return this.idAdministrador;
  }

  public String getNomeCompleto()
  {
    return this.nomeCompleto;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setNomeCompleto(String nomeCompleto)
  {
    this.nomeCompleto = nomeCompleto;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }
  
}
