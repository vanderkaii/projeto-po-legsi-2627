public class Administrador extends Utilizador
{
  private String id;

  private static int contadorId = 1;

  public Administrador(String nomeCompleto, String emailInstitucional, String password)
  {
    super(nomeCompleto, emailInstitucional, password);
    this.id = "A" + contadorId;
  }
  
}
