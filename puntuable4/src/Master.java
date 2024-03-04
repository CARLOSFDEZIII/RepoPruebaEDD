import java.util.*;

class Atlas {
    private final Map<String, String> atlas;

    public Atlas() {
        atlas = new HashMap<>();
    }

    // Añadir una entrada al atlas
    public void addEntry(String country, String capital) {
        atlas.put(country, capital);
        System.out.println("Nueva entrada incorporada");
    }

    // Mostrar el contenido actual del atlas
    public void displayEntries() {
        for (Map.Entry<String, String> entry : atlas.entrySet()) {
            System.out.println("País: " + entry.getKey() + " Capital: " + entry.getValue());
        }
        System.out.println("Hay " + atlas.size() + " elementos en el Atlas");
    }

    // Buscar una entrada del atlas
    public void searchEntry(String country) {
        String capital = atlas.get(country);
        if (capital == null) {
            System.out.println("De este país no se encuentra capital");
        } else {
            System.out.println("Capital: " + capital);
        }
    }

    // Modificar una entrada del atlas
    public void modifyEntry(String country, String newCapital) {
        if (atlas.containsKey(country)) {
            atlas.put(country, newCapital);
            System.out.println("Capital modificada");
        } else {
            System.out.println("El país no está en el atlas");
        }
    }

    // Ordenar por nombre de país
    public void sortEntries() {
        List<Map.Entry<String, String>> list = new ArrayList<>(atlas.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
        }
    }

    // Eliminar una entrada del atlas
    public void removeEntry(String country) {
        if (atlas.containsKey(country)) {
            atlas.remove(country);
            System.out.println(country + " eliminada del Atlas");
        } else {
            System.out.println("El país no está en el atlas");
        }
    }

    // Eliminar el contenido completo del atlas
    public void clearAtlas() {
        atlas.clear();
        System.out.println("Eliminado el Atlas por completo");
    }
}

public class Master {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Atlas atlas = new Atlas();
        int option;

        do {
            System.out.println("PROGRAMA ATLAS");
            System.out.println("1. Añadir una entrada al atlas              5. Ordenar por nombre de país");
            System.out.println("2. Mostrar el contenido actual del atlas    6. Mostrar el contenido del atlas con iterador");
            System.out.println("3. Buscar una entrada del atlas             7. Eliminar una entrada del atlas");
            System.out.println("4. Modificar una entrada del atlas          8. Eliminar el contenido completo del atlas");
            System.out.println("9. Salir");
            System.out.print("Teclea una de las opciones: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después de nextInt()

                switch (option) {
                    case 1:
                        System.out.print("Teclea un País: ");
                        String country = scanner.nextLine();
                        System.out.print("Teclea su Capital: ");
                        String capital = scanner.nextLine();
                        atlas.addEntry(country, capital);
                        break;
                    case 2:
                        atlas.displayEntries();
                        break;
                    case 3:
                        System.out.print("Teclea un País: ");
                        String searchCountry = scanner.nextLine();
                        atlas.searchEntry(searchCountry);
                        break;
                    case 4:
                        System.out.print("Teclea un País: ");
                        String modifyCountry = scanner.nextLine();
                        System.out.print("Teclea modificación de capital: ");
                        String newCapital = scanner.nextLine();
                        atlas.modifyEntry(modifyCountry, newCapital);
                        break;
                    case 5:
                        atlas.sortEntries();
                        break;
                    case 6:
                        atlas.displayEntries(); // Muestra el contenido del atlas de la misma manera que la opción 2
                        break;
                    case 7:
                        System.out.print("Teclea un País a eliminar: ");
                        String removeCountry = scanner.nextLine();
                        atlas.removeEntry(removeCountry);
                        break;
                    case 8:
                        atlas.clearAtlas();
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida, por favor ingresa un número del 1 al 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes teclear un número entero.");
                scanner.nextLine(); // Limpiar el búfer del scanner
                option = 0; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (option != 9);

        scanner.close();
    }
}
