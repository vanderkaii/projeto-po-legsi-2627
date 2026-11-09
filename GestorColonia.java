public class GestorColonia extends Habitante
{
  private int numMissoesSuperv;

  public GestorColonia(String nomeCompleto, String emailInstitucional, String profissao)
  {
    super(nomeCompleto, emailInstitucional, profissao);
    this.numMissoesSuperv = 0;
  }
}
