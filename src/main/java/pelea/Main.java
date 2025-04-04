package pelea;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Se puede ser hibrido, si decide solo 2 tipos puede tener todas sus hab, si es de más ya depende de los puntos.

        Peleador ayano = new Peleador("Ayano", "''PERO JUAN TIRA ULTI!'' *se le calienta el telefono y mueren los 2* ", 5, 5, 5, 5);
        Peleador maxiimo = new Peleador("Maxiimo", "''Te lo juro este personaje es el mejor.'' (3/13/2)", 0, 5, 0, 0);
        Peleador jlukep = new Peleador("JLukep", "''METETE METETE'' *trata de tirar ulti pero se le congela el juego*", 0, 0, 5, 0);
        Peleador pimpom = new Peleador("PimPom", "''Ahora si voy a jugar cuidadosamente'' (0/11/0)", 0, 0, 0, 0);
        Peleador jugador = new Peleador("Crear peleador", "", 0, 0, 0, 0);
        ayano.setAtributos();
        maxiimo.setAtributos();
        jlukep.setAtributos();
        pimpom.setAtributos();
        jugador.setAtributos();


        Jugador p1 = menu(ayano, maxiimo, jlukep, pimpom, jugador);
        Jugador p2 = menu(ayano, maxiimo, jlukep, pimpom, jugador);

        //p1.distribuirPuntos();
        if (modo() == 1) {
            pvb(p1, p2);
        } else {
            pvp(p1, p2);
        }
        //menu(ayano, maxiimo, jlukep, pimpom);
    }

    public static Jugador menu(Peleador ayano, Peleador maxiimo, Peleador jlukep, Peleador pimpom, Peleador jugador) {

        int opcion;
        String ya_fue_elegido = "Este personaje ya ha sido elegido, escoge otro...";

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("LUCHADORES: " +
                    "\n 1. " + ayano.getNombre() +
                    "\n 2. " + maxiimo.getNombre() +
                    "\n 3. " + jlukep.getNombre() +
                    "\n 4. " + pimpom.getNombre() +
                    "\n 5. " + jugador.getNombre()));
            switch (opcion) {
                case (1):
                    if (ayano.isElegido()) {
                        JOptionPane.showMessageDialog(null, ya_fue_elegido);
                        opcion = 0;
                        break;
                    }
                    opcion = ayano.getAtributos();
                    if (opcion == 9) {
                        return ayano.asignarJugador(ayano);
                    }
                    break;
                case (2):
                    if (maxiimo.isElegido()) {
                        JOptionPane.showMessageDialog(null, ya_fue_elegido);
                        opcion = 0;
                        break;
                    }
                    opcion = maxiimo.getAtributos();
                    if (opcion == 9) {
                        return maxiimo.asignarJugador(maxiimo);
                    }
                    break;
                case (3):
                    if (jlukep.isElegido()) {
                        JOptionPane.showMessageDialog(null, ya_fue_elegido);
                        opcion = 0;
                        break;
                    }
                    opcion = jlukep.getAtributos();
                    if (opcion == 9) {
                        return jlukep.asignarJugador(jlukep);
                    }
                    break;
                case (4):
                    if (pimpom.isElegido()) {
                        JOptionPane.showMessageDialog(null, ya_fue_elegido);
                        opcion = 0;
                        break;
                    }
                    opcion = pimpom.getAtributos();
                    if (opcion == 9) {
                        return pimpom.asignarJugador(pimpom);
                    }
                    break;


                case (5):
                    if (jugador.getNombre().equals("Crear peleador")) {
                        Jugador personaje = jugador.asignarJugador(jugador);
                        opcion = crear_jugador(personaje);
                        if (opcion == 0) break;
                        return personaje;

                    } else if (jugador.isElegido()) {
                        JOptionPane.showMessageDialog(null, ya_fue_elegido);
                        opcion = 0;
                        break;
                    }
                    opcion = jugador.getAtributos();
                    if (opcion == 9) {
                        return jugador.asignarJugador(jugador);
                    }
                    break;


                default:
                    opcion = 0;
                    JOptionPane.showMessageDialog(null, "Opcion no existente");
                    break;
            }
        } while (opcion == 0);
        return menu(ayano, maxiimo, jlukep, pimpom, jugador);
    }

    public static int modo() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione modo de juego: \n 1. Jugador vs Bot \n 2. Jugador vs Jugador"));
        } while (opcion > 3);
        return opcion;
    }

    public static void pvb(Jugador p1, Jugador p2) {
        JOptionPane.showMessageDialog(null, "¡COMIENZA LA PELEA!");
        while (p1.getVida() > 0 && p2.getVida() > 0) {
            if (p1.getVida() > 0) {
                if (!p1.isNoqueado() && !p1.IsContraatacar()&&!p1.isReflejar()) {
                    p1.mostrarAcciones(p2);

                } else {
                    p1.listarHabilidades(0, p2);
                }
            }
            getVida_pelea(p1, p2);
            if (p1.getVida() < 0) {
                JOptionPane.showMessageDialog(null, p2.getNombre() + " ha derrotado a " + p1.getNombre());
                break;
            }

            if (!p2.isNoqueado()) {
                if (p2.getVida() > 0) {
                    p2.atacar_del_enemigo(p1, p2);
                    if (p2.getTp() < 10) p2.setTp(p2.getTp() + 1);
                    if (p2.getMp() < 10) p2.setMp(p2.getMp() + 1);

                } else  {
                    p2.listarHabilidades(0, p1);
                }
            }
            getVida_pelea(p1, p2);

            if (p2.getVida() < 0) {
                JOptionPane.showMessageDialog(null, p1.getNombre() + " ha derrotado a " + p2.getNombre());
                break;
            }
        }
    }

    public static void pvp(Jugador p1, Jugador p2) {
        JOptionPane.showMessageDialog(null, "¡COMIENZA LA PELEA!");
        while (p1.getVida() > 0 && p2.getVida() > 0) {
            if (p1.getVida() > 0) {
                if (!p1.isNoqueado() && !p1.IsContraatacar()&&!p1.isReflejar()) {
                    p1.mostrarAcciones(p2);

                } else  {
                    p1.listarHabilidades(0, p2);
                }
            }
            getVida_pelea(p1, p2);
            if (p1.getVida() < 0) {
                JOptionPane.showMessageDialog(null, p2.getNombre() + " ha derrotado a " + p1.getNombre());
                break;
            }
            if (p2.getVida() > 0) {
                if (!p2.isNoqueado() && !p2.IsContraatacar()&&!p2.isReflejar()) {
                    p2.mostrarAcciones(p1);

                }else {
                    p2.listarHabilidades(0, p1);
                }
            }
            getVida_pelea(p1, p2);
            if (p2.getVida() < 0) {
                JOptionPane.showMessageDialog(null, p1.getNombre() + " ha derrotado a " + p1.getNombre());
                break;
            }

        }
    }

    public static void getVida_pelea(Peleador p1, Peleador p2) {
        System.out.println("\n" + p1.getNombre() + ": Vida " + p1.getVida());
        System.out.println(p2.getNombre() + ": Vida " + p2.getVida() + "\n----------------------------------------");
    }

    public static int crear_jugador(Jugador personaje) {
        int opcion;
        personaje.asignarJugador(personaje);
        do {
            personaje.resetPersonaje();
            opcion = personaje.setNombre();
            if (opcion == 0) break;
            do {
                opcion = personaje.distribuirPuntos(); //puntos de jugador, agragar var opcion
                if (opcion == 0) break;
                opcion = personaje.setDescripcion();
            } while (opcion == 0);
            if (opcion == 1) break;
        } while (opcion == 0);
        if (opcion == 9) return 1;

        personaje.resetPersonaje();
        return 0;

    }

}