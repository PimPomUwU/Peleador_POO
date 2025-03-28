package pelea;

import javax.swing.*;
import java.util.ArrayList;

public class Jugador extends Peleador {

    //El jugador tendra su nombre y descripción, tambien reparte su exp en las tipos de peleador

    private int puntos;
    private boolean noqueado;
    private boolean bloqueado;
    private boolean contraatacar; // 0 es desactivado, 1 preparado, 2 contraatacar
    private boolean reflejar; // 0 es desactivado, 1 preparado, 2 contraatacar


    //constructor
    public Jugador(String nombre, float vida, float vida_temp, float ataque, float ataque_magico, float defensa, float defensa_magica, float mp, float cons_ataque, float cons_ataque_magico, float cons_defensa,
                   float cons_defensa_magica, float tp, String descripcion, boolean elegido, int puntos_luchador, int puntos_caballero, int puntos_mago, int puntos_arquero,
                   ArrayList<String> ataques, ArrayList<String> habilidades, int puntos) {
        super(nombre, vida, vida_temp, ataque, ataque_magico, defensa, defensa_magica, mp, cons_ataque, cons_ataque_magico, cons_defensa_magica, tp, vida, descripcion, elegido,
                puntos_luchador, puntos_caballero, puntos_mago, puntos_arquero, ataques, habilidades);
        this.puntos = 6;
        this.noqueado = false;
        this.bloqueado = false;
        this.contraatacar = false;
        this.reflejar = false;

    }

    public Jugador(String nombre, String descripcion, int puntos_luchador, int puntos_caballero, int puntos_mago, int puntos_arquero, int puntos) {
        super(nombre, descripcion, puntos_luchador, puntos_caballero, puntos_mago, puntos_arquero);
        this.puntos = 6;
        this.noqueado = false;
        this.bloqueado = false;
        this.contraatacar = false;
        this.reflejar = false;

    }

    public int distribuirPuntos() {
        resetPuntos();
        int opcion = 0;
        this.setCons_ataque(this.getAtaque());
        this.setCons_ataque_magico(this.getAtaque_magico());
        this.setCons_defensa(this.getDefensa());
        this.setCons_defensa_magica(this.getDefensa_magica());

        //bucle de prueba
        while (opcion != 99) {

            setAtributos();
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Nombre del peleador: " + this.getNombre() + "\n Ataque: " + this.getCons_ataque() + this.atributo_temporal(this.getAtaque(), this.getCons_ataque()) +
                    "\nDefensa:" + this.getCons_defensa_magica() + this.atributo_temporal(this.getDefensa(), this.getCons_defensa()) + "\nAtaque Mágico: " + this.getCons_ataque_magico() +
                    this.atributo_temporal(this.getAtaque_magico(), this.getCons_ataque_magico()) + "\nDefensa Mágica:" + this.getCons_defensa_magica() +
                    this.atributo_temporal(this.getDefensa_magica(), this.getCons_defensa_magica()) + "\n\nPuntos disponibles: " + this.getPuntos() + "\n\n Luchador: " + this.getPuntos_luchador() +
                    "\n Caballero: " + this.getPuntos_caballero() + "\n Mago: " + this.getPuntos_mago() + "\n Arquero: " + this.getPuntos_arquero() + "\n\n 0. Atrás       10.Continuar"));

