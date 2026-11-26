public abstract class Habitante extends Utilizador
{
  private String id;
  private String profissao;
  private Colonia colonia;

  private static int contadorId = 1; // Variável que serve de contador para o número do ID.
                                     // static significa que é uma variável partilhada
                                     // por esta classe e todas as suas instâncias.

  public Habitante(String nomeCompleto, String emailInstitucional, String password)
  {
    this.id = "H" + contadorId++;
    super(nomeCompleto, emailInstitucional, password);
  }

  public String getId()
  {
    return this.id;
  }

  public String getProfissao()
  {
    return this.profissao;
  }

  public void setProfissao(String profissao)
  {
    /*
     * if (profissao == null || profissao.isEmpty()) { throw new
     * IllegalArgumentException("Profissão inválida"); }
     */
    this.profissao = profissao;
  }

  public Colonia getColonia()
  {
    return this.colonia;
  }

  public void setColonia(Colonia colonia)
  {
    if (colonia == null)
    {
      throw new IllegalArgumentException("Colónia inválida");
    }

    this.colonia = colonia;
  }
}
