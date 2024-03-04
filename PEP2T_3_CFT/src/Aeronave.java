// Importamos los paquetes necesarios

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Aeronave {

    // Declaramos las variables
    public final String negrita = "\033[0;1m";
    public final String reset = "\033[0m";
    private final String codigo;
    private final String fechaEntrega;
    private final String montaje;
    private final Integer horasPrevistas;
    private final Integer horasTrabajo;
    private final Integer pasajeros;
    private final Float coste;
    private final Float precioVenta;
    private DecimalFormat moneda = new DecimalFormat("###,###.##€");
    private DecimalFormat horas = new DecimalFormat("###,###");

    // Creamos el método constructor
    public Aeronave(String codigo, String fechaEntrega, String montaje, Integer horasPrevistas, Integer horasTrabajo, Integer pasajeros, Float coste, Float precioVenta) {
        this.codigo = codigo;
        this.fechaEntrega = fechaEntrega;
        this.montaje = montaje;
        this.horasPrevistas = horasPrevistas;
        this.horasTrabajo = horasTrabajo;
        this.pasajeros = pasajeros;
        this.coste = coste;
        this.precioVenta = precioVenta;
    }

    // declaramos los dos siguientes métodos set para que nos devuelva el valor de la moneda y horas
    public DecimalFormat setMoneda(DecimalFormat moneda){
        this.moneda = moneda;
        return moneda;
    }

    public DecimalFormat setHoras(DecimalFormat horas){
        this.horas = horas;
        return horas;
    }

    // Creamos los métodos get
    public String getFechaEntrega(){ return fechaEntrega;}
    public Integer getHorasTrabajo(){ return horasTrabajo;}
    public Integer getPasajeros(){return pasajeros;}
    public Float getCoste(){return coste;}
    public Float getPrecioVenta(){return precioVenta;}
    public DecimalFormat getMoneda(){return moneda;}
    public DecimalFormat getHoras(){return horas;}
    public Integer getHorasPrevistas() {return horasPrevistas;}
    public String getMontaje() {return montaje;}
    public String getCodigo() {return codigo;}

    // Método que camnbia el formato de la fecha introducida de meses-dias-años a dias-meses-años
    private String formadate() {
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formato = LocalDate.parse(getFechaEntrega(),formato1);
        return formato2.format(formato);
    }

    // Método que nos imprime la primera frase
    private void fechaEntrega(Aeronave aeronave, int elemento){
        // Declaramos las variables
        String nombre = aeronave.getClass().getSimpleName(); // Nos guarda en la variable nombre, el nombre de la clase del objeto
        String frase1 = "\nEsta fábrica construyó su primera aeronave, un";
        String frase2 = "Después construyó un";

        // Si es la primera vez que se llama al método y el nombre de la clase es femenino, nos imprime frase1 con una a concatenada
        if (elemento == 0 && nombre.endsWith("a")) { System.out.printf(frase1 + "a " + negrita + nombre + reset + ", el " + formadate() + ".\n");
            // Si es la primera vez que se llama al método y el nombre de la calse del onjeto es masculino no nos concatena la a
        } else if (elemento == 0) { System.out.printf(frase1 +" " + negrita + nombre + reset + ", el " + formadate() + ".\n");}

        // Si no es la primera vez que se llama a este método entramos en esta condición, que sigue controlando el tema del género de la clase del objeto
        if (elemento > 0) {
            if (nombre.endsWith("a")) {System.out.printf(frase2 + "a " + negrita + nombre + reset + " el " + formadate() + " para " + getPasajeros() + " pasajeros.\n");
            } else{
                String frase3 = (frase2 + " " + negrita + nombre + reset + " el " + formadate());
                // Si la clase es Cohete o Dron no nos imprimirá el número de pasajeros ya que no tiene
                if (nombre.equals("Cohete") || nombre.equals("Dron")) {
                    System.out.printf(frase3 + ".\n");
                } else{System.out.printf(frase3 + " para " + getPasajeros() + " pasajeros.\n");}
            }
        }
    }

    // Método que nos imprime la segunda frase
    private void horasBenef(){
        System.out.printf("\tEsto supuso " + getHorasTrabajo() + " horas de trabajo generando un beneficio de "
                + setMoneda(getMoneda()).format(getPrecioVenta()-getCoste()) + ".\n");
    }

    // Este método llama a propul de cada clase
    public void propul(){
    }

    // Este método nos imprime la frase que imprime solo las horas totales de avioneta
    protected void totalHoras(Avioneta avioneta1, Avioneta avioneta2){
        System.out.println("El total de horas de trabajo empleadas en el tipo "+ negrita + getClass().getSimpleName() + reset
                +" fueron: " + setHoras(getHoras()).format(avioneta1.getHorasTrabajo()+avioneta2.getHorasTrabajo()));
    }

    // Método que pide como parametro la tabla y la recorre para sumar los precio de ventas
    protected void facturacion(ArrayList<Aeronave> aeronave){
        Float factTotal = (float) 0;
        for(Aeronave miaeronave : aeronave) {
            factTotal += miaeronave.getPrecioVenta();
        }
        System.out.println("La facturación total de la compañía a día de hoy: " + setMoneda(getMoneda()).format(factTotal) + ".");
    }

    public static void  main(String[] args){
        // Declaramos la tabla llamada aeronave en la que le introduciremos objetos
        ArrayList<Aeronave> aeronave = new ArrayList<>();
        // Declaramaos los objetos con los datos
        AvComGran miavcomgran1 = new AvComGran( "ACG01" , "04-02-2008" , "L2GA" , 63545 , 4895 , 230 , 1200000F, 6000000F );
        AvComGran miavcomgran2 = new AvComGran( "ACG02" , "05-06-2012" , "L2GA" , 92875 , 6743 , 250 , 1500000F, 6500000F );
        AvComMed miavcommed1  = new AvComMed( "ACM01" , "10-28-2008" , "L2GA" , 34585 , 22785 , 120 , 2000000F, 4500000F );
        AvComMed miavcommed2  = new AvComMed( "ACM02" , "04-02-2018" , "L2GA" , 34647 , 20944 , 160 , 3000000F , 5000000F );
        Avioneta miavioneta1  = new Avioneta( "AV001" , "03-10-2008" , "L2GA" , 11191 , 2500 , 8 , 50000F , 200000F );
        Avioneta miavioneta2  = new Avioneta( "AV002" , "03-28-2010" , "L2GA" , 95952 , 1234 , 10 , 70000F , 250000F );
        Cohete micohete1    = new Cohete( "CH001" , "09-14-2022" , "L2GA" , 87452 , 22785 , 0 , 2000000F , 4500000F );
        Cohete micohete2    = new Cohete( "CH002" , "02-22-2017" , "L2GA" , 11651 , 23290 , 0 , 3000000F , 5000000F );
        Dron midron1      = new Dron( "DR001" , "02-02-2008" , "L2GA" , 11919 , 205 , 0 , 300F , 3000F );
        Dron midron2      = new Dron( "DR002" , "01-18-2012" , "L2GA" , 8745 , 300 , 0 , 500F , 4000F );
        Jet mijet1       = new Jet( "JE001" , "05-22-2008" , "L2GA" , 23476 , 10550 , 6 , 250000F , 1000000F );
        Jet mijet2       = new Jet( "JE002" , "12-13-2015" , "L2GA" , 49586 , 24089 , 9 , 550000F , 1600000F );

        aeronave.add (miavcomgran1);
        aeronave.add (miavcomgran2);

        aeronave.add (miavcommed1);
        aeronave.add (miavcommed2);

        aeronave.add (miavioneta1);
        aeronave.add (miavioneta2);

        aeronave.add (micohete1);
        aeronave.add (micohete2);

        aeronave.add (midron1);
        aeronave.add (midron2);

        aeronave.add (mijet1);
        aeronave.add (mijet2);
        // ordenamos la tabla de manera que en la primeras posiciones aparecerán los que tienen las fechas más antiguas
        aeronave.sort(Comparator.comparing(e-> LocalDate.parse(e.getFechaEntrega(), DateTimeFormatter.ofPattern("MM-dd-yyyy"))));
        System.out.printf("%-20s %-1s", "\n", "\033[0;1m" + "\033[04m" + "PROGRAMA AERONAVES" + "\033[0m" + "\n");

        int i = 0;
        for (Aeronave miaeronave : aeronave) {
            miaeronave.fechaEntrega(miaeronave,i);
            miaeronave.horasBenef();
            miaeronave.propul();
            i++;
        }
        miavioneta1.totalHoras(miavioneta1, miavioneta2);
        midron1.facturacion(aeronave);
    }


}