            switch (opcion) {
                //Impar restan, par suman
                case 0:
                    return 0;
                case 1:
                    this.setPuntos_luchador(restarPuntos(this.getPuntos_luchador()));
                    break;
                case 2:
                    this.setPuntos_luchador(sumarPuntos(this.getPuntos_luchador()));
                    break;
                case 3:
                    this.setPuntos_caballero(restarPuntos(this.getPuntos_caballero()));
                    break;
                case 4:
                    this.setPuntos_caballero(sumarPuntos(this.getPuntos_caballero()));
                    break;
                case 5:
                    this.setPuntos_mago(restarPuntos(this.getPuntos_mago()));
                    break;
                case 6:
                    this.setPuntos_mago(sumarPuntos(this.getPuntos_mago()));
                    break;
                case 7:
                    this.setPuntos_arquero(restarPuntos(this.getPuntos_arquero()));
                    break;
                case 8:
                    this.setPuntos_arquero(sumarPuntos(this.getPuntos_arquero()));
                    break;
                case 10:
                    return 10;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;

            }

        }
        return 10;

    }

    public void resetPuntos() {
        this.vida = 1000;
        this.ataque_magico = 0;
        this.ataque = 30;
        this.defensa = 20;
        this.defensa_magica = 20;

    }

    public int restarPuntos(int puntos_clase) {
        if (puntos_clase > 0) {
            puntos_clase--;
            this.setPuntos(1);
        } else {
            JOptionPane.showMessageDialog(null, "La clase no tiene puntos...");
        }
        return puntos_clase;
    }

    public int sumarPuntos(int puntos_clase) {
        if (this.getPuntos() > 0) {
            puntos_clase++;
            this.setPuntos(-1);
        } else {
            JOptionPane.showMessageDialog(null, "La no tienes suficientes puntos..");
        }
        return puntos_clase;
    }

    public String atributo_temporal(float atributo, float atributo_cons) {
        String texto = "";
        float temp = atributo - atributo_cons;
        if (atributo != atributo_cons) {
            if (atributo > atributo_cons) texto = " +" + temp;
            if (atributo < atributo_cons) texto = " " + temp;

        }
        return texto;
    }


    public int setNombre() {
        int opcion;
        //nombre
        do {
            this.nombre = JOptionPane.showInputDialog("Ingrese nombre de su peleador: \n \n 0. Atrás");
            if (this.nombre.equals("0")) {
                this.nombre = "Crear peleador";
                return 0;
            }
            this.nombre = nombre;
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿El nombre ''" + this.nombre + "'' es correcto? \n 1. Si \n 2. No"));
            if (opcion == 2) this.nombre = "Crear peleador";

        } while (opcion == 2 || opcion == 0);
        return 1;
    }


    public int getPuntos() {
        return puntos;
    }

    public boolean IsContraatacar() {
        return contraatacar;
    }

    public void setContraatacar(boolean contraatacar) {
        this.contraatacar = contraatacar;
    }


    public boolean isReflejar() {
        return reflejar;
    }

    public void setReflejar(boolean reflejar) {
        this.reflejar = reflejar;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean isNoqueado() {
        return noqueado;
    }

    public void setNoqueado(boolean noqueado) {
        this.noqueado = noqueado;
    }

    public int setDescripcion() {
        int opcion;
        //Descripción
        do {
            this.descripcion = JOptionPane.showInputDialog("Ingrese descripcion de su peleador: \n \n 0. Atrás");
            if (this.descripcion.equals("0")) {
                this.descripcion = "";
                return 0;
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿La descripcion ''" + this.descripcion + "'' es correcta? \n 1. Si \n 2. No"));
            if (opcion == 2) {
                this.descripcion = "";
            } else {

                opcion = getAtributos();
                if (opcion == 1) this.resetPersonaje();
                if (opcion == 0) opcion = 2;
            }
        } while (opcion == 2);
        return opcion;

    }


    //Interfaz de pelea
    public void mostrarAcciones(Jugador enemigo) {

        if (this.isBloqueado()) {
            this.setBloqueado(false);
            this.setDefensa(this.getDefensa() - this.getAtaque());
        }
        if (this.getTp() < 10) this.setTp(this.getTp() + 1);
        if (this.getMp() < 10) this.setMp(this.getMp() + 1);
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Tú \n HP: " + this.getVida() + "\n TP: " + this.getTp() + "\n MP: " + this.getMp() + "\n " + enemigo.getNombre() + "\n HP: " + this.getVida() + "\n \n 1.Atacar      2.Habilidad \n 3.Bloquear"));


            switch (opcion) {

                case 1:
                    opcion = mostrarAtacar(opcion, enemigo);
                    break;
                case 2:
                    opcion = mostrarHabilidad(opcion, enemigo);
                    break;
                case 3:
                    //bloquear
                    setBloqueado(true);
                    this.setDefensa(this.getAtaque() + this.getDefensa());
                    JOptionPane.showMessageDialog(null, this.getNombre()+"se pone a la defensiva.");
                    break;
                default:
                    opcion = 7;
            }
        } while (opcion == 7);

    }

    public int mostrarAtacar(int opcion, Jugador enemigo) {
        String ataques_disponibles = "";
        for (String i : this.getAtaques()) {
            ataques_disponibles += i + "\n";
        }

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(ataques_disponibles + "\n 7.Atrás"));
            switch (opcion) {

                case (7):
                    return 7;
                default:
                    opcion = listarAtaques(opcion, enemigo);
                    break;
            }

        } while (opcion == 7);

        return opcion;
    }

    public int mostrarHabilidad(int opcion, Jugador enemigo) {
        String habilidades_disponibles = "";
        for (String i : this.getHabilidades()) {
            habilidades_disponibles += i + "\n";
        }

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(habilidades_disponibles + "\n 7.Atrás"));
            switch (opcion) {

                case (7):
                    return 7;
                default:
                    opcion = listarHabilidades(opcion, enemigo);
                    break;
            }

        } while (opcion == 7);
        return opcion;
    }

    public int listarAtaques(int opcion, Jugador enemigo) {
        String eleccion = this.getAtaques().get(opcion);
        if (getDefensa() != getCons_defensa()) resetDefensa(getCons_defensa(), getCons_defensa_magica());
        double danio = 0;
        eleccion = eleccion.substring(3);

        switch (eleccion) {
            //atk
            case "Golpear":
                danio = this.golpear(enemigo, this.getAtaque(), this.getNombre());
                mensajeAtaque(enemigo, danio);
                break;

            case "Espadazo":
                danio = this.espadazo(enemigo, this.getAtaque(), this.getNombre());
                mensajeAtaque(enemigo, danio);
                break;
            case "Hechizo":
                if (this.getMp() >= 3) {
                    danio = this.hechizo(enemigo, this.getAtaque_magico(), this.getNombre());
                    mensajeAtaque(enemigo, danio);
                    this.setMp(this.getMp()-3);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas 3MP PARA USAR: HECHIZO!");
                    opcion = 7;
                }
                break;

            case "Rajar":
                danio = this.rajar(enemigo, this.getAtaque(), this.getNombre());
                mensajeAtaque(enemigo, danio);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion inválida: " + opcion);
                opcion = 7;
                break;

        }
        return opcion;
    }

    public int listarHabilidades(int opcion, Jugador enemigo) {
        String eleccion;
        double danio;

        if (this.IsContraatacar()) {
            danio = (this.getVida_temp() - this.getVida()) * 2;
            this.setContraatacar(false);
            mensajeAtaque(enemigo, danio);
            return 0;

        }
        if (this.isReflejar()) {
            danio = (this.getVida_temp() - this.getVida()) + this.getDefensa();
            this.setReflejar(false);
            mensajeAtaque(enemigo, danio);
            return 0;

        }
        eleccion = this.getHabilidades().get(opcion);

        if (getDefensa() != getCons_defensa()) resetDefensa(getCons_defensa(), getCons_defensa_magica());
        double defensa;
        eleccion = eleccion.substring(3);


        switch (eleccion) {
            //HAB

            case "Noquear":
                if (this.getTp() >= 7) {
                    this.noquear(enemigo, this.getNombre());
                    this.setTp(this.getTp() - 7);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas 7TP PARA USAR: NOQUEAR!");
                    opcion = 7;
                }
                break;

            case "Escudear":
                if (this.getTp() >= 6) {
                    defensa = this.escudear(this.getNombre(), this.getDefensa());
                    this.setTp(this.getTp() - 6);
                    this.mensajeBloqueo(defensa);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas 6TP PARA USAR: ESCUDEAR!");
                    opcion = 7;
                }
                break;
            case "Disparar":
                if (this.getTp() >= 2) {
                    danio = this.disparar(enemigo, this.getAtaque(), this.getNombre());
                    mensajeAtaque(enemigo, danio);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas 2TP PARA USAR: DISPARAR!");
                    opcion = 7;
                }
                break;
            case "Disparar Rafaga":
                if (this.getTp() >= 10) {
                    danio = this.disparar_rafaga(enemigo, this.ataque, this.nombre);
                    JOptionPane.showMessageDialog(null, this.getNombre() + " lanza una rafaga de flechas!");
                    mensajeAtaque(enemigo, danio);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas 10TP PARA USAR: DISPARAR RAFAGA!");
                    opcion = 7;
                }
                break;
            case "Contraatacar":
                if (this.getTp() >= 6) {
                    if (!this.IsContraatacar()) {
                        this.setContraatacar(true);
                        this.contraatacar(this.getNombre());
                        this.setVida_temp(this.getVida());
                        // this.setPuntos(-this.getPuntos() + opcion);
                        this.setTp(this.getTp() - 5);
                        System.out.println("Contraataque");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas 6TP PARA USAR: CONTRAATACAR!");
                    opcion = 7;
                }
                break;
            case "Recargar":
                if (this.getTp() >= 5) {
                    setMp(this.recargar());
                    setTp(this.getTp() - 5);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas 5TP PARA USAR: RECARGAR!");
                    opcion = 7;
                }
                break;
            case "Reflejar Daño":
                if (this.getMp() >= 5) {
                    if (!this.isReflejar()) {
                        this.setReflejar(true);
                        this.reflejar_danio(this.getNombre());
                        this.setVida_temp(this.getVida());
                        // this.setPuntos(-this.getPuntos() + opcion);
                        this.setMp(this.getMp() - 5);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Necesitas MP PARA USAR: REFLEJAR DAÑO!");
                    opcion = 7;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion inválida: " + opcion);
                opcion = 7;
                break;

                /*

            case "Evadir":
                this.evadir(); //agilidad max
                JOptionPane.showMessageDialog(null, this.getNombre() + " evadió a " + enemigo.getNombre());
                break;
            case "Reflejar Daño":
                this.reflejar_danio();
                                JOptionPane.showMessageDialog(null, "Maná +5");
                break;

            case "Recargar":
                this.recargar();


                break;






            */

        }
        return opcion;
    }
}
