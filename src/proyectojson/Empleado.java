/**
 *    DESARROLLO DE APLICACIONES MULTIPLATAFORMA
 *    PROGRAMACION DE SERVICIOS Y PROCESOS
 *    ACCESO A DATOS  
*/

package proyectojson;

public class Empleado {
    private final int id; 
    private final String nombre; 
    private final String empresa;    
 
    public Empleado(int id, String nombre, String empresa ) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
    }     

    public int getId() {
       return id;
    }

    public String getNombre() {
       return nombre;
    }

    public String getEmpresa() {
       return empresa;
    }
    public String toString(){
        return   id + "-" + nombre + "-" + empresa;
    }
}

