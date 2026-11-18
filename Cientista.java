public class Cientista extends Habitante
{
  private String areaCientifica;

  public Cientista(String nomeCompleto, String emailInstitucional, String areaCientifica, String profissao)
  {
    super(nomeCompleto, emailInstitucional, profissao);
    this.areaCientifica = areaCientifica;
  }
}