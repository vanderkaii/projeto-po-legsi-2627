
/*
1. Autenticar-se
2. Criar e gerir missões (adicionar/remover participantes)
3. Registar descobertas
4. Acompanhar o progresso e estado das missões
*/
public class GestorColonia extends Utilizador
{
  private String id;
  private final ListaMissoes listaMissoes;

  private static int contadorId = 1;

  public GestorColonia(String nome, String email, String password, ListaMissoes listaMissoes)
  {
    super(nome, email, password);
    if (listaMissoes == null)
      throw new IllegalArgumentException("Lista de missões inválida.");

    this.id = "G" + contadorId++;
    this.listaMissoes = listaMissoes;
  }

  public String getId()
  {
    return id;
  }

  private void verificarPermissao(Missao missao)
  {
    if (missao == null)
      throw new IllegalArgumentException("Missão inválida.");

    if (missao.getGestor() != this)
      throw new IllegalArgumentException("Não tem permissão para gerir esta missão.");
  }

  public void verMissoesSupervisionadas()
  {
    for (Missao missao : listaMissoes.getMissoes())
    {
      if (missao.getGestor() == this)
        System.out.println(missao);
    }
  }

  public void mudarObjetivo(String novoObjetivo, Missao missao)
  {
    verificarPermissao(missao);
    missao.setObjetivo(novoObjetivo);
  }

  public void mudarDesignacao(String novaDesignacao, Missao missao)
  {
    verificarPermissao(missao);
    missao.setDesignacao(novaDesignacao);
  }

  public void mudarColonia(Colonia novaColonia, Missao missao)
  {
    verificarPermissao(missao);
    if (novaColonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    missao.removerTodosParticipantes();
    missao.setColonia(novaColonia);
  }

  public void verParticipantes(Missao missao)
  {
    verificarPermissao(missao);
    missao.verParticipantes();
  }

  public void adicionarParticipante(Habitante habitante, Missao missao)
  {
    verificarPermissao(missao);
    missao.adicionarParticipante(habitante);
  }

  public void removerParticipante(Habitante habitante, Missao missao)
  {
    verificarPermissao(missao);
    missao.removerParticipante(habitante);
  }

  public void iniciarMissao(Missao missao)
  {
    verificarPermissao(missao);
    missao.iniciarMissao();
  }

  public void concluirMissao(Missao missao)
  {
    verificarPermissao(missao);
    missao.concluirMissao();
  }

  public void adicionarDescoberta(Descoberta descoberta, Missao missao)
  {
    verificarPermissao(missao);
    missao.adicionarDescoberta(descoberta);
  }

  public boolean procurarHabitanteNaMissao(Habitante habitante, Missao missao)
  {
    verificarPermissao(missao);
    return missao.procurarHabitanteNaMissao(habitante);
  }

  @Override
  public String toString()
  {
    return "GestorColonia{id='" + this.id + "', nome='" + getNome()
        + "', email='" + getEmail() + "'}";
  }
}
