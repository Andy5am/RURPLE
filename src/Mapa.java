import java.util.ArrayList;

public class Mapa {
    private String [][] mapa;
    private Robot robot;
    private GrupoMonedas [][] grupoMonedas;


    public String[][] getMapa() {
        return mapa;
    }

    public void setMapa(String[][] mapa) {
        this.mapa = mapa;
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
                    this.mapa[i][j]=mapa[i][j];
                    z += 1;
                }
            }
        } while (z != listamapa.size());
        robot= new Robot(archivo);

    }

    public String[][] moveRobot(String instruccion,ArrayList<String> archivo){
        if (instruccion.equals("MOVE")){
            ArrayList<String> listamapa = new ArrayList<String>();
            for (int i = 0; i < archivo.size(); i++) {
                String[] simbolos = archivo.get(i).split("");
                for (int j = 0; j < simbolos.length; j++) {
                    listamapa.add(simbolos[j]);
                }

            }
            if (listamapa.contains(robot.getDireccion())){
                switch (robot.getDireccion()){
                    case "<":
                        listamapa.set(listamapa.indexOf("<")-1,"<");
                        listamapa.set(listamapa.indexOf("<")+1," ");
                        break;
                    case ">":
                        listamapa.set(listamapa.indexOf(">")+1,">");
                        listamapa.set(listamapa.indexOf(">")-1," ");
                        break;
                    case "^":
                        listamapa.set(listamapa.indexOf("^")-archivo.get(0).length(),"^");
                        listamapa.set(listamapa.indexOf("^")+archivo.get(0).length()," ");
                        break;
                    case "V":
                        listamapa.set(listamapa.indexOf("^")+archivo.get(0).length(),"^");
                        listamapa.set(listamapa.indexOf("^")-archivo.get(0).length()," ");
                }
            }
            this.mapa = new String[archivo.size()][archivo.get(0).length()];
            int z = 0;
            do {
                for (int i = 0; i < archivo.size(); i++) {
                    for (int j = 0; j < archivo.get(0).length(); j++) {
                        mapa[i][j] = listamapa.get(z);
                        this.mapa[i][j]=mapa[i][j];
                        z += 1;
                    }
                }
            } while (z != listamapa.size());

        }return this.mapa;
    }

    public String [][] RotateRobot(String instruccion, )

    @Override
    public String toString() {
        String map = "";
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 37; j++) {
                map += this.mapa[i][j];
            }
            map += "\n";
        }return map;
    }
}
