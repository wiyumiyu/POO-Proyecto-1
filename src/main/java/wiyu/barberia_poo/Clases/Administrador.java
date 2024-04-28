package wiyu.barberia_poo.Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    ArrayList<Cliente> clientes;
    ArrayList<Cita> citas;
    ArrayList<Servicio> servicios;
    ArrayList<Cliente> listaDeEspera;
    ArrayList<HorarioDia> listaHorariosDia;
    
    public Administrador(){
        this.clientes = new ArrayList();
        this.citas = new ArrayList();
        this.servicios = new ArrayList();
        this.listaDeEspera = new ArrayList();        
        this.listaHorariosDia = new ArrayList();
        
        cargarDatosCliente();
        cargarDatosCita();
        cargarDatosServicio();
        cargarDatosHorario();
        cargarDatosListaEspera();

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
    
    private void reasignarConsecutivoCliente() {
        int mayor = 0;
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getCodigo()> mayor) {
                mayor = cliente.getCodigo();
            }
        }
        Cliente.consecutivo = mayor + 1;
    }
    
    private void reasignarConsecutivoServicio() {
        int mayor = 0;
        for (Servicio servicio : servicios) {
            if (servicio != null && servicio.getCodigo()> mayor) {
                mayor = servicio.getCodigo();
            }
        }
        Servicio.consecutivo = mayor + 1;
    }
    
    private void reasignarConsecutivoCita() {
        int mayor = 0;
        for (Cita cita : citas) {
            if (cita != null && cita.getCodigo()> mayor) {
                mayor = cita.getCodigo();
            }
        }
        Cita.consecutivo = mayor + 1;
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
        guardarDatoCliente();
        return cliente.getCodigo();
    }
    public void modificarCliente(int codigoCliente, String nombre, String telefono, String correo) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente);
        cliente.modificarCliente(nombre, telefono, correo);
        guardarDatoCliente();
    }
    public void borrarCliente(int codigoCliente) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente);
        if (cliente == null)
            throw new Exception("Cliente no existente");
        clientes.remove(cliente);
        guardarDatoCliente();
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
        guardarDatoCita();
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
        guardarDatoCita();
    }
    public void borrarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        citas.remove(cita);
        guardarDatoCita();
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
        guardarDatoCita();
    }
    
    public int crearTipoServicio(String tipo, String descripcion) throws Exception{
        //Registra el tipo de servicio
        Servicio servicio = new Servicio(tipo, descripcion);
        servicios.add(servicio);
        guardarDatoServicio();
        return servicio.getCodigo();
    }
    
    public void modificarTipoServicio(int codigoServicio, String tipo, String descripcion) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio);
        if (servicio == null)
            throw new Exception("Servicio no existente");
        servicio.modificarServicio(tipo, descripcion);
        guardarDatoServicio();
    }
    
    public void borrarTipoServicio(int codigoServicio) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio);
        if (servicio == null)
            throw new Exception("Servicio no existente");
        servicios.remove(servicio);
        guardarDatoServicio();
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
        guardarDatoListaEspera();
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
        guardarDatoListaEspera();
    }
    
    public void establecerHorarioAtencion(DayOfWeek dia, LocalTime inicio, LocalTime fin) throws Exception{
        //Registra el horario de atencion
        HorarioDia horario = new HorarioDia(dia, inicio, fin);
        listaHorariosDia.add(horario);
        guardarDatoHorario();
    }
    
    public void guardarDatoCliente() {
        try{
            FileOutputStream file = new FileOutputStream("BarberiaClientes.bin");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(clientes);
            stream.close();
            file.close();
        }
        catch (Exception e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    public void guardarDatoServicio() {
        try{
            FileOutputStream file = new FileOutputStream("BarberiaServicios.bin");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(servicios);
            stream.close();
            file.close();
        }
        catch (Exception e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    public void guardarDatoCita() {
        try{
            FileOutputStream file = new FileOutputStream("BarberiaCita.bin");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(citas);
            stream.close();
            file.close();
        }
        catch (Exception e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    public void guardarDatoListaEspera() {
        try{
            FileOutputStream file = new FileOutputStream("BarberiaListaEspera.bin");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(listaDeEspera);
            stream.close();
            file.close();
        }
        catch (Exception e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    public void guardarDatoHorario() {
        try{
            FileOutputStream file = new FileOutputStream("BarberiaHorario.bin");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(listaHorariosDia);
            stream.close();
            file.close();
        }
        catch (Exception e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    public void cargarDatosCliente() {
        try{
            File archivo = new File("BarberiaClientes.bin");

            // Verificar si el archivo existe
            if (!archivo.exists()) {
                // Si no existe, crear uno nuevo
                archivo.createNewFile();
            }
        
            // Si el archivo existe, cargar datos desde él
            try (FileInputStream file = new FileInputStream(archivo);
                 ObjectInputStream stream = new ObjectInputStream(file)) {
                clientes = (ArrayList<Cliente>) stream.readObject();
                reasignarConsecutivoCliente(); 
            } catch (IOException e) {
                // Manejar excepciones de lectura
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (Exception e) {
            // Manejar excepciones de lectura
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void cargarDatosServicio() {
        try{
            File archivo = new File("BarberiaServicios.bin");

            // Verificar si el archivo existe
            if (!archivo.exists()) {
                // Si no existe, crear uno nuevo
                archivo.createNewFile();
            }
        
            // Si el archivo existe, cargar datos desde él
            try (FileInputStream file = new FileInputStream(archivo);
                 ObjectInputStream stream = new ObjectInputStream(file)) {
                servicios = (ArrayList<Servicio>) stream.readObject();
                reasignarConsecutivoServicio(); 
            } catch (IOException e) {
                // Manejar excepciones de lectura
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (Exception e) {
            // Manejar excepciones de lectura
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void cargarDatosCita() {
        try{
            File archivo = new File("BarberiaCita.bin");

            // Verificar si el archivo existe
            if (!archivo.exists()) {
                // Si no existe, crear uno nuevo
                archivo.createNewFile();
            }
        
            // Si el archivo existe, cargar datos desde él
            try (FileInputStream file = new FileInputStream(archivo);
                 ObjectInputStream stream = new ObjectInputStream(file)) {
                citas = (ArrayList<Cita>) stream.readObject();
                reasignarConsecutivoCita(); 
            } catch (IOException e) {
                // Manejar excepciones de lectura
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (Exception e) {
            // Manejar excepciones de lectura
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void cargarDatosListaEspera() {
        try{
            File archivo = new File("BarberiaListaEspera.bin");

            // Verificar si el archivo existe
            if (!archivo.exists()) {
                // Si no existe, crear uno nuevo
                archivo.createNewFile();
            }
        
            // Si el archivo existe, cargar datos desde él
            try (FileInputStream file = new FileInputStream(archivo);
                 ObjectInputStream stream = new ObjectInputStream(file)) {
                listaDeEspera = (ArrayList<Cliente>) stream.readObject();
            } catch (IOException e) {
                // Manejar excepciones de lectura
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (Exception e) {
            // Manejar excepciones de lectura
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void cargarDatosHorario() {
        try{
            File archivo = new File("BarberiaHorario.bin");

            // Verificar si el archivo existe
            if (!archivo.exists()) {
                // Si no existe, crear uno nuevo
                archivo.createNewFile();
            }
        
            // Si el archivo existe, cargar datos desde él
            try (FileInputStream file = new FileInputStream(archivo);
                 ObjectInputStream stream = new ObjectInputStream(file)) {
                listaHorariosDia = (ArrayList<HorarioDia>) stream.readObject();
            } catch (IOException e) {
                // Manejar excepciones de lectura
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (Exception e) {
            // Manejar excepciones de lectura
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
