public class Descoberta
{
  private String idDescoberta;
  private String idMissaoAssociada;
  private String idHabitanteResponsavel;
  private String tipoDescoberta;
  private String data;
  private String descricao;
  private static int contadorIdDescoberta = 1;

  public Descoberta(String idMissaoAssociada, String idHabitanteResponsavel, String tipoDescoberta, String descricao)
  {
    this.idDescoberta = "D" + contadorIdDescoberta;
    contadorIdDescoberta++;
    this.idMissaoAssociada = idMissaoAssociada;
    this.setTipoDescoberta(tipoDescoberta);
    this.setData(data);
    this.setDescricao(descricao);
  }

  public String getIdDescoberta()
  {
    return this.idDescoberta;
  }

  public String getIdMissaoAssociada()
  {
    return this.idMissaoAssociada;
  }

  public String getIdHabitanteResponsavel()
  {
    return this.idHabitanteResponsavel;
  }

  public String getTipoDescoberta()
  {
    return this.tipoDescoberta;
  }

  public String getData()
  {
    return this.data;
  }

  public String getDescricao()
  {
    return this.descricao;
  }

  public void setTipoDescoberta(String tipoDescoberta)
  {
    this.tipoDescoberta = tipoDescoberta;
  }

  public void setData(String data)
  {
    this.data = data;
  }

  public void setDescricao(String descricao)
  {
    this.descricao = descricao;
  }
}
