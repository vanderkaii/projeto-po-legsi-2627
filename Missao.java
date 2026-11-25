import java.util.ArrayList;

public class Missao
{
  private int idM;
  private String designacao;
  private String objetivo;
  private ArrayList<Habitante> equipaParticipante;
  private GestorColonia gestor;
  private Colonia colonia;
  private EstadoMissao estado; // planeada, em curso ou concluida
  private ArrayList<Descoberta> descoberta;

  private static int contadorIdMissao = 1;

<<<<<<< HEAD
  public enum EstadoMissao
  {
    PLANEADA, EM_CURSO, CONCLUIDA
  }
=======
    public enum EstadoMissao {
        Planeada,
        EmCurso,
        Concluida,
    }
    public Missao(String designacao, String objetivo,GestorColonia gestor,Colonia colonia){
        this.idM=contadorIdMissao++;
        this.designacao=designacao;
        this.objetivo=objetivo;
        this.colonia=colonia;
        this.equipaParticipante=new ArrayList<>();
        this.descoberta=new ArrayList<>();
        this.gestor=gestor;
        this.estado=EstadoMissao.Planeada;
    }
>>>>>>> origin/clara

  public Missao(String designacao, String objetivo, GestorColonia gestor, Colonia colonia)
  {
    this.id = contadorIdMissao++;
    this.designacao = designacao;
    this.objetivo = objetivo;
    this.colonia = colonia;
    this.equipaParticipante = new ArrayList<>();
    this.descoberta = new ArrayList<>();
    this.gestor = gestor;
    this.estado = EstadoMissao.PLANEADA;
  }

  // setters e getters
  public int getId()
  {
    return idM;
  }

  public String getObjetivo()
  {
    return objetivo;
  }

  public void setObjetivo(String objetivo)
  {
    this.objetivo = objetivo;
  }

  public String getDesignacao()
  {
    return designacao;
  }

  public void setDesignacao(String designacao)
  {
    this.designacao = designacao;
  }

  public Colonia getColonia()
  {
    return colonia;
  }

  public void setColonia(Colonia colonia)
  {
    this.colonia = colonia;
  }

  public GestorColonia getGestor()
  {
    return gestor;
  }

  public void setGestor(GestorColonia gestor)
  {
    this.gestor = gestor;
  }

  public void adicionarParticipante(Habitante habitante){
        //Verificações
        if(habitante==null){
            throw new IllegalArgumentException("Habitante inválido.");
        }

        if(!colonia.getHabitante().contains(habitante)){
            throw new IllegalArgumentException("O habitante não pertence a esta colonia.");
        }

        if(estado != EstadoMissao.Planeada){
            throw new IllegalStateException("Não é possivel alterar a equipa de uma missão em curso ou concluida.");
        } 

        if(equipaParticipante.contains(habitante)){
            throw new IllegalArgumentException("O habitante já participa nesta missa");
        }

        equipaParticipante.add(habitante);
    }

  public void removerParticipante(Habitante habitante)
  {

<<<<<<< HEAD
    if (estado != EstadoMissao.PLANEADA)
    {
      throw new IllegalStateException("Não é possível alterar a equipa de uma missão em curso ou concluída.");
    }

    if (!equipaParticipante.contains(habitante))
    {
      throw new IllegalArgumentException("O habitante não participa nesta missão.");
=======
        if (estado != EstadoMissao.Planeada) {
            throw new IllegalStateException("Não é possível alterar a equipa de uma missão em curso ou concluída.");
        }

        if (!equipaParticipante.contains(habitante)) {
            throw new IllegalArgumentException("O habitante não participa nesta missão.");
        }

        equipaParticipante.remove(habitante);
    }

    public void alterarEstado(EstadoMissao novoEstado) {

        if (novoEstado == null) {
            throw new IllegalArgumentException("Estado inválido.");
        }

        if (estado == EstadoMissao.Planeada && novoEstado == EstadoMissao.EmCurso) {

            if (equipaParticipante.isEmpty()) {
                throw new IllegalStateException("A missão necessita de participantes.");
            }

            estado = novoEstado;

        } else if (estado == EstadoMissao.EmCurso && novoEstado == EstadoMissao.Concluida) {

            estado = novoEstado;

        } else {
            throw new IllegalStateException("Transição de estado inválida.");
        }
>>>>>>> origin/clara
    }

    equipaParticipante.remove(habitante);
  }

  public void alterarEstado(EstadoMissao novoEstado)
  {

<<<<<<< HEAD
    if (novoEstado == null)
    {
      throw new IllegalArgumentException("Estado inválido.");
=======
        if (estado != EstadoMissao.EmCurso) {
            throw new IllegalStateException("Só é possível registar descobertas em missões em curso.");
        }

        if (!descoberta.contains(descoberta)) {
            descoberta.add(descoberta);
        }
>>>>>>> origin/clara
    }

    if (estado == EstadoMissao.PLANEADA && novoEstado == EstadoMissao.EM_CURSO)
    {

      if (equipaParticipante.isEmpty())
      {
        throw new IllegalStateException("A missão necessita de participantes.");
      }

      estado = novoEstado;

    } else if (estado == EstadoMissao.EM_CURSO && novoEstado == EstadoMissao.CONCLUIDA)
    {

      estado = novoEstado;

    } else
    {
      throw new IllegalStateException("Transição de estado inválida.");
    }
  }

  public void adicionarDescoberta(Descoberta descoberta)
  {

    if (descoberta == null)
    {
      throw new IllegalArgumentException("Descoberta inválida.");
    }

    if (estado != EstadoMissao.EM_CURSO)
    {
      throw new IllegalStateException("Só é possível registar descobertas em missões em curso.");
    }

    if (!descobertas.contains(descoberta))
    {
      descobertas.add(descoberta);
    }
  }
}