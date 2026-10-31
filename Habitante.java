public abstract class Habitante
{
  private int id;
  private String nomeCompleto;
  private String emailInstitucional;
  private int numeroMissoesRealizadas;
  private int numeroDescobertasRegistadas;

  public Habitante(String nomeCompleto, String emailInstitucional)
  {
    this.nomeCompleto = nomeCompleto;
    this.emailInstitucional = emailInstitucional;
  }

  public int getId()
  {
    return this.id;
  }

  public String getNomeCompleto()
  {
    return this.nomeCompleto;
  }

  public String getEmailInstitucional()
  {
    return this.emailInstitucional;
  }

  public int getNumeroMissoesRealizadas()
  {
    return this.numeroMissoesRealizadas;
  }

  public int getNumeroDescobertasRegistadas()
  {
    return this.numeroDescobertasRegistadas;
  }

  public void setNomeCompleto(String nomeCompleto)
  {
    this.nomeCompleto = nomeCompleto;
  }

  public void setEmailInstitucional(String emailInstitucional)
  {
    this.emailInstitucional = emailInstitucional;
  }

  public void setNumeroMissoesRealizadas(int numeroMissoesRealizadas)
  {
    this.numeroMissoesRealizadas = numeroMissoesRealizadas;
  }

  public void setNumeroDescobertasRegistadas(int numeroDescobertasRegistadas)
  {
    this.numeroDescobertasRegistadas = numeroDescobertasRegistadas;
  }
}
