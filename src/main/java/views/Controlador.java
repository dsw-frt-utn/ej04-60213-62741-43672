package views;

import data.Persistencia;
import domain.Marca;
import domain.Sucursal;
import domain.Vehiculo;
import domain.VehiculoCombustible;
import domain.VehiculoElectrico;
import domain.VehiculoTipo;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Controlador {
    
    public static ArrayList<VehiculoViewModel> getVehiculos(){
        ArrayList<VehiculoViewModel> vehiculos = new ArrayList<>();
        for(Vehiculo vehiculo : Persistencia.getVehiculos()) {
            vehiculos.add(new VehiculoViewModel(vehiculo));
        }
        return vehiculos;
    }
    
    public static void agregarVehiculo(String patente, String tipo, String sucursal, String marca, String modelo, int anio, double capCarga, String pais, double kwhBase, double Lextra, double kmL){
        Vehiculo vehiculoAgregar;
        Marca marca1 = new Marca(marca, pais);
        Optional<Sucursal> sucur = Persistencia.getSucursal(sucursal);
        if(sucur.isPresent()){
            if(tipo.equals("ELECTRICO")){
                vehiculoAgregar = new VehiculoElectrico(patente, modelo, anio, capCarga, sucur.get(), kwhBase, marca1);
            }else{
                vehiculoAgregar = new VehiculoCombustible(patente, modelo, anio, capCarga, sucur.get(), kmL, Lextra, marca1);
            }
            Persistencia.insertarVehiculo(vehiculoAgregar);
        }else{
            System.out.println("Error al insertar sucursal");
        }
        
    }
    
    
    public static double[] calcularConsumos(Map<String, Double> vehiculos){
        double consumoElectricos = 0;
        double consumoCombustible= 0;
        for(Map.Entry<String, Double> entry : vehiculos.entrySet()){
           double consumo = 0;
           Optional<Vehiculo> vehiculo = Persistencia.getVehiculo(entry.getKey());
           if(vehiculo.isPresent()){
               consumo = vehiculo.get().calcularConsumo(entry.getValue());
               consumoElectricos += vehiculo.get().esDe(VehiculoTipo.ELECTRICO) ? consumo : 0;
               consumoCombustible += vehiculo.get().esDe(VehiculoTipo.COMBUSTIBLE) ? consumo : 0;
           }
        }
        return new double[] {consumoElectricos, consumoCombustible};
    }
    
    
}