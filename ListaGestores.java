import java.util.ArrayList;

public class ListaGestores
{
  private ArrayList<GestorColonia> gestores;

  public ArrayList<GestorColonia> getGestores()
  {
    return this.gestores;
  }

  public void adicionarGestor(GestorColonia gestor)
  {
    if (gestor == null)
      throw new IllegalArgumentException("Gestor inválido.");

    if (gestores.contains(gestor))
      throw new IllegalArgumentException("Este gestor já está registado na lista.");

    gestores.add(gestor);
  }

  public void removerGestores(GestorColonia gestor)
  {
    if (gestor == null || !gestores.contains(gestor))
      throw new IllegalArgumentException("Este gestor não está registado na lista.");

    gestores.remove(gestor);
  }


}
