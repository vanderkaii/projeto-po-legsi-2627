import java.util.ArrayList;

public class ListaMissoes
{
  private final ArrayList<Missao> missoes;

  public ListaMissoes()
  {
    this.missoes = new ArrayList<>();
  }

  public ArrayList<Missao> getMissoes()
  {
    return this.missoes;
  }

  public void adicionarMissao(Missao missao)
  {
    if (missao == null)
      throw new IllegalArgumentException("Missão inválida.");

    if (missoes.contains(missao))
      throw new IllegalArgumentException("Esta missão já está registada na lista.");
    
    missoes.add(missao);
  }
  
  public void removerMissao(Missao missao)
  {
    if (missao == null || !missoes.contains(missao))
      throw new IllegalArgumentException("Esta missão não está registada na lista.");
      
    missoes.remove(missao);
  }

  public void verMissoes()
  {
    for (Missao missao : missoes)
    {
      System.out.println(missao);
    }
  }

  public void verMissoesPlaneadas()
  {
    for (Missao missao : missoes)
    {
      if (missao.getEstado() == Missao.EstadoMissao.Planeada)
        System.out.println(missao);
    }
  }

  public void verMissoesEmCurso()
  {
    for (Missao missao : missoes)
    {
      if (missao.getEstado() == Missao.EstadoMissao.EmCurso)
        System.out.println(missao);
    }
  }

  public void verMissoesConcluidas()
  {
    for (Missao missao : missoes)
    {
      if (missao.getEstado() == Missao.EstadoMissao.Concluida)
        System.out.println(missao);
    }
  }

}
