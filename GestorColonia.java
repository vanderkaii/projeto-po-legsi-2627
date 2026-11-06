public class GestorColonia
{
  private String idGestor;
  private String nomeCompleto;
  private String email;
  private int numMissoesSuperv;
  private static int contadorIdGestor = 1;

  public GestorColonia(String nomeCompleto, String email)
  {
    this.idGestor = "G" + contadorIdGestor;
    contadorIdGestor++;
    this.setNomeCompleto(nomeCompleto);
    this.setEmail(email);
    this.setNumMissoesSuperv(0);
  }

  public String getIdGestor()
  {
    return this.idGestor;
  }

  public String getNomeCompleto()
  {
    return this.nomeCompleto;
  }

  public String getEmail()
  {
    return this.email;
  }

  public int getNumMissoesSuperv()
  {
    return this.numMissoesSuperv;
  }

  public void setNomeCompleto(String nomeCompleto)
  {
    this.nomeCompleto = nomeCompleto;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setNumMissoesSuperv(int numMissoesSuperv)
  {
    if (numMissoesSuperv >= 0)
      this.numMissoesSuperv = numMissoesSuperv;
  }
}
