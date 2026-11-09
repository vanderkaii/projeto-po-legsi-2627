public abstract class Habitante
{
  private int id;
  private String nomeCompleto;
  private String emailInstitucional;
  private String profissao;
  private int numeroMissoesRealizadas;
  private int numeroDescobertasRegistadas;
  private static int contadorId = 1; // variavel que serve de contador para o numero do ID.
                                     // static significa que é uma variavel global para esta classe e todas as suas
                                     // filhas

  public Habitante(String nomeCompleto, String emailInstitucional, String profissao)
  {
    this.nomeCompleto = nomeCompleto;
    this.emailInstitucional = emailInstitucional;
    this.profissao = profissao;
    this.numeroDescobertasRegistadas = 0;
    this.numeroMissoesRealizadas = 0;
    this.id = contadorId;
    contadorId++;
  }

  public int getId()
  {
    return this.id;
  }

  public void setNomeCompleto(String nomeCompleto)
  {
    this.nomeCompleto = nomeCompleto;
  }

  public String getNomeCompleto()
  {
    return this.nomeCompleto;
  }

  public void setEmailInstitucional(String emailInstitucional)
  {
    this.emailInstitucional = emailInstitucional;
  }

  public String getEmailInstitucional()
  {
    return this.emailInstitucional;
  }

  public void setProfissao(String profissao)
  {
    this.profissao = profissao;
  }

  public String getProfissao()
  {
    return profissao;
  }

  public int getNumeroMissoesRealizadas()
  {
    return this.numeroMissoesRealizadas;
  }

  public int getNumeroDescobertasRegistadas()
  {
    return this.numeroDescobertasRegistadas;
  }

  public void setNumeroMissoesRealizadas(int numeroMissoesRealizadas)
  {
    if (numeroMissoesRealizadas > 0)
      this.numeroMissoesRealizadas = numeroMissoesRealizadas;
  }

  public void setNumeroDescobertasRegistadas(int numeroDescobertasRegistadas)
  {
    if (numeroDescobertasRegistadas > 0)
      this.numeroDescobertasRegistadas = numeroDescobertasRegistadas;
  }
}
