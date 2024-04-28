package wiyu.barberia_poo.Clases;

/*
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class Servicio {
    
    public static int consecutivo = 1;
    private int codigo;
    private String tipo;
    private String descripcion;
    
    public Servicio (String tipo, String descripcion){
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.codigo = consecutivo;
        consecutivo++;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void modificarServicio(String tipo, String descripcion){
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        String result =  "Código del servicio: " + this.codigo +"\n";
        result +=  "Tipo: " + this.tipo +"\n";
        result += "Descripción: " + this.descripcion +"\n";
        return result;
    }
    
}
