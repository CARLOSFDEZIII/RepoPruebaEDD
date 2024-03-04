package poblacion;

public class poblacion implements tipoPoblacion {

    private String nombre;
    private Integer numeroDeHabitantes;
    private Double superficie;
    private Integer numPersonasTrabajando;
    private Integer numPersonasEmpleadas;
    private Double porcentajeDeDesempleo;
    private Double densidadDePoblacion;
    public String nombreFiesta;
    private String mes;

    public poblacion(String nombre, Integer numeroDeHabitantes, Double superficie, Integer numPersonasTrabajando, Integer numPersonasEmpleadas, Double porcentajeDeDesempleo,Double densidadDePoblacion){
        this.nombre = nombre;
        this.numeroDeHabitantes = numeroDeHabitantes;
        this.superficie = superficie;
        this.numPersonasTrabajando = numPersonasEmpleadas;
        this.numPersonasEmpleadas = numPersonasEmpleadas;
        this.porcentajeDeDesempleo = porcentajeDeDesempleo;
        this.densidadDePoblacion = densidadDePoblacion;
    }



    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Integer getNumeroDeHabitantes() {
        return numeroDeHabitantes;
    }

    @Override
    public void setNumeroDeHabitantes(Integer habitantes) {
        numeroDeHabitantes = habitantes;
    }

    @Override
    public Double getSuperficie() {
        return superficie;
    }

    @Override
    public Integer getNumPersonasTrabajando() {
        return numPersonasTrabajando;
    }

    @Override
    public void setNumPersonasTrabajando(Integer numPersonasTrabajando1) {
        numPersonasTrabajando = numPersonasTrabajando1;

    }

    @Override
    public Integer getNumPersonasEmpleadas() {
        return numPersonasEmpleadas;
    }

    @Override
    public void setNumPersonasEmpleadas(Integer numPersonasEmpleadas1) {
        numPersonasEmpleadas = numPersonasEmpleadas1;
    }

    @Override
    public Double getPorcentajeDeDesempleo() {
        return porcentajeDeDesempleo;
    }

    @Override
    public void setPorcentajeDeDesempleo(Double porcentajeDeDesempleo) {
        this.porcentajeDeDesempleo = porcentajeDeDesempleo;
    }

    @Override
    public Double getDesidadDePoblacion() {
        return densidadDePoblacion;
    }

    @Override
    public void setDensidadDePoblacion(Double densidadDePoblacion) {
        this.porcentajeDeDesempleo = densidadDePoblacion;
    }

    public String getNombreFiesta() {
        return nombreFiesta;
    }


    public String getMes() {
        return mes.toString();
    }


    public void setMes(String mes1) {
        mes = mes1;
    }

    public String representacion(String nombreFiesta, String mes){
        this.nombreFiesta = nombreFiesta;
        this.mes = mes;
        return nombreFiesta + mes;
    }


    public String toString(){
        return nombre+" posee una densidad de población de " +densidadDePoblacion+ "hab/km2. Una de sus fiestas más famosas es " + representacion("La Feria ","de Abril");
    }


}
