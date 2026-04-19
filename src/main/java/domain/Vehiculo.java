package domain;

public abstract class Vehiculo {
    protected String patente;
    //protected String marca; Este lo borro y lo saco del constructor
    protected String modelo;
    protected int anio;
    protected double capacidadCarga;
    protected Sucursal sucursal;
    private VehiculoTipo tipo;
    private Marca marcaVehiculo; //Y voy  a dejar este

    public Vehiculo(Marca marcaVehiculo, VehiculoTipo tipo, String patente, String modelo, int anio, double capacidadCarga, Sucursal sucursal) {
        this.patente = patente; //CHECK
        this.modelo = modelo; //CHECK
        this.anio = anio; //CHECK
        this.capacidadCarga = capacidadCarga;//CHECK
        this.sucursal = sucursal; //CHECK
        this.tipo = tipo; //CHECK
        this.marcaVehiculo = marcaVehiculo; 
    }

    public Marca getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(Marca marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }
    
    public String getPatente() {
        return patente;
    }
    
    public VehiculoTipo getTipo(){
        return tipo;
    }
    
    public double getCapacidadCarga(){
        return capacidadCarga;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public String getCodigoSucursal(){
        return sucursal.getCodigo();
    }
    
    public double calcularConsumo(double kilometros) {
        return 0;
    }

    public boolean esDe(VehiculoTipo tipo){
        return this.tipo == tipo;
    }
    @Override
    public String toString() {
        return patente + " - " + marcaVehiculo.getNombre() + " " + modelo + " - Sucursal: " + sucursal.getCodigo();
    }
}