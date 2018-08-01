import java.util.ArrayList;

public class GrupoMonedas {
    private ArrayList<Integer> monedas= new ArrayList<>();
    private ArrayList<Integer> posicion= new ArrayList<>();

    public GrupoMonedas(ArrayList<String> archivo) {
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
                    if (!listamapa.get(z).equals(" ")&&!listamapa.get(z).equals("*")&&!listamapa.get(z).equals("<")
                            &&!listamapa.get(z).equals(">")&&!listamapa.get(z).equals("V")&&!listamapa.get(z).equals("^")){
                        this.monedas.add(Integer.parseInt(listamapa.get(z)));
                        this.posicion.add(listamapa.indexOf(listamapa.get(z)));


                    }

                    z += 1;
                }
            }
        } while (z != listamapa.size());
    }



    public int getMonedas(int index) {
        return monedas.get(index);
    }


    public void PickedMoneda(int index){
        this.monedas.set(index,this.monedas.get(index)-1);
    }

    public int getPosicion(int index) {
        return posicion.get(index);

    }
    public int getGruposMonedas(){
        return posicion.size();
    }

    @Override
    public String toString() {
        String result = "";
        result+= monedas;


        return result;
    }
}
