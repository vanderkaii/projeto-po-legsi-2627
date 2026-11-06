public abstract class Habitante
{
  private String idHabitante;
  private String nomeCompleto;
  private String emailInstitucional;
  private String profissao;
  private int numeroMissoesRealizadas;
  private int numeroDescobertasRegistadas;
  private static int contadorIdHabitante = 1; // variavel que serve de contador para o numero do ID.
  // static significa que é uma variavel global para esta classe e todas as suas
  // filhas

  public Habitante(String nomeCompleto, String emailInstitucional)
  {
    this.nomeCompleto = nomeCompleto;
    this.emailInstitucional = emailInstitucional;
    setNumeroDescobertasRegistadas(0);
    setNumeroMissoesRealizadas(0);
    this.idHabitante = "H" + contadorIdHabitante;
    contadorIdHabitante++;
  }

  public String getIdHabitante()
  {
    return this.idHabitante;
  }

  public String getNomeCompleto()
  {
    return this.nomeCompleto;
  }

  public String getEmailInstitucional()
  {
    return this.emailInstitucional;
  }

  public String getProfissao()
  {
    return profissao;
  }

  public int getNumeroDescobertasRegistadas()
  {
    return this.numeroDescobertasRegistadas;
  }

  public int getNumeroMissoesRealizadas()
  {
    return this.numeroMissoesRealizadas;
  }

  public void setNomeCompleto(String nomeCompleto)
  {
    this.nomeCompleto = nomeCompleto;
  }

  public void setEmailInstitucional(String emailInstitucional)
  {
    this.emailInstitucional = emailInstitucional;
  }

  public void setProfissao(String profissao)
  {
    this.profissao = profissao;
  }

  public void setNumeroDescobertasRegistadas(int numeroDescobertasRegistadas)
  {
    if (numeroDescobertasRegistadas >= 0)
      this.numeroDescobertasRegistadas = numeroDescobertasRegistadas;
  }

  public void setNumeroMissoesRealizadas(int numeroMissoesRealizadas)
  {
    if (numeroMissoesRealizadas >= 0)
      this.numeroMissoesRealizadas = numeroMissoesRealizadas;
  }

}
