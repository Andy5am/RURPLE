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


        Mapa mimapa = new Mapa(ejemplo);
        mimapa.setCaracteresMapa(ejemplo);
        mimapa.setFilas(ejemplo);
        mimapa.setColumnas(ejemplo);
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

        mimapa.RotateRobot("ROTATE",ejemplo);
        System.out.println(mimapa);
        mimapa.moveRobot("MOVE",ejemplo);
        System.out.println(mimapa);
        mimapa.RotateRobot("ROTATE",ejemplo);
        System.out.println(mimapa);







    }
}

