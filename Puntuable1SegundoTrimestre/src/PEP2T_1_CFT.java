import java.util.Scanner;
public class PEP2T_1_CFT {
    // Creamos dos variables globales
    float saldo;
    float tope;

    // Cramos un método constructor con las dos variables globales
    public PEP2T_1_CFT(float tope, float saldo){
        this.tope = tope;
        this.saldo = saldo;
    }
    private void verif_saldo(PEP2T_1_CFT cajero){
        // Imprimimos el saldo actual
        System.out.printf("%-15s %-1s", "", "Su saldo actual es de " + cajero.saldo + "€\n");
    }

    private void verif_tope(PEP2T_1_CFT cajero, float dinero){
        // En caso de que el dinero introducido sea mayor que el tope actual, nos mostrarña un mensaje con el
        // valor del tope
        if(dinero > cajero.tope){
            System.out.printf("%-15s %-1s", "", "Tiene establecido ahora un tope de " + cajero.tope + "€\n");
        }
        // Si el dinero es menor o igual que el tope y el salario, resta el dinero introducido, a sus
        // respectivas cantidades
        if (dinero <= cajero.tope && dinero <= cajero.saldo) {
            cajero.tope -= dinero;
            cajero.saldo -= dinero;
        }
    }

    private float retirada(PEP2T_1_CFT cajero){
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%-15s %-1s", "", "Teclee dinero a retirar: \n\t\t\t\t");
        float dinero = teclado.nextFloat();
        // Si el dinero es menor o igual que el tope y saldo, mostrará el mensaje de que se retiró el dinero
        if(dinero <= cajero.tope && dinero <= cajero.saldo) {
            System.out.printf("%-15s %-1s", "", "Usted retiró " + dinero + "€\n");
        }
        // En caso de que sea mayor que el tope o el saldo, mostrará el siguiente mensaje
        if (dinero > cajero.tope || dinero > cajero.saldo){
            System.out.printf("%-15s %-1s", "", "Intenta retirar " + dinero + "€\n");
        }
        return dinero;
    }

    private void ingreso(PEP2T_1_CFT cajero){
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%-15s %-1s", "", "Teclee dinero a ingresar: \n\t\t\t\t");
        float dinero = teclado.nextFloat();
        // Se sumará el dinero introducido en el saldo
        System.out.printf("%-15s %-1s", "", "Usted ingresó " + dinero + "€\n");
        cajero.saldo += dinero;
    }

    private void menu (float tope, float saldo){
        Scanner teclado = new Scanner(System.in);
        // Instanciamos un objeto denominado cajero usando el método constructor
        PEP2T_1_CFT cajero = new PEP2T_1_CFT(tope, saldo);
        String negrita = "\033[0;1m";
        String subrayado = "\033[04m";
        String reset = "\033[0m";
        String salto_linea = "\n";
        int op = 0;
        // Imprimimos un menú que se repite hasta introducir salir
        System.out.printf("%-16s %-1s","", negrita + subrayado + "PROGRAMA CAJERO AUTOMÁTICO" + reset + salto_linea);
        while (op != 3) {
            float dinero = 0;
            System.out.print("\n");
            System.out.printf("%-21s %-1s", "", negrita + "Menú de Opciones" + reset + salto_linea);
            System.out.printf("%-21s %-1s", "", negrita + "================" + reset + salto_linea + salto_linea);
            System.out.printf("%-13s %-1s", "", "1) Retirada de dinero\n");
            System.out.printf("%-13s %-1s", "", "2) Ingreso de dinero\n");
            System.out.printf("%-13s %-1s", "", "3) Salir\n\n");
            System.out.printf("%-21s %-1s", "", "Opción: ");
            op = teclado.nextInt();
            System.out.print("\n");
            // Usando un switch de manera selectiva entraremos en una opción según la que se haya introducido
            switch (op){
                case 1:
                    verif_saldo(cajero);
                    dinero = retirada(cajero);
                    verif_tope(cajero, dinero);
                    verif_saldo(cajero);
                    break;
                case 2:
                    verif_saldo(cajero);
                    ingreso(cajero);
                    verif_saldo(cajero);
                    break;
                case 3:
                    // En caso de introducir el 3, saldremos del programa
                    break;
                // En caso de no ser ninguno de las anteriores opciones, se repetirá el menú
                default:
            }
        }
    }

    // En el método principal instanciamos un objeto usando el método constructor, en el que nos llevaremos como
    // parámetros del método los argumentos introducidos
    public static void main (String[] args){
        PEP2T_1_CFT principal = new PEP2T_1_CFT(Float.parseFloat(args[0]), Float.parseFloat(args[1]));
        // Llamamos al método mení heredado de principal, usando como parámetros los dos argumentos introducidos
        principal.menu(Float.parseFloat(args[0]), Float.parseFloat(args[1]));
    }
}