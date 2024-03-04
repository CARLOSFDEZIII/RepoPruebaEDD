public class Dron extends Aeronave {
    public Dron(String codigo, String fechaEntrega, String montaje, Integer horasPrevistas, Integer horasTrabajo, Integer pasajeros, Float coste, Float precioVenta) {
        super(codigo, fechaEntrega, montaje, horasPrevistas, horasTrabajo, pasajeros, coste, precioVenta);
    }

    public void propul() {
        System.out.println("\t\tEsta aeronave utiliza electricidad.\n");
    }
}
