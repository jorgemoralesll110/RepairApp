package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ServiceManager serviceManager = new ServiceManager();

        // i. Crear dos clientes
        Customer customer1 = new Customer("Antonio", "García González", new Phone("928112233"));
        Customer customer2 = new Customer("María", "Pérez López", new Phone("928445566"));

        serviceManager.addCustomer(customer1);
        serviceManager.addCustomer(customer2);

        // ii. Crear tres dispositivos
        Device device1 = new Device("1234-5678", DeviceType.TABLET, customer1);
        Device device2 = new Device("5678-1234", DeviceType.LAPTOP, customer1);
        Device device3 = new Device("9876-5432", DeviceType.SMARTPHONE, customer2);

        serviceManager.addDevice(device1);
        serviceManager.addDevice(device2);
        serviceManager.addDevice(device3);

        // iii. Crear dos empleados
        Employee employee1 = new Employee(1, "Antonio", "García González");
        Employee employee2 = new Employee(2, "José", "Rodríguez Pérez");

        serviceManager.addTechnician(employee1);
        serviceManager.addTechnician(employee2);

        // iv. Crear un servicio tipo ‘Repair’ para el segundo dispositivo del primer cliente
        String serviceDescription = "Arreglo del portátil";
        serviceManager.service(device2, ServiceType.REPAIR, serviceDescription);

        // Asociar el empleado 2 como técnico del servicio
        Service service = device2.getServices()[0];
        service.addTechnician(employee2);

        // v. Asignar dos trabajos al servicio
        Work work1 = new Work(2, "Desmontaje");
        Work work2 = new Work(5, "Reparación y montaje");

        service.addTechnician(employee1);

        // vi. Pagar el servicio creado en el punto iv
        Payment payment = new Payment(new Date(), 100);
        service.pay(payment);

        // vii. Mostrar los datos como en las imágenes proporcionadas
        printServiceDetails(customer1, device2, service, payment, employee1, employee2, work1, work2);
        printServiceDetails(customer2, device3, service, payment, employee1, employee2, work1, work2);
    }

    private static void printServiceDetails(Customer customer, Device device, Service service, Payment payment,
                                            Employee employee1, Employee employee2, Work work1, Work work2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Encabezado del cliente
        System.out.println("**************************************************");
        System.out.println("Cliente " + customer.getName() + " " + customer.getSurname() + " (tlf.: " + customer.getPhone().getNumber() + ")");
        System.out.println("**************************************************");

        // Detalles del servicio
        System.out.println("\n----------------------------------------");
        System.out.println("Servicio (ref. " + service.getId() + ")");
        System.out.println("----------------------------------------");
        System.out.println("*) Datos del servicio:");
        System.out.println("|- Ref.: " + service.getId());
        System.out.println("|- Descripción: " + service.getDescription());
        System.out.println("|- Tipo: " + service.getType());
        System.out.println("|- Información del pago: Pago { fecha del pago= " + dateFormat.format(payment.getDate())
                + ", cantidad= " + payment.getAmount() + " euros }");

        // Detalles del dispositivo
        System.out.println("\n*) Datos del dispositivo:");
        System.out.println("|- Serial Number: " + device.getSerialNumber());
        System.out.println("|- Tipo: " + device.getType());

        // Detalles del presupuesto
        System.out.println("\n*) Datos del presupuesto:");
        System.out.println("|- Gestionado por: " + employee2.getName() + " " + employee2.getSurname());
        System.out.println("|- Fecha: " + dateFormat.format(payment.getDate()));
        System.out.println("|- Total: " + payment.getAmount());

        // Tareas realizadas en el servicio
        System.out.println("\n----------------------------------------");
        System.out.println("Tareas realizadas en el servicio");
        System.out.println("----------------------------------------");
        System.out.println("Tarea { técnico =" + employee1.getName() + " " + employee1.getSurname() +
                ", concepto='" + work1.getDescription() + "', tiempo invertido =" + work1.getTimeSpent() + " }");
        System.out.println("Tarea { técnico =" + employee2.getName() + " " + employee2.getSurname() +
                ", concepto='" + work2.getDescription() + "', tiempo invertido =" + work2.getTimeSpent() + " }");
    }
}
