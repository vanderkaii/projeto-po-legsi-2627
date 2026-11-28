public class Administrador extends Utilizador
{
  private String id;
  private final ListaColonias listaColonias;
  private final ListaMissoes listaMissoes;
  private final ListaHabitantes listaHabitantes;
  private final ListaGestores listaGestores;

  private static int contadorId = 1;

  public Administrador(String nomeCompleto, String emailInstitucional, String password, ListaColonias listaColonias, ListaMissoes listaMissoes, ListaHabitantes listaHabitantes, ListaGestores listaGestores)
  {
    super(nomeCompleto, emailInstitucional, password);
    if (listaColonias == null || listaMissoes == null)
      throw new IllegalArgumentException("As listas de gestão são inválidas.");

    this.id = "A" + contadorId++;
    this.listaColonias = listaColonias;
    this.listaMissoes = listaMissoes;
    this.listaHabitantes = listaHabitantes;
    this.listaGestores = listaGestores;
  }

  public void verColonias()
  {
    listaColonias.verColonias();
  }

  public Colonia criarColonia(String nome, String planeta)
  {
    return new Colonia(nome, planeta, this.listaColonias);
  }

  public void renomearColonia(Colonia colonia, String novoNome)
  {
    if (colonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    colonia.setNome(novoNome);
  }

  public void verHabitantesColonia(Colonia colonia)
  {
    if (colonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    colonia.verHabitantes();
  }

  public boolean procurarHabitanteColonia(Colonia colonia, Habitante habitante)
  {
    if (colonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    return colonia.procurarHabitante(habitante);
  }

  public void adicionarHabitanteColonia(Colonia colonia, Habitante habitante)
  {
    if (colonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    colonia.adicionarHabitante(habitante);
  }

  public void removerHabitanteColonia(Colonia colonia, Habitante habitante)
  {
    if (colonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    colonia.removerHabitante(habitante, this.listaMissoes);
  }

  public void matarHabitante(Habitante habitante)
  {
    if (habitante == null)
      throw new IllegalArgumentException("Habitante inválido.");

    habitante.marcarComoMorto();
  }

  public void matarGestor(GestorColonia gestor)
  {
    if (gestor == null)
      throw new IllegalArgumentException("Gestor inválido.");

    if (listaMissoes.temMissaoPlaneadaOuEmCurso(gestor))
      throw new IllegalStateException("Não é possível matar um gestor que gere uma missão planeada ou em curso.");

    gestor.marcarComoMorto();
  }

    public void verMissoes()
  {
    listaMissoes.verMissoes();
  }
}
