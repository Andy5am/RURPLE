import java.util.ArrayList;

public class Robot {

    private int monedas = 0;
    private String direccion;
    public String [][] posicion;
    public static final String VIENDO_ARRIBA = "^";
    public static final String VIENDO_DERECHA = ">";
    public static final String VIENDO_ABAJO = "V";
    public static final String VIENDO_IZQUIERDA = "<";

    public Robot(ArrayList<String> archivo) {

        ArrayList<String> listamapa = new ArrayList<String>();
        for (int i = 0; i < archivo.size(); i++) {
            String[] simbolos = archivo.get(i).split("");
            for (int j = 0; j < simbolos.length; j++) {
                listamapa.add(simbolos[j]);
            }

        }

        String[][] mapa = new String[archivo.size()][archivo.get(0).length()];
        int z = 0;
        do {
            for (int i = 0; i < archivo.size(); i++) {
                for (int j = 0; j < archivo.get(0).length(); j++) {
                    mapa[i][j] = listamapa.get(z);
                    if (listamapa.get(z).equals("<")||listamapa.get(z).equals(">")||listamapa.get(z).equals("V")||listamapa.get(z).equals("^")){
                        direccion= listamapa.get(z);

                    }

                    z += 1;
                }
            }
        } while (z != listamapa.size());
    }

    public int getMonedas() {
        return monedas;
    }

    public void agarrarmonedas(String instruccion, GrupoMonedas posicionmoneda) {
        if (instruccion.equals("PICK")&& posicionmoneda.getPosicion()== this.posicion ) {
            monedas++;

        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void   CambiarDireccion() {
            switch (this.direccion){
                case VIENDO_ARRIBA:
                    this.direccion=VIENDO_DERECHA;
                    break;
                case VIENDO_DERECHA:
                    this.direccion=VIENDO_ABAJO;
                    break;
                case VIENDO_ABAJO:
                    this.direccion=VIENDO_IZQUIERDA;
                    break;
                case VIENDO_IZQUIERDA:
                    this.direccion=VIENDO_ARRIBA;
                    break;
            }

    }

    public String[][] getPosicion() {
        return posicion;
    }

    public void setPosicion(ArrayList<String> archivo) {

    }


    @Override
    public String toString() {
        String result = "";
        switch (direccion){
            case VIENDO_ABAJO:result +="V";
            case VIENDO_ARRIBA:result +="^";
            case VIENDO_DERECHA:result+= ">";
            case VIENDO_IZQUIERDA:result+= "<";
        }return result;

    }
}
