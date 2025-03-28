package pelea;

import javax.swing.*;
import java.util.ArrayList;

public class Peleador implements Luchador, Caballero, Mago, Arquero {

    //Debe tener String nombre, int (atk dfc)
    protected String nombre;
    protected float ataque;
    protected float ataque_magico;
    protected float defensa;
    protected float defensa_magica;
    protected float mp;
    protected float tp;

    protected float cons_ataque;
    protected float cons_ataque_magico;
    protected float cons_defensa;
    protected float cons_defensa_magica;

    protected float vida;
    protected float vida_temp;
    protected String descripcion;
    protected boolean elegido;
    protected int puntos_luchador;
    protected int puntos_caballero;
    protected int puntos_mago;
    protected int puntos_arquero;
    protected ArrayList<String> ataques = new ArrayList<>();
    protected ArrayList<String> habilidades = new ArrayList<>();

    //Constructor


    public Peleador(String nombre, float vida, float vida_temp, float ataque, float ataque_magico, float defensa, float defensa_magica, float mp, float cons_ataque, float cons_ataque_magico, float cons_defensa, float cons_defensa_magica, float tp, String descripcion, boolean elegido, int puntos_luchador, int puntos_caballero, int puntos_mago, int puntos_arquero, ArrayList<String> ataques, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.ataque_magico = 0;
        this.ataque = 30;
        this.defensa = 20;
        this.defensa_magica = 20;
        this.mp = 10;
        this.cons_ataque = ataque;
        this.cons_ataque_magico = ataque_magico;
        this.cons_defensa = defensa;
        this.cons_defensa_magica = defensa_magica;
        this.tp = 10;
        this.vida = vida;
        this.vida_temp = 0;
        this.descripcion = descripcion;
        this.puntos_luchador = puntos_luchador;
        this.puntos_caballero = puntos_caballero;
        this.puntos_mago = puntos_mago;
        this.puntos_arquero = puntos_arquero;
        this.ataques = ataques;
        this.habilidades = habilidades;
    }

