package wiyu.barberia_poo.Clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/*
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class Cita implements Serializable{
    public static int consecutivo = 1;
    private int codigo;
    private LocalDate dia;
    private LocalTime horaInicial;
    private Servicio servicio;
    private Cliente cliente;
    private boolean confirmada;

    public Cita(Cliente cliente, LocalDate dia, LocalTime horaInicial, Servicio servicio) {
        this.dia = dia;
        this.cliente = cliente;
        this.horaInicial = horaInicial;
        this.servicio = servicio;
        this.codigo = consecutivo;
        this.confirmada = false;
        consecutivo++;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo(){
        return codigo;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
    
    public LocalDate getDia() {
        return dia;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }
    
    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getHorario(){
        return this.dia.toString() + this.horaInicial;
    }
    
    public boolean getConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }
    
    public int modificarCita(LocalDate dia, LocalTime hora, Servicio servicio) {
        this.dia = dia;
        this.horaInicial =hora;
        this.servicio = servicio;
        return this.codigo;
    }
    
    @Override
    public String toString(){
        String datos = "Código de cita: " + this.codigo + "\n";
        datos += "Código del cliente: " + this.getCliente().getCodigo() + "\n";
        datos += "Servicio de cita: " + this.servicio.toString() + "\n";
        datos += "Día de cita: " + this.dia + "\n";
        datos += "Hora inicial de la cita: " + this.horaInicial + "\n";
        return datos;
    }

}
