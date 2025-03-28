package pelea;

import javax.swing.*;

public interface Mago {

    /*El mago tiene las stats en general normales, se le añade el nuevo valor de maná (se recarga de a poco despues de cada accion),
    puede lanzar hechizos, puede recargar su propio maná mas rapido y su habilidad especial es reflejar daño
     */
    default double hechizo(Jugador enemigo, float ataque_magico_yo, String nombre_yo){
        float ataque = ataque_magico_yo, defensa = enemigo.getDefensa_magica();
        double danio = ataque - (defensa-(defensa*0.2));
        System.out.println(nombre_yo+" espadeó a "+enemigo.getNombre());
        return danio;
    }//1pt
    default float recargar(){
        JOptionPane.showMessageDialog(null, "Maná +5");
        return  (float) 2;
    } //2pt
    default void reflejar_danio(String nombre_yo){
        JOptionPane.showMessageDialog(null, nombre_yo + " se prepara para reflejar daño. ");

    } //3pt

}
