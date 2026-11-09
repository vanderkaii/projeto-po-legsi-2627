public class Engenheiro extends Habitante
{
  private String especialidadeTecnica;

  public Engenheiro(String nomeCompleto, String emailInstitucional, String profissao, String especialidadeTecnica)
  {
    super(nomeCompleto, emailInstitucional, profissao);
    this.especialidadeTecnica = especialidadeTecnica;
  }
}