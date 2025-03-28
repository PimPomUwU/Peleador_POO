package pelea;

import javax.swing.*;

public interface Caballero {

    /*El caballero usa armadura y espada, tiene mas ataque y defensa pero poca agi/vel,
     med defensa magica, puede bloquear y hab esp contraatacar (tmb recibe daño).
     */
    default double espadazo(Jugador enemigo, float ataque_yo, String nombre_yo){
        float ataque = ataque_yo;
        ataque +=(int) ((Math.random()*10)+1);
        double danio = ataque - (enemigo.getDefensa()-(enemigo.getDefensa()*0.2));
        System.out.println(nombre_yo+" espadeó a "+enemigo.getNombre());
        return danio;
    } //1pt
    default double escudear(String nombre_yo, float defensa_yo){
        float defensa = defensa_yo*10;
        System.out.println(nombre_yo+" alza su escudo");
        return defensa;
    } //2pt
    default void contraatacar(String nombre_yo){
        JOptionPane.showMessageDialog(null, nombre_yo + " se prepara para contraatacar ");


    } //3pt
}
