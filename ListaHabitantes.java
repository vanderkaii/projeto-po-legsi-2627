import java.util.ArrayList;

public class ListaHabitantes
{
    private ArrayList<Habitante> habitantes;

    public ListaHabitantes()
    {
        habitantes = new ArrayList<Habitante>();
    }

    public ArrayList<Habitante> getHabitantes()
    {
      return this.habitantes;
    }

    public void adicionarHabitante(Habitante habitante)
    {
        if (habitante == null)
            throw new IllegalArgumentException("Habitante inválido.");

        if (habitantes.contains(habitante))
            throw new IllegalArgumentException("Este habitante já está registado na lista.");

        habitantes.add(habitante);
    }

    public void removerHabitante(Habitante habitante)
    {
        if (habitante == null || !habitantes.contains(habitante))
            throw new IllegalArgumentException("Este habitante não está registado na lista.");

        habitantes.remove(habitante);
    }

    public void verHabitantesSemColonia()
    {
      for (Habitante habitante : habitantes)
      {
        if (habitante.getColonia() == null)
        {
          System.out.println(habitante);
        }
      }
    }

    public void verHabitantesMortos()
    {
      for (Habitante habitante : habitantes)
      {
        if (!habitante.estaVivo())
          System.out.println(habitante);
      }
    }


}
