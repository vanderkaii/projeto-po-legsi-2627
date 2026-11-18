public class Missao{
    private int idM;
    private String designacao;
    private String objetivo;
    //equipa participante
    //Gestor responsavel 
    //Pfv n mexam nisto :)
    private EstadoMissao estado; //planeada, em curso ou concluida

    public Missao(String designacao, String objetivo,){
        this.designacao=designacao;
        this.objetivo=objetivo;
        
    }
}