public abstract class Habitante extends Utilizador
{
  private String id;
  private String profissao;
  private Colonia colonia;

  private static int contadorId = 1; // Variável que serve de contador para o número do ID.
                                     // static significa que é uma variável partilhada
                                     // por esta classe e todas as suas instâncias.

  public Habitante(String nomeCompleto, String emailInstitucional, String password)
  {
    super(nomeCompleto, emailInstitucional, password);
    this.id = "H" + contadorId++;
  }

  public String getId()
  {
    return this.id;
  }

  public String getProfissao()
  {
    return this.profissao;
  }

  public void setProfissao(String profissao)
  {
    /*
     * if (profissao == null || profissao.isEmpty()) { throw new
     * IllegalArgumentException("Profissão inválida"); }
     */
    this.profissao = profissao;
  }

  public Colonia getColonia()
  {
    return this.colonia;
  }

  public void setColonia(Colonia colonia)
  {
    this.colonia = colonia;
  }

  @Override
  public String toString()
  {
    // É um operador ternario. é uma forma mais compacta do if... else.
    // Neste caso, se colonia for null, mostra "nenhuma". Se não, mostra
    // colonia.getNome()
    String nomeColonia = this.colonia == null ? "nenhuma" : this.colonia.getNome();

    return "Habitante{id='" + this.id + "', nome='" + getNome() + "', email='" + getEmail() + "', profissao='"
        + this.profissao + "', colonia='" + nomeColonia + "'}";
  }

  public void verTodasMissoes(ListaMissoes missoes)
  {
    for (Missao missao : missoes.getMissoes())
    {
      if (missao.getEquipaParticipante().contains(this))
      {
        System.out.println(missao);
      }
    }
  }

  public void verMissoesPorEstado(ListaMissoes missoes, Missao.EstadoMissao estado)
  {
    for (Missao missao : missoes.getMissoes())
    {
      if (missao.getEquipaParticipante().contains(this) && missao.getEstado() == estado)
      {
        System.out.println(missao);
      }
    }
  }

  public void verDescobertas(ListaDescobertas descobertas)
  {
    for (Descoberta descoberta : descobertas.getDescobertas())
    {
      if (descoberta.getHabitanteResponsavel() == this)
        System.out.println(descoberta);
    }
  }

  /*
   * ESTATISTICAS PESSOAIS: Descobertas realizadas, missoes concluidas
   */
  public void verEstatisticas(ListaDescobertas descobertas, ListaMissoes missoes)
  {
    int missoesConcluidas = 0;
    int descobertasRealizadas = 0;

    for (Missao missao : missoes.getMissoes())
    {
      if (missao.getEquipaParticipante().contains(this) && missao.getEstado() == Missao.EstadoMissao.Concluida)
      {
        missoesConcluidas++;
      }
    }

    for (Descoberta descoberta : descobertas.getDescobertas())
    {
      if (descoberta.getHabitanteResponsavel() == this)
        descobertasRealizadas++;
    }

    String.format("Missoes concluidas: %d", missoesConcluidas);
    String.format("Descobertas realizadas: %d", descobertasRealizadas);
  }
}
