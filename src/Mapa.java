
import java.util.ArrayList;

public class Mapa {
    private String[][] mapa;
    private Robot robot;
    private GrupoMonedas grupoMonedas;
    private ArrayList<String> CaracteresMapa = new ArrayList<String>();
    private int Filas;
    private int Columnas;


    public void setFilas(ArrayList<String> archivo) {
        this.Filas = archivo.size();
    }

    public void setColumnas(ArrayList<String> archivo) {
        this.Columnas = archivo.get(0).length();
    }

    public void setCaracteresMapa(ArrayList<String> archivo) {
        ArrayList<String> listamapa = new ArrayList<String>();
        for (int i = 0; i < archivo.size(); i++) {
            String[] simbolos = archivo.get(i).split("");
            for (int j = 0; j < simbolos.length; j++) {
                listamapa.add(simbolos[j]);
            }

        }
        this.CaracteresMapa = listamapa;
    }

    public Mapa(ArrayList<String> archivo) {
        ArrayList<String> listamapa = new ArrayList<String>();
        for (int i = 0; i < archivo.size(); i++) {
            String[] simbolos = archivo.get(i).split("");
            for (int j = 0; j < simbolos.length; j++) {
                listamapa.add(simbolos[j]);
            }

        }
        this.mapa = new String[archivo.size()][archivo.get(0).length()];
        int z = 0;
        do {
            for (int i = 0; i < archivo.size(); i++) {
                for (int j = 0; j < archivo.get(0).length(); j++) {
                    mapa[i][j] = listamapa.get(z);
                    this.mapa[i][j] = mapa[i][j];
                    z += 1;
                }
            }
        } while (z != listamapa.size());
        robot = new Robot(archivo);
        grupoMonedas = new GrupoMonedas(archivo);

    }

    public String[][] moveRobot(String instruccion, ArrayList<String> archivo) {
        if (instruccion.equals("MOVE")) {

            if (this.CaracteresMapa.contains(robot.getDireccion())) {
                switch (robot.getDireccion()) {
                    case "<":
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf("<") - 1, "<");
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf("<") + 1, " ");
                        for (int i =0;i<grupoMonedas.getGruposMonedas();i++){
                            if (this.CaracteresMapa.indexOf("<")+1== grupoMonedas.getPosicion(i)){
                                this.CaracteresMapa.set(grupoMonedas.getPosicion(i),String.valueOf(grupoMonedas.getMonedas(i)));
                            }
                        }
                        break;

                    case ">":

                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf(">") + 1, ">");
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf(">") , " ");
                        for (int i =0;i<grupoMonedas.getGruposMonedas();i++){
                            if (this.CaracteresMapa.indexOf(">")-1== grupoMonedas.getPosicion(i)){
                                this.CaracteresMapa.set(grupoMonedas.getPosicion(i),String.valueOf(grupoMonedas.getMonedas(i)));
                            }
                        }
                        break;

                    case "^":
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf("^") - archivo.get(0).length(), "^");
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf("^") + archivo.get(0).length(), " ");
                        for (int i =0;i<grupoMonedas.getGruposMonedas();i++){
                            if (this.CaracteresMapa.indexOf("^")+archivo.get(0).length()== grupoMonedas.getPosicion(i)){
                                this.CaracteresMapa.set(grupoMonedas.getPosicion(i),String.valueOf(grupoMonedas.getMonedas(i)));
                            }
                        }
                        break;

                    case "V":
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf("V") + archivo.get(0).length(), "V");
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf("V") , " ");
                        for (int i =0;i<grupoMonedas.getGruposMonedas();i++){
                            if (this.CaracteresMapa.indexOf("V") - archivo.get(1).length() == grupoMonedas.getPosicion(i)){
                                this.CaracteresMapa.set(grupoMonedas.getPosicion(i),String.valueOf(grupoMonedas.getMonedas(i)));
                            }
                        }
                        break;


                }
            }

            this.mapa = new String[archivo.size()][archivo.get(0).length()];
            int z = 0;
            do {
                for (int i = 0; i < archivo.size(); i++) {
                    for (int j = 0; j < archivo.get(0).length(); j++) {
                        mapa[i][j] = this.CaracteresMapa.get(z);
                        this.mapa[i][j] = mapa[i][j];
                        z += 1;
                    }
                }
            } while (z != this.CaracteresMapa.size());

        }
        return this.mapa;
    }

    public String[][] RotateRobot(String instruccion, ArrayList<String> archivo) {
        if (instruccion.equals("ROTATE")) {

            if (this.CaracteresMapa.contains(robot.getDireccion())) {
                String direccionanterior = robot.getDireccion();
                robot.CambiarDireccion();
                switch (robot.getDireccion()) {
                    case "^":
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf(direccionanterior), "^");
                        break;
                    case ">":
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf(direccionanterior), ">");
                        break;
                    case "V":
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf(direccionanterior), "V");
                        break;
                    case "<":
                        this.CaracteresMapa.set(this.CaracteresMapa.indexOf(direccionanterior), "<");
                        break;
                }
            }
            this.mapa = new String[archivo.size()][archivo.get(0).length()];
            int z = 0;
            do {
                for (int i = 0; i < archivo.size(); i++) {
                    for (int j = 0; j < archivo.get(0).length(); j++) {
                        mapa[i][j] = this.CaracteresMapa.get(z);
                        this.mapa[i][j] = mapa[i][j];
                        z += 1;
                    }
                }
            } while (z != this.CaracteresMapa.size());

        }
        return this.mapa;
    }

    public String[][] Pickmoneda(String instruccion, ArrayList<String> archivo) {
        if (instruccion.equals("PICK")) {
            for (int i=0; i < grupoMonedas.getGruposMonedas(); i++) {
                if (this.CaracteresMapa.indexOf(robot.getDireccion()) == grupoMonedas.getPosicion(i)) {
                    grupoMonedas.PickedMoneda(i);
                    robot.PickMoneda();
                }

            }
            this.mapa = new String[archivo.size()][archivo.get(0).length()];
            int z = 0;
            do {
                for (int i = 0; i < archivo.size(); i++) {
                    for (int j = 0; j < archivo.get(0).length(); j++) {
                        mapa[i][j] = this.CaracteresMapa.get(z);
                        this.mapa[i][j] = mapa[i][j];
                        z += 1;
                    }
                }
            } while (z != this.CaracteresMapa.size());
        }return this.mapa;
    }
    public boolean TareaCompletada(){
        for (int i=0;i<grupoMonedas.getGruposMonedas();i++){
            int suma = grupoMonedas.getMonedas(i);
            if (suma==0){
                return true;
            }
        }
        return false;
    }



    @Override
    public String toString() {
        String map = "";
        for (int i = 0; i < this.Filas; i++) {
            for (int j = 0; j < this.Columnas; j++) {
                map += this.mapa[i][j];
            }
            map += "\n";

        }
        map += "El robot tiene "+robot.getMonedas()+" monedas";
        return map;
    }
}
