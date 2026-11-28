import java.time.LocalDate;

public class Descoberta
{
  private String id;
  private Missao missaoAssociada;
  private Habitante habitanteResponsavel;
  private String tipo;
  private LocalDate data; // ns oq é isto oops
  private String descricao;

  private static int contadorId = 1;

  // Removi a data dos parametros do constructor. A data da descoberta passa a ser a data atual que é obtida com o LocalDate
  public Descoberta(Missao missaoAssociada, Habitante habitanteResponsavel, String tipo, LocalDate data,
      String descricao)
  {
    if (missaoAssociada == null || habitanteResponsavel == null)
      throw new IllegalArgumentException("Missão ou habitante inválidos.");

    if (!missaoAssociada.procurarHabitanteNaMissao(habitanteResponsavel))
      throw new IllegalArgumentException("O habitante não participa nesta missão.");

    if (tipo == null || tipo.isBlank() || descricao == null || descricao.isBlank() || data == null)
      throw new IllegalArgumentException("Os dados da descoberta são inválidos.");

    if (data.isAfter(LocalDate.now()))
      throw new IllegalArgumentException("A data da descoberta não pode ser futura.");

    this.id = "D" + contadorId++;
    this.missaoAssociada = missaoAssociada;
    this.habitanteResponsavel = habitanteResponsavel;
    setTipo(tipo);
    this.data = LocalDate.now();
    setDescricao(descricao);

    missaoAssociada.adicionarDescoberta(this);
  }

  public String getId()
  {
    return id;
  }

  public Missao getMissaoAssociada()
  {
    return missaoAssociada;
  }

  public Habitante getHabitanteResponsavel()
  {
    return habitanteResponsavel;
  }

  public void removerHabitanteResponsavel(Habitante habitante)
  {
    if (this.habitanteResponsavel == habitante)
      this.habitanteResponsavel = null;
  }

  public String getTipo()
  {
    return tipo;
  }

  public void setTipo(String tipo)
  {
    if (tipo == null || tipo.isBlank())
      throw new IllegalArgumentException("O tipo da descoberta não pode estar vazio.");

    this.tipo = tipo;
  }

  public LocalDate getData()
  {
    return data;
  }

  public String getDescricao()
  {
    return descricao;
  }

  public void setDescricao(String descricao)
  {
    if (descricao == null || descricao.isBlank())
      throw new IllegalArgumentException("A descrição da descoberta não pode estar vazia.");

    this.descricao = descricao;
  }

}
