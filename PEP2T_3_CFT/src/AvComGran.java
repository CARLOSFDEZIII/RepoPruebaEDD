public class AvComGran extends Aeronave {
    public AvComGran(String codigo, String fechaEntrega, String montaje, Integer horasPrevistas, Integer horasTrabajo, Integer pasajeros, Float coste, Float precioVenta) {
        super(codigo, fechaEntrega, montaje, horasPrevistas, horasTrabajo, pasajeros, coste, precioVenta);

    }
    public void propul() {
        System.out.println("\t\tEsta aeronave utiliza queroxeno.\n");
    }
}
