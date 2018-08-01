import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
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


        Mapa mimapa = new Mapa(ejemplo);
        GrupoMonedas mismonedas =new GrupoMonedas(ejemplo);
        System.out.println(mismonedas);
        mimapa.setCaracteresMapa(ejemplo);
        mimapa.setFilas(ejemplo);
        mimapa.setColumnas(ejemplo);
        System.out.println(mimapa);

        for (int a =0;a<instrucciones.size();a++){
            if (instrucciones.get(a).equals("MOVE")){
                mimapa.moveRobot(instrucciones.get(a),ejemplo);
                System.out.println(mimapa);
            }else if (instrucciones.get(a).equals("ROTATE")){
                mimapa.RotateRobot(instrucciones.get(a),ejemplo);
                System.out.println(mimapa);
            }else if (instrucciones.get(a).equals("PICK")){
                mimapa.Pickmoneda(instrucciones.get(a),ejemplo);
                System.out.println(mimapa);
            }
        }







    }
}

