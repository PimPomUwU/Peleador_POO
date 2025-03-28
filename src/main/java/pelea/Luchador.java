package pelea;

import javax.swing.*;

public interface Luchador {

    //El luchador solo no usa armas ni armadura, pero tiene mejores stats y la hab de noquear y evadir, baja defensa magica
    default double golpear(Jugador enemigo, float ataque_yo, String nombre_yo) {
        float ataque = ataque_yo, defensa = enemigo.getDefensa();
        ataque +=(int) ((Math.random()*5)+1);
        double danio = ataque - defensa;
        System.out.println(nombre_yo+" golpeó a "+enemigo.getNombre());
        return danio;
    }//1pt

    default void noquear(Jugador enemigo, String nombre_yo){
        JOptionPane.showMessageDialog(null, nombre_yo + " noqueó a " + enemigo.getNombre());
        enemigo.setNoqueado(true);
    }//2pt


}
