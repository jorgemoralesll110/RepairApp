package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceManager serviceManager = new ServiceManager();

        // i. Crear dos clientes. Deben controlar que no se añadan clientes repetidos.
        Customer customer1 = new Customer("Jorge", "Morales", new Phone("928123456"));
        Customer customer2 = new Customer("Raquel", "Almeida", new Phone("928654321"));
        serviceManager.addCustomer(customer1);
        serviceManager.addCustomer(customer2);

        // ii. Crear tres dispositivos. Asignarle los dos primeros dispositivos al primer cliente y el tercer dispositivo al segundo cliente. Deben controlar que no se añadan dispositivos repetidos.
        Device device1 = new Device("4648-2458", DeviceType.DESKTOP, customer1);
        Device device2 = new Device("7658-1457", DeviceType.LAPTOP, customer1);
        Device device3 = new Device("9874-6541", DeviceType.TABLET, customer2);
        serviceManager.addDevice(device1);
        serviceManager.addDevice(device2);
        serviceManager.addDevice(device3);

        // iii. Crear dos empleados. Deben controlar que no se añadan empleados repetidos.
        Employee employee1 = new Employee(1, "Martín", "García");
        Employee employee2 = new Employee(2, "María", "González");
        serviceManager.addTechnician(employee1);
        serviceManager.addTechnician(employee2);

        // iv. Crear un servicio tipo ‘Repair’ para el segundo dispositivo del primer cliente. El manager de este servicio será el segundo empleado. Este servicio se pagará posteriormente (pto. ‘vi’).
        Service service = serviceManager.service(device2, ServiceType.REPAIR, "Pantalla rota");
        Budget budget = new Budget(new Date(), 100);
        budget.setManager(employee2);

        // v. Sobre el servicio anterior (pto. ‘iv’) se realizará dos trabajos que se asignarán a cada uno de los dos empleados creados en el punto ‘iii’. Se debe utilizar el método ‘getServiceList’ de la clase de control.
        List<Service> services = serviceManager.getDeviceServiceList(device2);
        if (!services.isEmpty()) {
            Service targetService = services.get(0);

            Work work1 = new Work(3, "Quitar pantalla");
            Work work2 = new Work(7, "Limpiar y montar la nueva pantalla");

            targetService.addWork(employee1, work1);
            targetService.addWork(employee2, work2);
        }

        // vi. Pagar el servicio creado en el punto 'iv'
        serviceManager.payService(device2, service.getId(), budget.getAmount(), budget.getDate());

        // vii. Mostrar de forma clara los datos todos los servicios realizados al segundo dispositivo del primer cliente incluyendo todos sus datos asociados.
        List<Service> secondDispositiveService = serviceManager.getDeviceServiceList(device2);
        for (Service s : secondDispositiveService) {
            printServiceDetails(s, device2, budget);
        }
    }

    private static void printServiceDetails(Service s, Device device2, Budget budget) {
        System.out.println("*********************************************");
        System.out.println("Cliente Antonio García González (tlf.: 928112233)");
        System.out.println("*********************************************");
        System.out.println("\n--------------------------------------------");
        System.out.println("             Servicio (ref. " + s.getId() + ")");
        System.out.println("--------------------------------------------");
        System.out.println("\n*) Datos del servicio:");
        System.out.println("   |- Ref.: " + s.getId());
        System.out.println("   |- Descripción: " + s.getDescription());
        System.out.println("   |- Tipo: " + s.getType());
        System.out.println("   |- Información del pago: Pago { fecha del pago= " + new Date() + ", cantidad= 100 euros }");

        System.out.println("\n*) Datos del dispositivo:");
        System.out.println("   |- Serial Number: " + device2.getSerialNumber());
        System.out.println("   |- Tipo: " + device2.getType());

        System.out.println("\n*) Datos del presupuesto:");
        System.out.println("   |- Gestionado por: " + budget.getManager().getName() + " " + budget.getManager().getSurname());
        System.out.println("   |- Fecha: " + budget.getDate());
        System.out.println("   |- Total: " + budget.getAmount());

        System.out.println("\n--------------------------------------------");
        System.out.println("        Tareas realizadas en el servicio");
        System.out.println("--------------------------------------------");

        for (Work work : service.getWorks()) {
            System.out.println("Tarea { técnico=" + work.getTechnician().getName() + " " + work.getTechnician().getSurname()
                    + ", concepto='" + work.getDescription()
                    + "', tiempo invertido =" + work.getTimeSpent() + " }");
        }
    }
    }

}