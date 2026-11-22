public class Cientista extends Habitante
{
  private String areaCientifica;

  public Cientista(String nomeCompleto, String emailInstitucional, String profissao, String password,
      String areaCientifica)
  {
    super(nomeCompleto, emailInstitucional, profissao, password);
    this.areaCientifica = areaCientifica;
  }

  public void setAreaCientifica(String areaCientifica)
  {
    if (areaCientifica == null || areaCientifica.isEmpty())
    {
      throw new IllegalArgumentException("A área científica não pode estar vazia");
    }
    this.areaCientifica = areaCientifica;
  }

  public String getAreaCientifica()
  {
    return this.areaCientifica;
  }
}