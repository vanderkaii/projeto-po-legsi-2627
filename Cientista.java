public class Cientista extends Habitante
{
  private String areaCientifica;

  public Cientista(String nomeCompleto, String emailInstitucional, String areaCientifica)
  {
    super(nomeCompleto, emailInstitucional);
    setProfissao("Cientista");
    this.areaCientifica = areaCientifica;
  }

  public String getAreaCientifica()
  {
    return this.areaCientifica;
  }

  public void setAreaCientifica(String areaCientifica)
  {
    this.areaCientifica = areaCientifica;
  }
}