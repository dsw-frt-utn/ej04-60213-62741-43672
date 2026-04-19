package domain;

public class VehiculoElectrico extends Vehiculo {
    private double kwhBase;

    public VehiculoElectrico(String patente, String modelo, int anio, double capacidadCarga,
                             Sucursal sucursal, double kwhBase, Marca marcaVehiculo) {
        super(marcaVehiculo, VehiculoTipo.ELECTRICO, patente, modelo, anio, capacidadCarga, sucursal);
        this.kwhBase = kwhBase;
    }

    @Override
    public double calcularConsumo(double kilometros) {
        double total = (kilometros/100) * kwhBase;

        if (capacidadCarga > 1200) {
            total = total * 1.15;
        }

        return total;
    }
}
