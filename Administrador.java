public class Administrador extends Utilizador
{
  private String id;
  private final ListaColonias listaColonias;
  private final ListaMissoes listaMissoes;

  private static int contadorId = 1;

  public Administrador(String nomeCompleto, String emailInstitucional, String password, ListaColonias listaColonias, ListaMissoes listaMissoes)
  {
    super(nomeCompleto, emailInstitucional, password);
    this.id = "A" + contadorId++;
    this.listaColonias = listaColonias;
    this.listaMissoes = listaMissoes;
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
    colonia.setNome(novoNome);
  }

  public void verHabitantesColonia(Colonia colonia)
  {
    colonia.verHabitantes();
  }

  public boolean procurarHabitanteColonia(Colonia colonia, Habitante habitante)
  {
    return colonia.procurarHabitante(habitante);
  }

  public void adicionarHabitanteColonia(Colonia colonia, Habitante habitante)
  {
    colonia.adicionarHabitante(habitante);
  }

  public void removerHabitanteColonia(Colonia colonia, Habitante habitante)
  {
    colonia.removerHabitante(habitante);
  }

  public void verMissoes()
  {
    listaMissoes.verMissoes();
  }

}
