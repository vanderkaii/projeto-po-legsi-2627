public class Main
{
  public static void main(String[] args)
  {
    Cientista c1 = new Cientista("Vander", "vander@colonias.com", "Sistemas de Informação");
    System.out.println(c1.getIdHabitante());
    System.out.println(c1.getNomeCompleto());
    System.out.println(c1.getEmailInstitucional());
    
    Explorador ex1 = new Explorador("Malaquias", "malaquias@colonias.com");
    System.out.println(ex1.getIdHabitante());
    
    Engenheiro en1 = new Engenheiro("Zé", "ze@colonias.com", "Obras feitas");
    System.out.println(en1.getIdHabitante());
  }
}