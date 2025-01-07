package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        //i. Crear dos clientes. Deben controlar que no se añadan clientes repetidos.
        Customer customer1 = new Customer("Luis", "Garcia", new Phone("928467846"));
        Customer customer2 = new Customer("Sara", "Gil", new Phone("928749274"));
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
        manager.service(device2, ServiceType.REPAIR, "Broken screen", customer1);
        Service service = device2.getServices().get(0);
        service.addTechnician(employee2);

        //v. Sobre el servicio anterior (pto. ‘iv’) se realizará dos trabajos que se asignará a cada uno de los dos empleados creados en el punto ‘iii’. Se debe utilizar el método ‘getServiceList’ de la clase de control.



        //vi. Pagar el servicio creado en el punto ‘iv’.
        //vii. Mostrar de forma clara los datos todos los servicios realizados al segundo dispositivo del primer cliente incluyendo todos sus datos asociados.

    }
}
