package poblacion;

public interface tipoPoblacion {

    String getNombre();

    Integer getNumeroDeHabitantes();
    void setNumeroDeHabitantes(Integer habitantes);

    Double getSuperficie();

    Integer getNumPersonasTrabajando();
    void setNumPersonasTrabajando(Integer numPersonasTrabajando1);

    Integer getNumPersonasEmpleadas();
    void setNumPersonasEmpleadas(Integer numPersonasEmpleadas1);

    Double getPorcentajeDeDesempleo();
    void setPorcentajeDeDesempleo(Double porcentajeDeDesempleo);

    Double getDesidadDePoblacion();
    void setDensidadDePoblacion(Double densidadDePoblacion);

}
