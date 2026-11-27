import java.util.ArrayList;

public class Colonia
{
  private String id;
  private String nome;
  private String planeta;
  private ArrayList<Habitante> habitantes;

  private static int contadorId = 1;

  public Colonia(String nome, String planeta, ListaColonias listaColonias)
  {
    this.id = "C" + contadorId++;
    setNome(nome);
    setPlaneta(planeta);
    this.habitantes = new ArrayList<>();

    listaColonias.adicionarColonia(this);
  }

  public String getId()
  {
    return this.id;
  }

  public String getNome()
  {
    return this.nome;
  }

  public void setNome(String nome)
  {
    if (nome == null || nome.isEmpty())
    {
      throw new IllegalArgumentException("O nome da colónia não pode estar vazio");
    }

    this.nome = nome;
  }

  public String getPlaneta()
  {
    return this.planeta;
  }

  public void setPlaneta(String planeta)
  {
    if (planeta == null || planeta.isEmpty())
    {
      throw new IllegalArgumentException("O planeta não pode estar vazio");
    }
    this.planeta = planeta;
  }
  
  public ArrayList<Habitante> getHabitantes()
  {
    return this.habitantes;
  }
  
  public void verHabitantes()
  {
    for (Habitante habitante : habitantes)
    {
      System.out.println(habitante);
    }
  }

  public void adicionarHabitante(Habitante habitante)
  {
    if (habitante == null)
      throw new IllegalArgumentException("Habitante inválido.");

    if (this.habitantes.contains(habitante))
      throw new IllegalArgumentException("Este habitante já pertence à colónia.");
    
    if (habitante.getColonia() != null)
      System.out.println("Este habitante já pertence a uma colónia.");
    
    this.habitantes.add(habitante);
    habitante.setColonia(this);
  }

  public void removerHabitante(Habitante habitante)
  {
    if (habitante == null || !this.habitantes.contains(habitante))
    {
      throw new IllegalArgumentException("O habitante não existe nesta colónia");
    }

    this.habitantes.remove(habitante);
    habitante.setColonia(null);
  }

  public boolean procurarHabitante(Habitante habitante)
  {
    if (habitantes.contains(habitante))
      return true;

    return false;
  }


  @Override
  public String toString()
  {
    return "Colonia{id='" + this.id + "', nome='" + this.nome
        + "', planeta='" + this.planeta + "', habitantes=" + this.habitantes.size() + "}";
  }
}