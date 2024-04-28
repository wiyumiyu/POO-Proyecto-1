package wiyu.barberia_poo.Clases;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/*
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class Administrador {
    final ArrayList<Cliente> clientes;
    final ArrayList<Cita> citas;
    final ArrayList<Servicio> servicios;
    final ArrayList<Cliente> listaDeEspera;
    final ArrayList<HorarioDia> listaHorariosDia;
    
    public Administrador(){
        this.clientes = new ArrayList();
        this.citas = new ArrayList();
        this.servicios = new ArrayList();
        this.listaDeEspera = new ArrayList();        
        this.listaHorariosDia = new ArrayList();

    }
    private Cliente obtenerCliente(int codigoCliente){
        for (Cliente cliente : clientes){
            if (cliente.getCodigo() == codigoCliente)
                return cliente;
        }
        return null;
    }
    private Cita obtenerCita(int codigoCita){
        for (Cita cita : citas){
            if (cita.getCodigo() == codigoCita)
                return cita;
        }
        return null;
    }
    private Servicio obtenerServicio(int codigoServicio){
        for (Servicio servicio : servicios){
            if (servicio.getCodigo() == codigoServicio)
                return servicio;
        }
        return null;
    }
    public int crearCliente(String nombre, String email, String telefono) throws Exception{
        //verifica que el cliente no exista en el sistema
        for (Cliente cliente : clientes){
            if (cliente.getNombre().equals(nombre) && cliente.getCorreo().equals(email) && cliente.getTelefono().equals(telefono))
                throw new Exception("El cliente ya se encuentra registrado");
        }
        
        //Registra el cliente
        Cliente cliente = new Cliente(nombre, telefono, email);
        clientes.add(cliente);
        return cliente.getCodigo();
    }
    public void modificarCliente(int codigoCliente, String nombre, String telefono, String correo) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente);
        cliente.modificarCliente(nombre, telefono, correo);
    }
    public void borrarCliente(int codigoCliente) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente);
        if (cliente == null)
            throw new Exception("Cliente no existente");
        clientes.remove(cliente);
    }
    public String consultarCliente(int codigoCliente) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente);
        if (cliente == null)
            throw new Exception("Cliente no existente");
        return cliente.toString();
    }
    private HorarioDia obtenerHorario(DayOfWeek dia, LocalTime hora){ 
        for (HorarioDia horario : listaHorariosDia){
            if (horario.getDia().equals(dia)){
                if(hora.getHour() >= horario.getInicio().getHour() && hora.getHour() < horario.getFin().getHour()){
                    return horario;
                }
            }
        }
        return null;
    }
    
    public int crearCita(int codigoCliente, LocalDate dia, LocalTime hora, int codigoServicio) throws Exception{
        //validar que el dia y la hora este dentro del horario de atencion
        //https://www.baeldung.com/java-get-day-of-week
        //getDayOfWeek obtiene el dia de la semana para verificar si ese dia es parte 
        //del horario disponible
        HorarioDia horario = obtenerHorario(dia.getDayOfWeek(), hora); 
        if (horario == null)
            throw new Exception("El día y hora seleccionados no pertenecen al horario de trabajo");
        //validar que el dia y hora no este ocupada en otra cita
        for (Cita cita : citas){
            if (cita.getDia() == dia && cita.getHoraInicial() == hora){
                throw new Exception("Ya existe una cita en el día y hora seleccionados");
            }
        }
        Cliente cliente = obtenerCliente(codigoCliente);
        if (cliente == null)
            throw new Exception("Cliente no existente");
        Cita cita = new Cita(cliente, dia, hora, obtenerServicio(codigoServicio));        
        citas.add(cita);
        return cita.getCodigo();
    }
    public void modificarCita(int codigoCita, LocalDate dia, LocalTime hora, Servicio servicio) throws Exception{
        //validar que el dia y la hora este dentro del horario de atencion
        HorarioDia horario = obtenerHorario(dia.getDayOfWeek(), hora); 
        if (horario == null)
            throw new Exception("El día y hora seleccionados no pertenecen al horario de trabajo");
        //validar que el dia y hora no este ocupada en otra cita
        for (Cita cita : citas){
            if (cita.getDia() == dia && cita.getHoraInicial() == hora && cita.getCodigo() != codigoCita){
                throw new Exception("Ya existe una cita en el día y hora seleccionados");
            }
        }
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        cita.modificarCita(dia, hora, servicio);
    }
    public void borrarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        citas.remove(cita);
    }
    public String consultarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        return cita.toString();
    }
    
    public void confirmarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        cita.setConfirmada(true);
    }
    
    public int crearTipoServicio(String tipo, String descripcion) throws Exception{
        //Registra el tipo de servicio
        Servicio servicio = new Servicio(tipo, descripcion);
        servicios.add(servicio);
        return servicio.getCodigo();
    }
    
    public void modificarTipoServicio(int codigoServicio, String tipo, String descripcion) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio);
        if (servicio == null)
            throw new Exception("Servicio no existente");
        servicio.modificarServicio(tipo, descripcion);
    }
    
    public void borrarTipoServicio(int codigoServicio) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio);
        if (servicio == null)
            throw new Exception("Servicio no existente");
        servicios.remove(servicio);
    }
    
    public String consultarTipoServicio(int codigoServicio) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio);
        if (servicio == null)
            throw new Exception("Servicio no existente");
        return servicio.toString();
    }
    
    public String mostrarListaEspera() throws Exception{
        String listaEsperaString = "";
        for (Cliente clienteEspera : listaDeEspera){
            listaEsperaString += clienteEspera.toString();
        }
        return listaEsperaString;
    }
    
    public void agregarClienteListaEspera(int codigoCliente) throws Exception{
        //Registra el cliente en la lista de espera
        Cliente cliente = obtenerCliente(codigoCliente);
        if (cliente == null)
            throw new Exception("Cliente no existente");
        listaDeEspera.add(cliente);
    }
    
    public void borrarClienteListaEspera(int codigoCliente) throws Exception{
        Cliente cliente = null;
        for (Cliente clienteListaEspera : listaDeEspera){
            if (clienteListaEspera.getCodigo() == codigoCliente){
                cliente = clienteListaEspera;
                break;
            }
                
        }
        if (cliente == null)
            throw new Exception("Cliente no existente");
        listaDeEspera.remove(cliente);
    }
    
    public void establecerHorarioAtencion(DayOfWeek dia, LocalTime inicio, LocalTime fin) throws Exception{
        //Registra el horario de atencion
        HorarioDia horario = new HorarioDia(dia, inicio, fin);
        listaHorariosDia.add(horario);
    }
}
