/*
1. Autenticar-se
2. Criar e gerir missões (adicionar/remover participantes)
3. Registar descobertas
4. Acompanhar o progresso e estado das missões
*/
import java.util.ArrayList;
import java.util.Collections;

public class GestorColonia extends Utilizador{

    private int id;
    private String nome;
    private String email;
    private ArrayList<Missao> missoesSupervisionadas;

    private static int contadorId = 1;

    public GestorColonia(String nome, String email) { //meter super de utilizador
        this.id = contadorId++;
        this.nome = nome;
        this.email = email;
        this.missoesSupervisionadas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (emailInstitucional == null || emailInstitucional.isEmpty() || !emailInstitucional.contains("@") || !emailInstitucional.contains(".")){           
            throw new IllegalArgumentException("Email inválido");  
        }
        this.email = email;
    }

    public ArrayList<Missao> getMissoesSupervisionadas() {
        return new ArrayList<>(missoesSupervisionadas);
    }

    public int getNumeroMissoesSupervisionadas() {
        return missoesSupervisionadas.size();
    }

    public void adicionarMissaoSuperV(Missao missao) {
        if (missao == null) {
            throw new IllegalArgumentException("Missão inválida.");
        }

        if (!missoesSupervisionadas.contains(missao)) {
            missoesSupervisionadas.add(missao);
        }
    }

    public void removerMissaoSuperV(Missao missao) {
        missoesSupervisionadas.remove(missao);
    }
}
