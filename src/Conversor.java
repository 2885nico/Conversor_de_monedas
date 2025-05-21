import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) throws IOException, InterruptedException  {
        Conversor.eleccionUserMenu();
    }
    public void menuEleccion(){
        print("*********************************************************************" +
                "Elige el numero de la conversion de moneda que quieres hacer: \n" +
                "/t 1) USD a CLP \n" +
                "/t 2) CLP a USD \n" +
                "/t 3) ARS a USD \n" +
                "/t 4) USD a ARS \n" +
                "/t 9) Salir \n" +
                "***********************+*******************************************" +
                "Elige una opcion valida: ");

    }
    public void convertirMoneda(){
        Scanner scanner = new Scanner(System.in);
        Consulta_Moneda consulta = new Consulta_Moneda();
        Moneda moneda;
        boolean a = true;
        while (a){
            menuEleccion();
            String eleccion = scanner.nextLine();
            System.out.println("Cuanta cantidad de esa moneda quieres convertir?: ");
            String cantidad = scanner.nextLine();

            switch (eleccion){
                case 1: moneda = consulta.buscarMoneda("USD","CLP",cantidad);
                    System.out.println(moneda);
                    break;
                case 2: moneda = consulta.buscarMoneda("CLP","USD",cantidad);
                    System.out.println(moneda);
                        break;
                case 3: moneda = consulta.buscarMoneda("ARS","USD",cantidad);
                    System.out.println(moneda);
                            break;
                case 4: moneda = consulta.buscarMoneda("USD","ARS",cantidad);
                    System.out.println(moneda);
                                break;
                default: a=false;

            }
        }
    }
}
