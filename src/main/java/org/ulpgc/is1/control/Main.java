package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.List;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        //i. Crear dos clientes. Deben controlar que no se añadan clientes repetidos.
        Customer customer1 = new Customer("Luis", "Garcia", new Phone("928467846"));
        Customer customer2 = new Customer("Sara", "Gil", new Phone("928111111"));
        manager.addCustomer(customer1);
        manager.addCustomer(customer2);

        //ii. Crear tres dispositivos. Asignarle los dos primeros dispositivos al primer cliente y el tercer dispositivo al segundo cliente. Deben controlar que no se añadan dispositivos repetidos.
        Device device1 = new Device("2758", DeviceType.SMARTPHONE, customer1);
        Device device2 = new Device("4574", DeviceType.LAPTOP, customer1);
        Device device3 = new Device("9867", DeviceType.TABLET, customer2);
        manager.addDevice(device1);
        manager.addDevice(device2);
        manager.addDevice(device3);

        //iii. Crear dos empleados. Deben controlar que no se añadan empleados repetidos.
        Employee employee1 = new Employee(1, "Manuel", "Gonzalez");
        Employee employee2 = new Employee(2, "Ana", "Perez");
        manager.addTechnician(employee1);
        manager.addTechnician(employee2);

        //iv. Crear un servicio tipo ‘Repair’ para el segundo dispositivo del primer cliente. El manager de este servicio será el segundo empleado. Este servicio se pagará posteriormente (pto. ‘vi’).

        manager.service(device2, ServiceType.REPAIR, "Broken screen", customer1, new Budget(new Date(), 150, employee2));
        Service service = device2.getServices().get(0);
        service.addTechnician(employee2);

        //v. Sobre el servicio anterior (pto. ‘iv’) se realizará dos trabajos que se asignará a cada uno de los dos empleados creados en el punto ‘iii’. Se debe utilizar el método ‘getServiceList’ de la clase de control.
        List<Device> repairDevices = manager.getDeviceServiceList(ServiceType.REPAIR);
        for (Device device : repairDevices) {
            if (device.getSerialNumber().equals(device2.getSerialNumber())) {
                // Recuperar el servicio correspondiente
                Service repairService = device.getServices().get(0);

                // Crear trabajos y asignarlos al servicio
                Work work1 = new Work(employee1, repairService, 2, "Desmontaje");
                Work work2 = new Work(employee2, repairService, 5, "Reparación y montaje");
                repairService.addWork(work1);
                repairService.addWork(work2);
            }
        }

        //vi. Pagar el servicio creado en el punto ‘iv’.
        Date paymentDate = new Date();
        int paymentAmount = 150;

        try {
            manager.payService(device2, service.getId(), paymentAmount, paymentDate);
        } catch (Exception e) {
            System.err.println("Error al pagar el servicio: " + e.getMessage());
        }

        //vii. Mostrar de forma clara los datos todos los servicios realizados al segundo dispositivo del primer cliente incluyendo todos sus datos asociados.
        displayServiceDetails(device2);
    }

    public static void displayServiceDetails(Device device) {
        System.out.println("**************************************************");
        System.out.println("Cliente " + device.getOwner().getName() + " " + device.getOwner().getSurname() +
                " (tlf.: " + device.getOwner().getPhone().getNumber() + ")");
        System.out.println("**************************************************\n");

        for (Service service : device.getServices()) {
            System.out.println("----------------------------------------");
            System.out.println("                Servicio (ref. " + service.getId() + ")");
            System.out.println("----------------------------------------\n");

            System.out.println("*) Datos del servicio:");
            System.out.println("|- Ref.: " + service.getId());
            System.out.println("|- Descripción: " + service.getDescription());
            System.out.println("|- Tipo: " + service.getType());
            if (service.getPayment() != null && service.getPayment().getAmount() > 0) {
                System.out.println("|- Información del pago: Pago { fecha del pago= " +
                        service.getPayment().getDate() + ", cantidad= " +
                        service.getPayment().getAmount() + " euros }");
            } else {
                System.out.println("|- Información del pago: Sin pagar");
            }

            System.out.println("\n*) Datos del dispositivo:");
            System.out.println("|- Serial Number: " + device.getSerialNumber());
            System.out.println("|- Tipo: " + device.getType() + "\n");

            if (service.getBudget() != null) {
                System.out.println("*) Datos del presupuesto:");
                System.out.println("|- Gestionado por: " + service.getBudget().getManager().getName() + " " +
                        service.getBudget().getManager().getSurname());
                System.out.println("|- Fecha: " + service.getBudget().getDate());
                System.out.println("|- Total: " + service.getBudget().getAmount());
            }

            System.out.println("\n----------------------------------------");
            System.out.println("        Tareas realizadas en el servicio");
            System.out.println("----------------------------------------");

            for (Work work : service.getWorks()) {
                System.out.println("Tarea { técnico=" + work.getTechnician().getName() + " " +
                        work.getTechnician().getSurname() + ", concepto='" + work.getDescription() +
                        "', tiempo invertido=" + work.getTimeSpent() + " }");
            }
            System.out.println();
        }
    }
}
