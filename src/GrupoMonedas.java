import java.util.ArrayList;

public class GrupoMonedas {
    private int monedas;
    private String[][] posicion;

    public GrupoMonedas(ArrayList<String> archivo) {

    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public String [][] getPosicion() {
        return posicion;
    }

    public void setPosicion(String[][] posicion) {
        this.posicion = posicion;
    }
}
