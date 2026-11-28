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
    if (listaColonias == null || listaMissoes == null || listaHabitantes == null || listaGestores == null)
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
    if (!listaHabitantes.getHabitantes().contains(habitante))
      listaHabitantes.adicionarHabitante(habitante);
  }

  public void removerHabitanteColonia(Colonia colonia, Habitante habitante)
  {
    if (colonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    colonia.removerHabitante(habitante, this.listaMissoes);
  }

  public void moverHabitanteColonia(Habitante habitante, Colonia novaColonia)
  {
    if (habitante == null)
      throw new IllegalArgumentException("Habitante inválido.");

    if (novaColonia == null)
      throw new IllegalArgumentException("Nova colónia inválida.");

    if (!listaHabitantes.getHabitantes().contains(habitante))
      throw new IllegalArgumentException("O habitante não está registado no sistema.");

    Colonia coloniaAtual = habitante.getColonia();
    if (coloniaAtual == null || !coloniaAtual.procurarHabitante(habitante))
      throw new IllegalArgumentException("O habitante não pertence a uma colónia.");

    if (coloniaAtual == novaColonia)
      throw new IllegalArgumentException("O habitante já pertence a esta colónia.");

    if (novaColonia.procurarHabitante(habitante))
      throw new IllegalArgumentException("O habitante já está registado na nova colónia.");

    if (listaMissoes.temMissaoPlaneadaOuEmCurso(habitante))
      throw new IllegalStateException("Não é possível mudar a colónia de um habitante numa missão planeada ou em curso.");

    coloniaAtual.removerHabitante(habitante, this.listaMissoes);
    novaColonia.adicionarHabitante(habitante);
  }

  public void removerHabitante(Habitante habitante)
  {
    if (habitante == null || !listaHabitantes.getHabitantes().contains(habitante))
      throw new IllegalArgumentException("O habitante não está registado no sistema.");

    if (listaMissoes.temMissaoPlaneadaOuEmCurso(habitante))
      throw new IllegalStateException("Não é possível remover um habitante numa missão planeada ou em curso.");

    Colonia colonia = habitante.getColonia();
    if (colonia != null)
    {
      if (!colonia.procurarHabitante(habitante))
        throw new IllegalStateException("A associação entre o habitante e a colónia está inconsistente.");

      colonia.removerHabitante(habitante, this.listaMissoes);
    }

    listaMissoes.removerReferenciasHabitante(habitante);
    listaHabitantes.removerHabitante(habitante);
  }

  public void adicionarGestor(GestorColonia gestor)
  {
    listaGestores.adicionarGestor(gestor);
  }

  public void removerGestor(GestorColonia gestor)
  {
    if (gestor == null)
      throw new IllegalArgumentException("Gestor inválido.");

    if (!listaGestores.getGestores().contains(gestor))
      throw new IllegalArgumentException("O gestor não está registado no sistema.");

    if (listaMissoes.temMissaoPlaneadaOuEmCurso(gestor))
      throw new IllegalStateException("Não é possível remover um gestor associado a uma missão planeada ou em curso.");

    listaMissoes.removerReferenciasGestor(gestor);
    listaGestores.removerGestor(gestor);
  }

    public void verMissoes()
  {
    listaMissoes.verMissoes();
  }
}
