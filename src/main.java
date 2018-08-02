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
        System.out.println("Ingrese el nombre del archivo del mapa:");
        String mapa = input.nextLine();
        ArrayList<String> ejemplo = new ArrayList<String>();
        try {
            Stream<String>lines = Files.lines(
                    Paths.get("C:/Users/Andy Castillo/Documents/POO/"+mapa),
                    StandardCharsets.UTF_8
            );
            lines.forEach(a -> ejemplo.add(a));
        }catch (IOException e ){
            System.out.println("Error!");
        }

        System.out.println("Ingrese el nombre del archivo de instrucciones:");
        String Intrucciones = input.nextLine();
        ArrayList<String> instrucciones = new ArrayList<String>();
        try {
            Stream<String>lines = Files.lines(
                    Paths.get("C:/Users/Andy Castillo/Documents/POO/"+Intrucciones),
                    StandardCharsets.UTF_8
            );
            lines.forEach(a -> instrucciones.add(a));
        }catch (IOException e ){
            System.out.println("Error!");
        }

        Mapa mimapa = new Mapa(ejemplo);
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
            try{
                Thread.sleep(700);
            }catch (Exception e){
                System.out.println("Error en timer");
            }
        }
        if(mimapa.TareaCompletada()){
            System.out.println("El robot ha recogido todas las monedas");
        }else {
            System.out.println("El robot ha fallado en recoger todas las monedas");
        }







    }
}

