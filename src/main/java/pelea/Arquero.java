package pelea;

public interface Arquero {
    /*
    El arquero lanza flechas (limitadas)(dificiles de esquivar pero no penetra mucha armadura), alta agi/vel
    hab esp es lanzar varias flechas a la vez (pero pierde un turno), su ataque basico es con cuchillo
     */
    //rajar ignora la agilidad del enemigo y comienza a sangrar
    default double rajar(Jugador enemigo, float ataque_yo, String nombre_yo){
        float ataque = ataque_yo, defensa = enemigo.getDefensa();
        ataque +=(int) ((Math.random()*3)+1);
        double danio = ataque - defensa;
        System.out.println(nombre_yo+" rajó a "+enemigo.getNombre());
        return danio;
    } //1pt

    //ignora defensa normal, pero no la magica
    default double disparar(Jugador enemigo, float ataque_yo, String nombre_yo){
        float ataque = ataque_yo, defensa = enemigo.getDefensa_magica();
        ataque *= 2;
        double danio = ataque - defensa;
        System.out.println(nombre_yo+" disparó a "+enemigo.getNombre());
        return danio;
    } //2pt
   default double disparar_rafaga(Jugador enemigo, float ataque_yo, String nombre_yo){
       double danio = 0;
       for (int i = 0; i< 5; i++){
            float ataque = ataque_yo, defensa = enemigo.getDefensa_magica();
            ataque *= 2;
            danio += ataque - defensa;
            System.out.println(nombre_yo+" disparó a "+enemigo.getNombre());
        }
       return danio;
    } //4ç3pt
}
