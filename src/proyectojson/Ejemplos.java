/**
 *    DESARROLLO DE APLICACIONES MULTIPLATAFORMA
 *    PROGRAMACION DE SERVICIOS Y PROCESOS
 *    ACCESO A DATOS  
*/
/** 
 * JSON (JavaScript Object Notation) es un formato de intercambio de información que está basado en
 * estructuras de pares clave-valor. Es un formato mucho más ligero que XML y más indicado que éste 
 * en determinados escenarios (ojo!!! que no estoy diciendo que sea mejor, simplemente son distintos).
*/
package proyectojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;


public class Ejemplos {
     public static void main(String[] args) {
         //debeDevolverJSONEnUnProperties();
         //debeDevolverJSONEnUnObjeto();
         //debeDevolverLaRepresentacionJSONDeUnObjeto();
         //debeDevolverLaRepresentacionJSONDeUnObjetoDeFormaBonita();
         debeDevolerLaRepresentacionJSONEnUnaListaDeObjetos();
     }
    //1. Deserializando JSON a un objeto Properties.
    /* 
        {
            "id" : 46,
            "nombre": "Miguel",
            "empresa": "Autentia"
        }
    */
    public static void debeDevolverJSONEnUnProperties() {

        final String json = "{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}";
        final Gson gson = new Gson();
        final Properties properties = gson.fromJson(json, Properties.class);
        
        System.out.println( properties.getProperty("id"));
        System.out.println( properties.getProperty("nombre"));
        System.out.println( properties.getProperty("empresa"));
        System.out.println( properties.getProperty("propiedadInexistente"));
       
    }
    //2. Deserializando JSON a un objeto propio.
    public static void debeDevolverJSONEnUnObjeto() {
        final String json = "{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}";
        final Gson gson = new Gson();
        final Empleado empleado = gson.fromJson(json, Empleado.class);
        System.out.println( empleado.getId());
        System.out.println( empleado.getNombre());
        System.out.println( empleado.getEmpresa());
    }
    
    //3. Serializando nuestro objeto propio en JSON.
    public static void debeDevolverLaRepresentacionJSONDeUnObjeto() {
        final Empleado empleado = new Empleado(46, "Miguel", "Autentia");
        final Gson gson = new Gson();
        final String representacionJSON = gson.toJson(empleado);
        System.out.println( representacionJSON);
    }
    //4. Serializando nuestro objeto propio en JSON "bonito".
    public static void debeDevolverLaRepresentacionJSONDeUnObjetoDeFormaBonita() {
        final Empleado empleado = new Empleado(46, "Miguel", "Autentia");
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        final String representacionBonita = prettyGson.toJson(empleado);
        System.out.println( representacionBonita);
    }
    //5. Deserializando JSON en una lista de objetos propios.
    /*
    [
        {
            "id" : 46,
            "nombre": "Miguel",
            "empresa": "Autentia"
        },
        {
            "id" : 76,
            "nombre": "CR7",
            "empresa": "Real Madrid C.F"
        }
    ]
    */
    public static void debeDevolerLaRepresentacionJSONEnUnaListaDeObjetos() {
        final String empleado1JSON = "{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}";
        final String empleado2JSON = "{\"id\":76,\"nombre\":\"CR7\",\"empresa\":\"Real Madrid C.F\"}";
        final String empleadosJSON = "[" + empleado1JSON + "," + empleado2JSON + "]";
        final Gson gson = new Gson();
        /*
        La única diferencia es que ahora el segundo parámetro del método fromJSON 
        no es la clase a la que queremos deserializar el objeto JSON sino un objeto Type 
        (java.lang.reflect.Type) que habremos creado mediante TypeToken. Al crear una instancia de TypeToken,
        lo tipamos con la lista de "Empleado", invocamos a su método getType y ya tenemos nuestra instancia de Type.
        */
        final Type tipoListaEmpleados = new TypeToken<List<Empleado>>(){}.getType();//java.lang.reflect.Type//import com.google.gson.reflect.TypeToken;
        final List<Empleado> empleados = gson.fromJson(empleadosJSON, tipoListaEmpleados);
 
        System.out.println("Numero de empleados: " + empleados.size());
        final Empleado empleado1 = empleados.get(0);
        final Empleado empleado2 = empleados.get(1);
        System.out.println( empleado1.getId());
        System.out.println( empleado1.getNombre());
        System.out.println( empleado1.getEmpresa());
        System.out.println( empleado2.getId());
        System.out.println( empleado2.getNombre());
        System.out.println( empleado2.getEmpresa());
    }
    
}
