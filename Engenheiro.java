public class Engenheiro extends Habitante {

    private String especialidadeTecnica;

    public Engenheiro(String nomeCompleto, String emailInstitucional, String profissao, String password, String especialidadeTecnica) {

        super(nomeCompleto, emailInstitucional, profissao, password);
        this.especialidadeTecnica = especialidadeTecnica;
    }

    public void setEspecialidadeTecnica(String especialidadeTecnica) {
        if (especialidadeTecnica == null || especialidadeTecnica.isEmpty()) {
            throw new IllegalArgumentException("A especialidade técnica é inválida");
        }
        this.especialidadeTecnica = especialidadeTecnica;
    }
    public String getEspecialidadeTecnica() {
        return this.especialidadeTecnica;
    }
}

