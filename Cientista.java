public class Cientista extends Habitante
{
  private String areaCientifica;

  public Cientista(String nome, String email, String password, String areaCientifica)
  {
    super(nome, email, password);
    setProfissao("Cientista");
    setAreaCientifica(areaCientifica);
  }
  
  public String getAreaCientifica()
  {
    return this.areaCientifica;
  }

  public void setAreaCientifica(String areaCientifica)
  {
    if (areaCientifica == null || areaCientifica.isEmpty())
    {
      throw new IllegalArgumentException("A área científica não pode estar vazia");
    }
    this.areaCientifica = areaCientifica;
  }
}