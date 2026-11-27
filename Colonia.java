import java.util.ArrayList;

public class Colonia
{
  private String id;
  private String nome;
  private String planeta;
  private final ArrayList<Habitante> habitantes;

  private static int contadorId = 1;

  public Colonia(String nome, String planeta, ListaColonias listaColonias)
  {
    if (listaColonias == null)
      throw new IllegalArgumentException("Lista de colónias inválida.");

    setNome(nome);
    setPlaneta(planeta);
    this.habitantes = new ArrayList<>();
    this.id = "C" + contadorId++;
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
    if (nome == null || nome.isBlank())
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
    if (planeta == null || planeta.isBlank())
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
      throw new IllegalArgumentException("Este habitante já pertence a uma colónia.");
    
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
    return habitantes.contains(habitante);
  }


  @Override
  public String toString()
  {
    return "Colonia{id='" + this.id + "', nome='" + this.nome
        + "', planeta='" + this.planeta + "', habitantes=" + this.habitantes.size() + "}";
  }
}