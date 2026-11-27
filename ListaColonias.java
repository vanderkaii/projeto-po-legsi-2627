
import java.util.ArrayList;

public class ListaColonias
{
  private final ArrayList<Colonia> colonias;

  public ListaColonias()
  {
    this.colonias = new ArrayList<>();
  }

  public void adicionarColonia(Colonia colonia)
  {
    if (colonias.contains(colonia))
      throw new IllegalArgumentException("Esta colónia já está registada na lista.");
    
    colonias.add(colonia);
  }
  
  public void removerColonia(Colonia colonia)
  {
    if (!colonias.contains(colonia))
      throw new IllegalArgumentException("Esta colónia não está registada na lista");
      
    colonias.remove(colonia);
  }

  public void verColonias()
  {
    for (Colonia colonia : colonias)
    {
      System.out.println(colonia);
    }
  }

}
