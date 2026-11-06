public class Engenheiro extends Habitante
{
  private String especialidadeTecnica;

  public Engenheiro(String nomeCompleto, String emailInstitucional, String especialidadeTecnica)
  {
    super(nomeCompleto, emailInstitucional);
    setProfissao("Engenheiro");
    this.especialidadeTecnica = especialidadeTecnica;
  }

  public String getEspecialidadeTecnica()
  {
    return this.especialidadeTecnica;
  }

  public void setEspecialidadeTecnica(String especialidadeTecnica)
  {
    this.especialidadeTecnica = especialidadeTecnica;
  }
}