import java.util.ArrayList;

public class Missao
{
  private String id;
  private String designacao;
  private String objetivo;
  private ArrayList<Habitante> equipaParticipante;
  private GestorColonia gestor;
  private Colonia colonia;
  private EstadoMissao estado; // Planeada, EmCurso ou Concluida
  private ArrayList<Descoberta> descoberta;

  private static int contadorIdMissao = 1;

  public enum EstadoMissao
  {
    Planeada, EmCurso, Concluida,
  }

  public Missao(String designacao, String objetivo, GestorColonia gestor, Colonia colonia, ListaMissoes listaMissoes)
  {
    this.id = "M" + contadorIdMissao++;
    setDesignacao(designacao);
    setObjetivo(objetivo);
    setColonia(colonia);
    this.equipaParticipante = new ArrayList<>();
    this.descoberta = new ArrayList<>();
    setGestor(gestor);
    this.estado = EstadoMissao.Planeada;

    listaMissoes.adicionarMissao(this);
  }

  // setters e getters
  public String getId()
  {
    return this.id;
  }

  public String getObjetivo()
  {
    return this.objetivo;
  }

  public EstadoMissao getEstado()
  {
    return this.estado;
  }

  public ArrayList<Habitante> getEquipaParticipante()
  {
    return this.equipaParticipante;
  } 

  public void setObjetivo(String objetivo)
  {
    this.objetivo = objetivo;
  }

  public String getDesignacao()
  {
    return this.designacao;
  }

  public void setDesignacao(String designacao)
  {
    this.designacao = designacao;
  }

  public Colonia getColonia()
  {
    return this.colonia;
  }

  public void setColonia(Colonia colonia)
  {
    this.colonia = colonia;
  }

  public GestorColonia getGestor()
  {
    return this.gestor;
  }

  public void setGestor(GestorColonia gestor)
  {
    this.gestor = gestor;
  }

  public void verParticipantes()
  {
    System.out.println("Equipa participante:");
    
    if (this.equipaParticipante.isEmpty())
    {
      System.out.println("Vazia.");
      return;
    }

    for (Habitante habitante : equipaParticipante)
    {
      System.out.println(habitante);
    }
  }

  public void adicionarParticipante(Habitante habitante)
  {
    // Verificações
    if (habitante == null)
      throw new IllegalArgumentException("Habitante inválido.");

    if (!this.colonia.procurarHabitante(habitante))
      throw new IllegalArgumentException("O habitante não pertence a esta colonia.");

    if (estado != EstadoMissao.Planeada)
      throw new IllegalStateException("Não é possivel alterar a equipa de uma missão em curso ou concluida.");

    if (equipaParticipante.contains(habitante))
      throw new IllegalArgumentException("O habitante já participa nesta missão.");

    equipaParticipante.add(habitante);
  }

  public void removerParticipante(Habitante habitante)
  {
    if (estado != EstadoMissao.Planeada)
    {
      throw new IllegalStateException("Não é possível alterar a equipa de uma missão em curso ou concluída.");
    }

    if (!equipaParticipante.contains(habitante))
    {
      throw new IllegalArgumentException("O habitante não participa nesta missão.");
    }

    equipaParticipante.remove(habitante);
  }

  public void removerTodosParticipantes()
  {
    if (estado != EstadoMissao.Planeada)
      throw new IllegalStateException("Não é possível alterar a equipa de uma missão em curso ou concluída.");

    equipaParticipante.clear();
  }

  public void iniciarMissao()
  {
    if (this.equipaParticipante.isEmpty())
      throw new IllegalArgumentException("A equipa desta missão está vazia.");

    if (this.estado == EstadoMissao.EmCurso)
      throw new IllegalArgumentException("Esta missão já está em curso.");

    if (this.estado == EstadoMissao.Concluida)
      throw new IllegalArgumentException("Esta missão já foi concluida.");

    this.estado = EstadoMissao.EmCurso;
  }

  public void concluirMissao()
  {
    if (this.estado == EstadoMissao.Planeada)
      throw new IllegalArgumentException("Esta missão ainda não foi iniciada.");

    this.estado = EstadoMissao.Concluida;
  }

  public void adicionarDescoberta(Descoberta descoberta)
  {
    if (descoberta == null)
    {
      throw new IllegalArgumentException("Descoberta inválida.");
    }

    if (estado != EstadoMissao.EmCurso)
    {
      throw new IllegalStateException("Só é possível registar descobertas de missões em curso.");
    }

    if (!this.descoberta.contains(descoberta))
    {
      this.descoberta.add(descoberta);
    }
  }

  public boolean procurarHabitanteNaMissao(Habitante habitante)
  {
    if (this.equipaParticipante.contains(habitante))
      return true;

    return false;
  }

  @Override
  public String toString()
  {
    return "Missao{id='" + this.id + "', designacao='" + this.designacao
        + "', objetivo='" + this.objetivo + "', estado=" + this.estado
        + ", participantes=" + this.equipaParticipante.size()
        + ", descobertas=" + this.descoberta.size() + "}";
  }
}