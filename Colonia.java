public class Colonia
{
  private int idColonia;
  private String nomeColonia;
  private String planeta;
  private Habitante[] listaHabitantes = new Habitante[10];
  private int numMissoesConcluidas;
  private static int contadorIdColonia = 1;
  private int numHabitantes;

  public Colonia(String nomeColonia, String planeta)
  {
    this.nomeColonia = nomeColonia;
    this.planeta = planeta;
    this.idColonia = contadorIdColonia;
    contadorIdColonia++;
    this.numHabitantes = 0;
  }

  public int getIdColonia()
  {
    return this.idColonia;
  }

  public String getNomeColonia()
  {
    return this.nomeColonia;
  }

  public String getPlaneta()
  {
    return this.planeta;
  }

  public int getNumMissoesConcluidas()
  {
    return this.numMissoesConcluidas;
  }

  public int getNumHabitantes()
  {
    return this.numHabitantes;
  }

  public void setNomeColonia(String nomeColonia)
  {
    this.nomeColonia = nomeColonia;
  }

  public void setNumMissoesConcluidas(int numMissoesConcluidas)
  {
    if (numMissoesConcluidas >= 0)
      this.numMissoesConcluidas = numMissoesConcluidas;
  }

  public String listarHabitantes()
  {

    if (this.numHabitantes == 0)
    {
      return "A colónia não tem habitantes.";
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < numHabitantes; i++)
    {
      Habitante habitante = listaHabitantes[i];
      sb.append("ID: ").append(habitante.getIdHabitante()).append(" | Nome: ").append(habitante.getNomeCompleto())
          .append(" | Profissão: ").append(habitante.getProfissao()).append("\n");
    }

    return sb.toString();
  }

  public void adicionarHabitante(Habitante habitante)
  {
    this.listaHabitantes[numHabitantes] = habitante;
    numHabitantes++;
  }

  public void removerHabitante(Habitante id)
  {
    // Possivel metodo para remover habitante. Não me apetece fazer agora
  }
}
