public class Cohete extends Aeronave {
    public Cohete(String codigo, String fechaEntrega, String montaje, Integer horasPrevistas, Integer horasTrabajo, Integer pasajeros, Float coste, Float precioVenta) {
        super(codigo, fechaEntrega, montaje, horasPrevistas, horasTrabajo, pasajeros, coste, precioVenta);
    }

    public void propul() {
        System.out.println("\t\tEsta aeronave utiliza propergol sólido.\n");
    }
}
