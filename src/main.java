import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args){

        ArrayList<String> ejemplo = new ArrayList<String>();
        try {
            Stream<String>lines = Files.lines(
                    Paths.get("C:/Users/Andy Castillo/Documents/POO/mapa.txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(a -> ejemplo.add(a));
        }catch (IOException e ){
            System.out.println("Error!");
        }
        System.out.println("Mapa");
        ejemplo.forEach(a -> System.out.println(a));


        ArrayList<String> listamapa = new ArrayList<String>();
        for (int i=0; i < ejemplo.size();i++){
            String[] simbolos = ejemplo.get(i).split("");
            for (int j =0; j < simbolos.length ; j++){
                listamapa.add(simbolos[j]);
            }

        }
        String[][] mapa = new String[ejemplo.size()][ejemplo.get(0).length()];
        int z = 0;
        String map = "";
        do {
            for(int i =0 ; i < ejemplo.size();i++){
                for (int j=0; j<ejemplo.get(0).length();j++){
                    mapa[i][j] = listamapa.get(z);
                    z+= 1 ;
                }
            }
        }while (z!= listamapa.size());

        for(int i = 0 ;i < 12 ; i++){
            for (int j = 0; j<37 ;j++){
                map += mapa[i][j];
            }
            map+="\n";
        }
        Mapa mimapa = new Mapa(ejemplo);
        System.out.println(mimapa);

        ArrayList<String> instrucciones = new ArrayList<String>();
        try {
            Stream<String>lines = Files.lines(
                    Paths.get("C:/Users/Andy Castillo/Documents/POO/instrucciones.txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(a -> instrucciones.add(a));
        }catch (IOException e ){
            System.out.println("Error!");
        }
        instrucciones.forEach(a -> System.out.println(a));

        mimapa.moveRobot("MOVE",ejemplo);
        System.out.println(mimapa);
        System.out.println(listamapa.indexOf("<"));







    }
}

