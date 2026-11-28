
import java.util.ArrayList;

public class ListaDescobertas
{
  private final ArrayList<Descoberta> descobertas;

  public ListaDescobertas()
  {
    this.descobertas = new ArrayList<>();
  }

  public ArrayList<Descoberta> getDescobertas()
  {
    return this.descobertas;
  }

  public void adicionarDescoberta(Descoberta descoberta)
  {
    if (descobertas == null)
      throw new IllegalArgumentException("Descoberta inválida.");

    if (descobertas.contains(descoberta))
      throw new IllegalArgumentException("Esta descoberta já está registada na lista.");
    
    descobertas.add(descoberta);
  }
  
  public void removerDescoberta(Descoberta descoberta)
  {
    if (descoberta == null || !descobertas.contains(descoberta))
      throw new IllegalArgumentException("Esta descoberta não está registada na lista");
      
    descobertas.remove(descoberta);
  }

  public void verDescobertas()
  {
    for (Descoberta descoberta : descobertas)
    {
      System.out.println(descoberta);
    }
  }

}
