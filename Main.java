import java.time.LocalDate;

public class Main
{
  public static void main(String[] args)
  {
    ListaMissoes listaMissoes = new ListaMissoes();
    GestorColonia gestorMarte = new GestorColonia("Ana Gestora", "ana@exemplo.pt", "senha1", listaMissoes);
    GestorColonia gestorEuropa = new GestorColonia("Bruno Gestor", "bruno@exemplo.pt", "senha2", listaMissoes);
    System.out.println("Gestores: " + gestorMarte.getNome() + " (" + gestorMarte.getId() + "), "
        + gestorEuropa.getNome() + " (" + gestorEuropa.getId() + ")");
    System.out.println("Autenticacao: " + gestorMarte.autenticar("senha1"));
    gestorMarte.setNome("Ana Silva");
    gestorMarte.setEmail("ana.silva@exemplo.pt");
    gestorMarte.setPassword("novaSenha");
    System.out.println("Dados atualizados: " + gestorMarte.getNome() + ", " + gestorMarte.getEmail() + ", autenticacao="
        + gestorMarte.autenticar("novaSenha"));

    ListaColonias listaColonias = new ListaColonias();
    Administrador administrador = new Administrador();
    Colonia marte = administrador.criarColonia("Ares", "Marte");
    Colonia europa = administrador.criarColonia("Europa", "Jupiter");
    administrador.renomearColonia(marte, "Nova Ares");
    System.out.println("\nColonias:");
    System.out.println(marte.getId() + " - " + marte.getNome() + ", planeta " + marte.getPlaneta());
    System.out.println(europa.getId() + " - " + europa.getNome() + ", planeta " + europa.getPlaneta());

    Explorador explorador1 = new Explorador("Carlos", "carlos@exemplo.pt", "senha3");
    Explorador explorador2 = new Explorador("Diana", "diana@exemplo.pt", "senha4");
    Cientista cientista = new Cientista("Eva", "eva@exemplo.pt", "senha5", "Biologia");
    Engenheiro engenheiro = new Engenheiro("Fabio", "fabio@exemplo.pt", "senha6", "Robotica");
    cientista.setAreaCientifica("Astrobiologia");
    engenheiro.setEspecialidadeTecnica("Sistemas");

    administrador.adicionarHabitanteColonia(marte, explorador1);
    administrador.adicionarHabitanteColonia(marte, cientista);
    administrador.adicionarHabitanteColonia(marte, engenheiro);
    administrador.adicionarHabitanteColonia(europa, explorador2);
    System.out.println("\nHabitantes de " + marte.getNome() + ":");
    for (Habitante habitante : marte.getHabitantes())
      System.out.println(habitante.getId() + " - " + habitante.getNome() + " (" + habitante.getProfissao() + ")");
    System.out.println("Eva pertence a Marte: " + marte.procurarHabitante(cientista));
    System.out.println("Diana pertence a Marte: " + marte.procurarHabitante(explorador2));
    System.out.println("Colonia do Carlos: " + explorador1.getColonia().getNome());
    System.out.println("Area da cientista: " + cientista.getAreaCientifica());
    System.out.println("Especialidade do engenheiro: " + engenheiro.getEspecialidadeTecnica());

    Missao missaoA = new Missao("Exploracao de Marte", "Recolher amostras", gestorMarte, marte, listaMissoes);
    Missao missaoB = new Missao("Analise do solo", "Analisar o solo", gestorMarte, marte, listaMissoes);
    Missao missaoC = new Missao("Exploracao de Europa", "Procurar sinais de vida", gestorEuropa, europa, listaMissoes);
    gestorMarte.mudarDesignacao("Exploracao de Ares", missaoA);
    gestorMarte.mudarObjetivo("Recolher amostras de solo", missaoA);
    System.out.println("\nMissoes supervisionadas por " + gestorMarte.getNome() + ":");
    gestorMarte.verMissoesSupervisionadas();

    gestorMarte.adicionarParticipante(explorador1, missaoA);
    gestorMarte.adicionarParticipante(cientista, missaoA);
    gestorMarte.adicionarParticipante(engenheiro, missaoA);
    System.out.println("\nCientista participa na missao: " + gestorMarte.procurarHabitanteEmMissao(cientista, missaoA));
    gestorMarte.removerParticipante(engenheiro, missaoA);
    gestorMarte.adicionarParticipante(engenheiro, missaoA);
    System.out.println(
        "Missao: " + missaoA.getId() + " - " + missaoA.getDesignacao() + "; objetivo: " + missaoA.getObjetivo());

    gestorMarte.iniciarMissao(missaoA);
    Descoberta descobertaA = new Descoberta(missaoA, cientista, "Mineral", LocalDate.now(), "Mineral identificado");
    System.out.println("\nDescoberta: " + descobertaA.getId() + ", " + descobertaA.getTipo() + ", "
        + descobertaA.getData() + ", " + descobertaA.getDescricao());
    System.out.println("Associada a " + descobertaA.getMissaoAssociada().getDesignacao() + " e responsavel: "
        + descobertaA.getHabitanteResponsavel().getNome());
    System.out.println(missaoA);
    gestorMarte.concluirMissao(missaoA);
    System.out.println("Estado depois de concluir: " + missaoA);

    gestorMarte.adicionarParticipante(explorador1, missaoB);
    gestorMarte.iniciarMissao(missaoB);
    Descoberta descobertaB = new Descoberta(missaoB, explorador1, "Imagem", LocalDate.now(),
        "Imagem de uma formacao rochosa");
    System.out.println("Segunda descoberta: " + descobertaB.getTipo() + " - " + descobertaB.getDescricao());
    gestorMarte.concluirMissao(missaoB);

    gestorEuropa.adicionarParticipante(explorador2, missaoC);
    gestorEuropa.iniciarMissao(missaoC);
    gestorEuropa.concluirMissao(missaoC);
    gestorEuropa.verMissoesSupervisionadas();

    listaMissoes.removerMissao(missaoB);
    System.out.println("Missoes restantes supervisionadas por " + gestorMarte.getNome() + ":");
    gestorMarte.verMissoesSupervisionadas();

    try
    {
      administrador.removerHabitanteColonia(marte, explorador1);
      System.out.println("Habitante removido da colonia: " + !marte.procurarHabitante(explorador1));
    } catch (RuntimeException erro)
    {
      System.out.println("Erro ao remover habitante da colonia: " + erro.getMessage());
    }
  }
}
