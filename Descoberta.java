import java.time.LocalDate;

public class Descoberta {

    private int id;
    private Missao missaoAssociada;
    private Habitante habitanteResponsavel;
    private String tipo;
    private LocalDate data; //ns oq é isto oops
    private String descricao;

    private static int contadorId = 1;

    public Descoberta(Missao missaoAssociada, Habitante habitanteResponsavel, String tipo, LocalDate data, String descricao) {

        if (missaoAssociada == null || habitanteResponsavel == null) {
            throw new IllegalArgumentException("Missão ou habitante inválidos.");
        }

        if (!missaoAssociada.getEquipaParticipante().contains(habitanteResponsavel)) {
            throw new IllegalArgumentException("O habitante não participa nesta missão.");
        }

        if (tipo == null || tipo.isBlank()|| descricao == null || descricao.isBlank() || data == null) {
            throw new IllegalArgumentException("Os dados da descoberta são inválidos.");
        }

        if (data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data da descoberta não pode ser futura.");
        }

        this.id = contadorId++;
        this.missaoAssociada = missaoAssociada;
        this.habitanteResponsavel = habitanteResponsavel;
        this.tipo = tipo;
        this.data = data;
        this.descricao = descricao;

        missaoAssociada.adicionarDescoberta(this);
    }

    public int getId() {
        return id;
    }

    public Missao getMissaoAssociada() {
        return missaoAssociada;
    }

    public Habitante getHabitanteResponsavel() {
        return habitanteResponsavel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
