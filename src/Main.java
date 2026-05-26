import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook agenda = new AddressBook("contactos.txt");

        int opcion;

        do {
            System.out.println("===== ADDRESS BOOK =====");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();

                    Contact contacto = new Contact(nombre, telefono, correo);
                    agenda.agregarContacto(contacto);
                    break;

                case 2:
                    agenda.mostrarContactos();
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();

        } while (opcion != 3);

        scanner.close();
    }
}