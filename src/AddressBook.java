import java.io.*;
import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contactos;
    private String archivo;

    public AddressBook(String archivo) {
        this.archivo = archivo;
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contact contacto) {
        contactos.add(contacto);
        guardarContactos();
        System.out.println("Contacto guardado correctamente.");
    }

    public void mostrarContactos() {
        cargarContactos();

        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
        } else {
            System.out.println("===== LISTA DE CONTACTOS =====");
            for (Contact contacto : contactos) {
                contacto.mostrarContacto();
            }
        }
    }

    public void guardarContactos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Contact contacto : contactos) {
                writer.write(contacto.convertirTexto());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar contactos: " + e.getMessage());
        }
    }

    public void cargarContactos() {
        contactos.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    Contact contacto = new Contact(datos[0], datos[1], datos[2]);
                    contactos.add(contacto);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará al guardar un contacto.");
        } catch (IOException e) {
            System.out.println("Error al leer contactos: " + e.getMessage());
        }
    }
}
