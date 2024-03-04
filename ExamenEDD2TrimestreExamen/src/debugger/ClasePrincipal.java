package debugger;

public class ClasePrincipal {
    public static void main(String[] args) {
        String cadena = "a"; // Declaramos e inicializamos la variable "cadena"
        System.out.println(cadena); // Printamos la variable cadena, resultado = "a"
        do { // Aquí hace un bucle do while, la variable entra como "a", y si la cadena de caracteres
            // cada vez es menor de cinco caracteres, se le sumará una e, en este caso no saldrá
            // del bucle hasta que no sean 5 caracteres, resultado "aeeee"
            cadena = cadena + "e";
        } while (cadena.length() < 5);
        System.out.println(cadena); // Printamos, resultado "aeeee"
        do {
            // Aquí la variable está entrado como "aeeee", y se la añade "i" al final.
            cadena = cadena + "i";
            // Este bucle dice que mientras que la cadena tengo menos de 3 caracteres, se le añada una "i" más a la añadida
            // hasta que se hagan 3 caracteres, en este caso la cadena entra como "aeeeei", y como no cumple
            // la condicion del bucle, no entrará en bucle.
        } while (cadena.length() < 3);
        // Printamos la cadena como "aeeeei"
        System.out.println(cadena);
    }
}
