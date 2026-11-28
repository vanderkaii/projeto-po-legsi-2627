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
    if (listaMissoes == null)
      throw new IllegalArgumentException("Lista de missões inválida.");

    setDesignacao(designacao);
    setObjetivo(objetivo);
    setColonia(colonia);
    this.equipaParticipante = new ArrayList<>();
    this.descoberta = new ArrayList<>();
    setGestor(gestor);
    this.estado = EstadoMissao.Planeada;

    this.id = "M" + contadorIdMissao++;
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
    if (objetivo == null || objetivo.isBlank())
      throw new IllegalArgumentException("O objetivo da missão não pode estar vazio.");

    this.objetivo = objetivo;
  }

  public String getDesignacao()
  {
    return this.designacao;
  }

  public void setDesignacao(String designacao)
  {
    if (designacao == null || designacao.isBlank())
      throw new IllegalArgumentException("A designação da missão não pode estar vazia.");

    this.designacao = designacao;
  }

  public Colonia getColonia()
  {
    return this.colonia;
  }

  public void setColonia(Colonia colonia)
  {
    if (colonia == null)
      throw new IllegalArgumentException("Colónia inválida.");

    if (this.colonia != null && this.colonia != colonia && !this.equipaParticipante.isEmpty())
      throw new IllegalStateException("Remova os participantes antes de mudar a colónia.");

    this.colonia = colonia;
  }

  public GestorColonia getGestor()
  {
    return this.gestor;
  }

  public void setGestor(GestorColonia gestor)
  {
    if (gestor == null)
      throw new IllegalArgumentException("Gestor inválido.");

    if (!gestor.estaVivo())
      throw new IllegalArgumentException("Um gestor morto não pode ser associado a uma missão.");

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

    if (!habitante.estaVivo())
      throw new IllegalArgumentException("Um habitante morto não pode participar numa missão.");

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

    if (habitante == null || !equipaParticipante.contains(habitante))
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

    for (Habitante habitante : this.equipaParticipante)
    {
      if (!habitante.estaVivo())
        throw new IllegalStateException("Remova os habitantes mortos da equipa antes de iniciar a missão.");
    }

    this.estado = EstadoMissao.EmCurso;
  }

  public void concluirMissao()
  {
    if (this.estado != EstadoMissao.EmCurso)
      throw new IllegalStateException("Só é possível concluir uma missão em curso.");

    this.estado = EstadoMissao.Concluida;
  }

  public void adicionarDescoberta(Descoberta descoberta)
  {
    if (descoberta == null)
    {
      throw new IllegalArgumentException("Descoberta inválida.");
    }

    if (descoberta.getMissaoAssociada() != this)
      throw new IllegalArgumentException("A descoberta não pertence a esta missão.");

    Habitante responsavel = descoberta.getHabitanteResponsavel();
    if (!responsavel.estaVivo())
      throw new IllegalStateException("Um habitante morto não pode registar uma descoberta.");

    if (!this.equipaParticipante.contains(responsavel))
      throw new IllegalArgumentException("O habitante responsável não participa nesta missão.");

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