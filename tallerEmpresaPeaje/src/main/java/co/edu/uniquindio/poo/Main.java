package co.edu.uniquindio.poo;

import co.edu.uniquindio.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear empresa
        System.out.println("=== Creando Empresa ===");
        Empresa empresa = new Empresa("AutoPistas del Café");
        
        // Crear peajes
        System.out.println("\n=== Creando Peajes ===");
        Peaje peaje1 = new Peaje("P001", "La Paila", "Valle");
        Peaje peaje2 = new Peaje("P002", "Circasia", "Quindío");
        empresa.addPeaje(peaje1);
        empresa.addPeaje(peaje2);
        System.out.println("Peajes creados: " + empresa.getListPeaje().size());

        // Crear recaudadores
        System.out.println("\n=== Creando Recaudadores ===");
        Recaudador recaudador1 = new Recaudador("1234", "Juan", "Pérez", 
            LocalDate.of(1990, 5, 15), 2000000);
        Recaudador recaudador2 = new Recaudador("5678", "María", "González", 
            LocalDate.of(1985, 8, 22), 2100000);
        empresa.addRecaudador(recaudador1);
        empresa.addRecaudador(recaudador2);
        System.out.println("Recaudadores creados: " + empresa.getListRecaudador().size());

        // Crear conductores
        System.out.println("\n=== Creando Conductores ===");
        Conductor conductor1 = new Conductor("9012", "Carlos", "Rodríguez", 
            LocalDate.of(1988, 3, 10));
        Conductor conductor2 = new Conductor("3456", "Ana", "Martínez", 
            LocalDate.of(1992, 7, 25));

        // Crear más conductores
        System.out.println("\n=== Creando Conductores Adicionales ===");
        Conductor conductor3 = new Conductor("7890", "Luis", "Sánchez", 
            LocalDate.of(1995, 4, 18));
        Conductor conductor4 = new Conductor("4321", "Patricia", "Ramírez", 
            LocalDate.of(1987, 11, 30));

        // Crear vehículos
        System.out.println("\n=== Creando Vehículos ===");
        Moto moto = new Moto("ABC123", 250);
        Carro carro = new Carro("XYZ789", true, false);
        Camion camion = new Camion("DEF456", (byte) 6, (byte) 60);

        // Crear más vehículos
        System.out.println("\n=== Creando Vehículos Adicionales ===");
        Moto moto2 = new Moto("DEF789", 300);
        Carro carro2 = new Carro("JKL456", false, true);
        Camion camion2 = new Camion("MNO123", (byte) 8, (byte) 80);
        Carro carro3 = new Carro("PQR789", true, true);

        // Asignar vehículos a conductores
        System.out.println("\n=== Asignando Vehículos a Conductores ===");
        conductor1.addVehiculo(moto);
        conductor1.addVehiculo(carro);
        conductor2.addVehiculo(camion);

        // Asignar vehículos a los nuevos conductores
        System.out.println("\n=== Asignando Vehículos a Nuevos Conductores ===");
        conductor3.addVehiculo(moto2);
        conductor3.addVehiculo(carro2);
        conductor4.addVehiculo(camion2);
        conductor4.addVehiculo(carro3);

        // Asignar conductores a vehiculos
        System.out.println("\n=== Asignando Vehículos a Conductores ===");
        moto.setTheConductor(conductor1);
        carro.setTheConductor(conductor1);
        camion.setTheConductor(conductor2);

        // Asignar conductores a los nuevos vehículos
        moto2.setTheConductor(conductor3);
        carro2.setTheConductor(conductor3);
        camion2.setTheConductor(conductor4);
        carro3.setTheConductor(conductor4);

        // Realizar cobros
        System.out.println("\n=== Realizando Cobros ===");
        Ticket ticket1 = recaudador1.Cobrar(moto, peaje1);
        Ticket ticket2 = recaudador1.Cobrar(carro, peaje1);
        Ticket ticket3 = recaudador2.Cobrar(camion, peaje2);

        // Realizar cobros adicionales
        System.out.println("\n=== Realizando Cobros Adicionales ===");
        Ticket ticket4 = recaudador1.Cobrar(moto2, peaje1);
        Ticket ticket5 = recaudador2.Cobrar(carro2, peaje2);
        Ticket ticket6 = recaudador1.Cobrar(camion2, peaje1);
        Ticket ticket7 = recaudador2.Cobrar(carro3, peaje2);

        // Mostrar información de los tickets
        System.out.println("\n=== Información de Cobros ===");
        System.out.println("Moto en peaje 1:");
        System.out.println(peaje1.calcularPasajeString(moto));
        System.out.println("\nCarro en peaje 1:");
        System.out.println(peaje1.calcularPasajeString(carro));
        System.out.println("\nCamión en peaje 2:");
        System.out.println(peaje2.calcularPasajeString(camion));

        // Mostrar información de los nuevos tickets
        System.out.println("\n=== Información de Cobros Adicionales ===");
        System.out.println("Moto 2 en peaje 1:");
        System.out.println(peaje1.calcularPasajeString(moto2));
        System.out.println("\nCarro 2 en peaje 2:");
        System.out.println(peaje2.calcularPasajeString(carro2));
        System.out.println("\nCamión 2 en peaje 1:");
        System.out.println(peaje1.calcularPasajeString(camion2));
        System.out.println("\nCarro 3 en peaje 2:");
        System.out.println(peaje2.calcularPasajeString(carro3));

        // Mostrar totales recaudados
        System.out.println("\n=== Totales Recaudados ===");
        System.out.println("Total recaudado peaje 1: " + peaje1.getTotalRecaudado());
        System.out.println("Total recaudado peaje 2: " + peaje2.getTotalRecaudado());
        System.out.println("Total empresa: " + empresa.getTotal());

        // Buscar conductor por nombre
        System.out.println("\n=== Búsqueda de Recaudador ===");
        Recaudador recaudadorEncontrado = empresa.buscarRecaudador("Juan", "Pérez");
        System.out.println("Recaudador encontrado: " + 
            (recaudadorEncontrado != null ? recaudadorEncontrado.getNombre() : "No encontrado"));

        // Listar camioneros con capacidad >= 50
        System.out.println("\n=== Lista de Camioneros (capacidad >= 50) ===");
        for (Conductor c : empresa.getCamioneros()) {
            if (c != null) {  // Verificación de nulidad
                System.out.println("Conductor: " + c.getNombre() + " " + c.getApellido());
            }
        }

        // Totalizar Peaje
        System.out.println("\n=== Totalizar Pasaje ===");
        System.out.println("\n=== Peaje 1===\n");
        System.out.println(peaje1.totalizar());
        System.out.println("\n=== Peaje 2===\n");
        System.out.println(peaje2.totalizar());

        // Totalizar Conductores
        System.out.println("\n=== Totalizar Conductores ===");
        System.out.println("\n=== Conductor 1===\n");
        System.out.println(conductor1.totalizar());
        System.out.println("\n=== Conductor 2===\n");
        System.out.println(conductor2.totalizar());

        // Totalizar para los nuevos conductores
        System.out.println("\n=== Totalizar Nuevos Conductores ===");
        System.out.println("\n=== Conductor 3 ===\n");
        System.out.println(conductor3.totalizar());
        System.out.println("\n=== Conductor 4 ===\n");
        System.out.println(conductor4.totalizar());

        // Buscar segun tipo de vehiculo
        System.out.println("\n=== Buscar segun tipo de vehiculo ===");
        System.out.println(conductor1.retornarListaVehiculo("moto").get(0).getPlaca());
        System.out.println(conductor1.retornarListaVehiculo("carro").get(0).getPlaca());


    }
}