    public Peleador(String nombre, String descripcion, int puntos_luchador, int puntos_caballero, int puntos_mago, int puntos_arquero) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vida = 1000;
        this.ataque_magico = 0;
        this.ataque = 30;
        this.defensa = 20;
        this.defensa_magica = 20;
        this.tp = 10;
        this.mp = 10;
        this.puntos_luchador = puntos_luchador;
        this.puntos_caballero = puntos_caballero;
        this.puntos_mago = puntos_mago;
        this.puntos_arquero = puntos_arquero;
        this.elegido = false;
        asignarAcciones();
    }

    public String getNombre() {
        return nombre;
    }

    public float getAtaque() {
        return ataque;
    }

    public float getAtaque_magico() {
        return ataque_magico;
    }

    public float getDefensa() {
        return defensa;
    }

    public float getDefensa_magica() {
        return defensa_magica;
    }

    public float getMp() {
        return mp;
    }

    public float getCons_ataque_magico() {
        return cons_ataque_magico;
    }

    public float getCons_ataque() {
        return cons_ataque;
    }

    public float getCons_defensa() {
        return this.cons_defensa;
    }

    public float getCons_defensa_magica() {
        return this.cons_defensa_magica;
    }

    public float getTp() {
        return tp;
    }



    public float getVida() {
        return vida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isElegido() {
        return elegido;
    }

    public int getPuntos_luchador() {
        return puntos_luchador;
    }

    public int getPuntos_caballero() {
        return puntos_caballero;
    }

    public int getPuntos_mago() {
        return puntos_mago;
    }

    public int getPuntos_arquero() {
        return puntos_arquero;
    }

    public ArrayList<String> getAtaques() {
        return this.ataques;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public float getVida_temp() {
        return vida_temp;
    }

    public void setVida_temp(float vida_temp) {
        this.vida_temp = vida_temp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public void setAtaque_magico(float ataque_magico) {
        this.ataque_magico = ataque_magico;
    }

    public void setDefensa(float defensa) {
        this.defensa = defensa;
    }

    public void setDefensa_magica(float defensa_magica) {
        this.defensa_magica = defensa_magica;
    }

    public void setmp(float mp) {
        this.mp = mp;
    }

    public void setCons_ataque(float cons_ataque) {
        this.cons_ataque = cons_ataque;
    }

    public void setCons_ataque_magico(float cons_ataque_magico) {
        this.cons_ataque_magico = cons_ataque_magico;
    }

    public void setCons_defensa(float cons_defensa) {
        this.cons_defensa = cons_defensa;
    }

    public void setCons_defensa_magica(float cons_defensa_magica) {
        this.cons_defensa_magica = cons_defensa_magica;
    }

    public void setTp(float tp) {
        this.tp = tp;
        while (this.tp>10) this.tp--;

    }

    public void setMp(float mp) {
        this.mp = mp;
while (this.mp>10) this.mp--;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }

    public void setPuntos_luchador(int puntos_luchador) {
        this.puntos_luchador = puntos_luchador;
    }

    public void setPuntos_caballero(int puntos_caballero) {
        this.puntos_caballero = puntos_caballero;
    }

    public void setPuntos_mago(int puntos_mago) {
        this.puntos_mago = puntos_mago;
    }

    public void setPuntos_arquero(int puntos_arquero) {
        this.puntos_arquero = puntos_arquero;
    }


    public int getAtributos() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Nombre del peleador: " + this.nombre + "\n Ataque: " + this.ataque + "\n Defensa: " + this.defensa +
                    "\n Ataque Mágico: " + this.ataque_magico + "\n Defensa Mágica: " + this.defensa_magica + "\n Descripcion: " + this.descripcion + "\n \n 0. Atrás \n 9. Elegir"));
        } while (opcion != 0 && opcion != 9);
        if (opcion == 9) {
            this.elegido = true;
            return opcion;
        }
        return 0;
    }

    //SETS


    public void setAtributos() {
        this.ataque_magico = 0;
        this.ataque = 30;
        this.defensa = 20;
        this.defensa_magica = 20;

        if (this.puntos_luchador > 0) {
            this.ataque += (this.puntos_luchador * 0.5);
            this.defensa += (this.puntos_luchador * 0.5);
            this.defensa_magica -= (this.puntos_luchador * 0.2);
        }

        if (this.puntos_caballero > 0) {
            this.ataque += (this.puntos_caballero * 0.6);
            this.defensa += (this.puntos_caballero * 0.6);
            this.defensa_magica += (this.puntos_caballero * 0.1);
        }

        if (this.puntos_mago > 0) {
            this.ataque_magico += this.puntos_mago*9;
            this.defensa_magica += (this.puntos_mago * 0.5);
        }

        if (this.puntos_arquero > 0) {
            //XD era agilidad pero lo quite ajsajdjasd
        }

        asignarAcciones();

    }

    public void resetPersonaje() {
        this.nombre = "Crear peleador";
        this.descripcion = "";
        this.ataque_magico = 0;
        this.ataque = 30;
        this.defensa = 20;
        this.defensa_magica = 20;
        this.puntos_luchador = 0;
        this.puntos_caballero = 0;
        this.puntos_mago = 0;
        this.puntos_arquero = 0;
    }

    public Jugador asignarJugador(Peleador peleador) {
        Jugador jugador = new Jugador(this.nombre, this.descripcion, this.puntos_luchador, this.puntos_caballero, this.puntos_mago, this.puntos_arquero, 0);
        return jugador;
    }

    public void asignarAcciones() {
        this.ataques.clear();
        this.habilidades.clear();
        int i = 0;
        int j = 0;
        if (this.puntos_luchador > 0) {
            this.ataques.add(i + ". Golpear");
            i++;
            if (this.puntos_luchador > 1) {
                this.habilidades.add(j + ". Noquear");
                j++;
/*
                if (this.puntos_luchador > 2) {
                    this.habilidades.add(j + ". Evadir");
                    j++;

                }

 */
            }
        }

        if (this.puntos_caballero > 0) {
            this.ataques.add(i + ". Espadazo");
            i++;
            if (this.puntos_caballero > 1) {
                this.habilidades.add(j + ". Escudear");
                j++;


                if (this.puntos_mago > 2) {
                    this.habilidades.add(j + ". Contraatacar");
                    j++;

                }

            }

        }

        if (this.puntos_mago > 0) {
            this.ataques.add(i + ". Hechizo");
            i++;


            if (this.puntos_mago > 1) {
                this.habilidades.add(j + ". Recargar");
                j++;

                if (this.puntos_mago > 2) {
                    this.habilidades.add(j + ". Reflejar Daño");
                    j++;

                }


            }

        }

        if (this.puntos_arquero > 0) {
            this.ataques.add(i + ". Rajar");
            i++;
            this.habilidades.add(j + ". Disparar");
            j++;
            if (this.puntos_arquero > 1) {
                this.habilidades.add(j + ". Disparar Rafaga");
                j++;
/*
                if (this.puntos_arquero > 2) {
                    this.habilidades.add(j + ". Aquiles");
                    j++;

                }

 */
            }
        }
    }

    public void setVida(double danio) {
        this.vida -= danio;
    }
    /*
    public void atacar (Peleador enemigo) {
        int ataque = this.ataque, defensa = enemigo.defensa;
        ataque +=(int) ((Math.random()*10)+1);
        defensa += (int) ((Math.random()*5)+1);
        int danio = ataque - defensa;
        if (danio > 0)enemigo.setVida(danio);
        System.out.println(this.nombre+" atacó a "+enemigo.nombre);
    }
    */

    public void mensajeAtaque(Peleador enemigo, double danio) {
        if (danio > 0) {
            enemigo.setVida(danio);
            System.out.println(this.getNombre() + " hizo " + danio + " de daño.");
        } else {
            System.out.println("¡" + enemigo.getNombre() + " ni se inmuta!");
        }
    }

    public void mensajeBloqueo(double defensa) {
        this.setDefensa((float) defensa);
        this.setDefensa_magica((float) defensa);
    }

    public void resetDefensa(float defensa, float defensa_magica) {
        this.setDefensa(defensa);
        this.setDefensa_magica(defensa_magica);
    }

    public void atacar_del_enemigo(Jugador jugador, Jugador enemigo) {
        if (enemigo.isBloqueado()) {
            enemigo.setBloqueado(false);
            this.setDefensa(this.getDefensa()-this.getAtaque());

        }

        int rd = (int) ((Math.random() * 3) + 1);
        if (rd == 1) {
            rd = (int) ((Math.random() * enemigo.getAtaques().size() - 1) + 0);
            enemigo.listarAtaques(rd, jugador);

        } else if (rd == 2) {
            rd = (int) ((Math.random() * enemigo.getHabilidades().size() - 1) + 0);
            enemigo.listarHabilidades(rd, jugador);

        } else {
            enemigo.setBloqueado(true);
            this.setDefensa(this.getAtaque()+this.getDefensa());
        }

    }


}
