package poblacion;

public class festividad implements Festivo{

    public Festivo nombreFiesta;
    private Festivo mes;

    public festividad(Festivo nombreFiesta, Festivo mes){
        this.nombreFiesta = nombreFiesta;
        this.mes = mes;
    }

    @Override
    public Festivo getNombreFiesta() {
        return nombreFiesta;
    }

    @Override
    public Festivo getMes() {
        return mes;
    }

    @Override
    public void setMes(Festivo mes1) {
        mes = mes1;
    }


}
