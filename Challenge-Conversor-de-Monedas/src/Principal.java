import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner cantidad = new Scanner(System.in);
        Scanner codigo = new Scanner(System.in);
        Scanner ciclo = new Scanner(System.in);
        ConsultaExangeRateApi cambioMoneda = new ConsultaExangeRateApi();

        while (true){
            System.out.println("""
                *** Códigos de otros países ***
                ARS - Peso argentino        | CAD - Dólar Canadiense
                BOB - Boliviano boliviano   | JPY - Yen Japonés
                BRL - Real brasileño        | HKD - Dólar de Honk Kong
                CLP - Peso chileno          | IDR - Rupia Indonesia
                COP - Peso colombiano       | RUB - Rublo Ruso
                USD - Dólar estadounidense  | EUR - Euro
                """);
            System.out.println("Escriba la cantidad que quiere convertir de pesos mexicanos (MXN) a otra moneda:");

            try {
                var cantidadConvertir = Double.valueOf(cantidad.nextLine());
                System.out.println("Escriba el código de país a la moneda que desea convertir la cantidad de: $"+cantidadConvertir+"MXN");
                var codigoPais = codigo.nextLine();
                Moneda monedaCambio = cambioMoneda.cambioMoneda(codigoPais.toUpperCase(), cantidadConvertir);
                System.out.println(monedaCambio);
                System.out.println("$"+cantidadConvertir+" MXN equivale a $"+monedaCambio.conversion_result()+" "+codigoPais.toUpperCase());
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir moneda "+e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizó la aplicación.");
            }
            System.out.println("""
                    ¿Desea hacer otra conversión?
                    1.- Sí
                    2.- No (Finalizar aplicación)
                    """);
            var contiuar = ciclo.nextLine();
            if (contiuar.equals("2")) {
                break;
            }
        }
    }
}
