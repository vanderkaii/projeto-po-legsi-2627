
/*
1. Autenticar-se
2. Criar e gerir missões (adicionar/remover participantes)
3. Registar descobertas
4. Acompanhar o progresso e estado das missões
*/
import java.util.ArrayList;

public class GestorColonia extends Utilizador
{
  private String id;
  private ArrayList<Missao> missoesSupervisionadas;

  private static int contadorId = 1;

  public GestorColonia(String nome, String email, String password)
  {
    this.id = "G" + contadorId++;
    super(nome, email, password);
    this.missoesSupervisionadas = new ArrayList<>();
  }

  public String getId()
  {
    return id;
  }

  public ArrayList<Missao> getMissoesSupervisionadas()
  {
    return new ArrayList<>(missoesSupervisionadas);
  }

  public int getNumeroMissoesSupervisionadas()
  {
    return missoesSupervisionadas.size();
  }

  public void adicionarMissaoSuperV(Missao missao)
  {
    if (missao == null)
      throw new IllegalArgumentException("Missão inválida.");

    if (!missoesSupervisionadas.contains(missao))
      missoesSupervisionadas.add(missao);
  }

  public void removerMissaoSuperV(Missao missao)
  {
    missoesSupervisionadas.remove(missao);
  }

  public void verMissoesSupervisionadas()
  {
    for (Missao missao : getMissoesSupervisionadas())
      System.out.println(missao);
  }
}
