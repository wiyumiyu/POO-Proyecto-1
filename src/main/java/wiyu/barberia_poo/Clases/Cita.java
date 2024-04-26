package wiyu.barberia_poo.Clases;

/*
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class Cita {
    public static int consecutivo = 1;
    private int codigo;
    private String dia;
    private int horaInicial;
    private Servicio servicio;
    private int codigoCliente;

    public Cita(int codigoCliente, String dia, int horaInicial, Servicio servicio) {
        this.dia = dia;
        this.codigoCliente = codigoCliente;
        this.horaInicial = horaInicial;
        this.servicio = servicio;
        this.codigo = consecutivo;
        consecutivo++;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    public String getHorario(){
        return dia + horaInicial;
    }
    public int getCodigo(){
        return codigo;
    }
    public int modificarCita(String dia, int hora, Servicio servicio) throws Exception{
        this.setDia(dia);
        this.setHoraInicial(hora);
        this.setServicio(servicio);
        return this.getCodigo();
    }
    @Override
    public String toString(){
        String datos = "Código de cita: " + codigo + "\n";
        datos += "Código del cliente: " + codigoCliente + "\n";
        datos += "Servicio de cita: " + servicio.toString() + "\n";
        datos += "Día de cita: " + dia + "\n";
        datos += "Hora inicial de la cita: " + horaInicial + "\n";
        return datos;
    }
}
