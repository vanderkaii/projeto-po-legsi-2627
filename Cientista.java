public class Cientista extends Habitante
{
  private String areaCientifica;

  public Cientista(String nomeCompleto, String emailInstitucional, String areaCientifica)
  {
    super(nomeCompleto, emailInstitucional);
    this.areaCientifica = areaCientifica;
  }
}