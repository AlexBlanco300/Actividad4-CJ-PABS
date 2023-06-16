import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class AdressBook {
//    public String numeroContacto;
//    public String nombreContacto;

//    AdressBook(String numero, String nombre){
//        this.numeroContacto = numero;
//        this.nombreContacto = nombre;
//    }

    protected HashMap<String,String> agendaHM = new HashMap<>();

    public void agregarContacto( String num, String nom ){
        agendaHM.put(num, nom);
        System.out.println("Contacto agregado exitosamente");
    }
    public void mostrarContactos(){
        System.out.println("Contactos:");
        if ( agendaHM.size() == 0 ){
            System.out.println("La agenda telefónica está vacía");
        } else {
            for( String llave:agendaHM.keySet() ) {
                String valor = agendaHM.get(llave);
                System.out.println(llave + " : " + valor);
            }
        }
    }
    public void borrarContacto(String llaveNum){
        if ( agendaHM.containsKey(llaveNum) ){
            agendaHM.remove(llaveNum);
            System.out.println("Contacto borrado exitosamente");
        } else {
            System.out.println("El número escrito no existe en la agenda");
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        String opcion = "";
        String resp   = "";
        BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
        AdressBook agendaTel = new AdressBook();

        System.out.println("Bienvenido a la Agenda teléfonica en Consola!");
        System.out.println("Elige una opción:");

        do {
            System.out.println("1- Mostrar contactos\n2- Guardar nuevo contacto\n3- Borrar contacto");
            opcion = br.readLine();
            switch ( opcion ) {
                case "1":
                    agendaTel.mostrarContactos();
                    break;
                case "2":
                    System.out.println("Escribe el Número del nuevo contacto;");
                    String num = br.readLine();
                    System.out.println("Escribe el Nombre del nuevo contacto;");
                    String nom = br.readLine();

                    agendaTel.agregarContacto(num,nom);
                    break;
                case "3":
                    if (agendaTel.agendaHM.size() == 0){
                        System.out.println("La agenda telefónica está vacía");
                    } else {
                        System.out.println("Escribe el número a borrar de la agenda telefónica:");
                        String numBorrar = br.readLine();
                        agendaTel.borrarContacto(numBorrar);
                    }
                    break;
                default:
                    System.out.println("La opción elegida no es válida.");
                    break;
            }

            System.out.println("Deseas ejecutar otra acción? (S/s para mostrar menú nuevamente o presiona cualquier otra tecla para salir)");
            resp = br.readLine();
        } while( resp.equals("S") || resp.equals("s") );

        System.out.println("Saliendo de la ejecución del programa...");
        System.out.println("Fin del programa.");
    }
}