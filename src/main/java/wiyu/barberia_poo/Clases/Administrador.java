package wiyu.barberia_poo.Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

/*
Controlador de la Barbería
Contiene ArrayList con diferentes tipos de datos
para almacenar y controlar los datos
*/

public class Administrador implements Serializable{
    private ArrayList<Cliente> clientes;
    private ArrayList<Cita> citas;
    private ArrayList<Servicio> servicios;
    private ArrayList<Cliente> listaDeEspera;
    private ArrayList<HorarioDia> listaHorariosDia;
    
    /*
    Inicializa las lista y carga datos de los clientes,
    citas, servicios, lista de espera y horario de atención.
    */
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
    
    /*
    Metodo que obtiene un cliente y recibe un parametro.
    */
    private Cliente obtenerCliente(int codigoCliente){
        for (Cliente cliente : clientes){ //recorre la lista
            if (cliente.getCodigo() == codigoCliente) //compara el codigo
                return cliente;
        }
        return null;
    }
    
    /*
    Metodo que obtiene una cita y recibe un parametro entero.
    */  
    private Cita obtenerCita(int codigoCita){
        for (Cita cita : citas){
            if (cita.getCodigo() == codigoCita)
                return cita;
        }
        return null;
    }
    
     /*
    Metodo que obtiene un Servicio y recibe un parametro entero.
    */  
    private Servicio obtenerServicio(int codigoServicio){
        for (Servicio servicio : servicios){
            if (servicio.getCodigo() == codigoServicio)
                return servicio;
        }
        return null;
    }
    
    /*
    Metodo reasigna el valor del consecutivo de cliente
    */
    private void reasignarConsecutivoCliente() {
        int mayor = 0; // inicia en un numero mayor a 0
        for (Cliente cliente : clientes) { // recorre lista
            if (cliente != null && cliente.getCodigo()> mayor) { // verifica si no es nulo y es mayor al valor actual
                mayor = cliente.getCodigo();
            }
        }
        Cliente.consecutivo = mayor + 1; //reasigna el consecutivo en clase cliente
    }
    
    /*
    Metodo reasigna el valor del consecutivo de Servicio
    Busca el código más alto la lista y reasignan el valor consecutivo para tener 
    un nuevo código único. 
    
    */
    private void reasignarConsecutivoServicio() {
        int mayor = 0;
        for (Servicio servicio : servicios) {
            if (servicio != null && servicio.getCodigo()> mayor) {
                mayor = servicio.getCodigo();
            }
        }
        Servicio.consecutivo = mayor + 1; //reasigna el consecutivo en clase servicio
    }
    
    /*
    Metodo reasigna el valor del consecutivo de Cita
    */
    private void reasignarConsecutivoCita() {
        int mayor = 0;
        for (Cita cita : citas) {
            if (cita != null && cita.getCodigo()> mayor) {
                mayor = cita.getCodigo();
            }
        }
        Cita.consecutivo = mayor + 1; //reasigna el consecutivo en clase cita
    }
    
    /*
    Crea un nuevo Cliente 
    */
        public int crearCliente(String nombre, String email, String telefono) throws Exception{
        //verifica que el cliente no exista en el sistema
        for (Cliente cliente : clientes){ //recorre la lista
            if (cliente.getNombre().equals(nombre) && cliente.getCorreo().equals(email) && cliente.getTelefono().equals(telefono))
                throw new Exception("El cliente ya se encuentra registrado"); // si encuentra un cliente igual manda una una excepcion
                    }
        
        //Crea y Guarda el nuevo cliente con los datos
        Cliente cliente = new Cliente(nombre, telefono, email);
        clientes.add(cliente); //agrega el cliente a la lista de clientes
        guardarDatoCliente(); //guarda la informacion del nuevo cliente al archivo txt
        return cliente.getCodigo();
    }
        
    /*
    Método permite modificar un cliente Ya existente
    */
    public void modificarCliente(int codigoCliente, String nombre, String telefono, String correo) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente); // busca un cliente por el código cliente ya ingresado
        cliente.modificarCliente(nombre, telefono, correo); //actualiza los datos cliente con los nuevos datos (numero, telefono, correo)
        guardarDatoCliente(); //guarda los cambios
    }
    
    /*
    Método que borra un cliente Ya existente
    */
    public void borrarCliente(int codigoCliente) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente); //entra en ObtenerCliente para buscar un cliente por su codigo
        if (cliente == null)
            throw new Exception("Cliente no existente"); //Lanza excepción si un cliente no existe
        clientes.remove(cliente); //Elimina el cliente en la lista de clientes
        guardarDatoCliente(); //actualiza la lista de clientes
    }

    /*
    Método que Busca un cliente Ya existente
    */
    public String consultarCliente(int codigoCliente) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente); // llama a Obtenercliente y obtiene el codigo cliente
        if (cliente == null) // verifica que el cliente exista
            throw new Exception("Cliente no existente");
        return cliente.toString();
    }

    /*
    Método para obtener el Horario 
    */    
    private HorarioDia obtenerHorario(int dia){ 
        for (HorarioDia horario : listaHorariosDia){ // recorre la lista
            if (horario.getDia() == dia){ //compara el día de la semana actual con el día de la semana proporcionado 
                return horario; //devuelve el objeto HorarioDia actual y ve que se ha encontrado una coincidencia/choque
            }
        }
        return null;
    }       
        
       /*
    Método para crear una Cita 
    */  
    public int crearCita(int codigoCliente, LocalDate dia, int hora, int codigoServicio) throws Exception{
        HorarioDia horario;
        horario = obtenerHorario(dia.getDayOfWeek().getValue());
        if (hora < horario.getInicio() || hora > horario.getFin()-1)
            throw new Exception("El día y hora seleccionados no pertenecen al horario de trabajo");
        //validar que el dia y hora no este ocupada en otra cita
        for (Cita cita : citas){
            if (cita.getDia().equals(dia) && cita.getHoraInicial() == hora && cita.getConfirmada()){
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
    
        /*
    Método para modificar una Cita
    */ 
    public void modificarCita(int codigoCita, LocalDate dia, int hora, int codigoServicio) throws Exception{
        //validar que el dia y la hora este dentro del horario de atencion
        HorarioDia horario = obtenerHorario(dia.getDayOfWeek().getValue()); 
        if (horario == null)
            throw new Exception("El día y hora seleccionados no pertenecen al horario de trabajo");
        //validar que el dia y hora no este ocupada en otra cita
        for (Cita cita : citas){
            if (cita.getDia().equals(dia) && cita.getHoraInicial() == hora && cita.getCodigo() != codigoCita){
                throw new Exception("Ya existe una cita en el día y hora seleccionados");
            }
        }
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        cita.modificarCita(dia, hora, obtenerServicio(codigoServicio));
        guardarDatoCita();
    }
        /*
    Método para Borrar una cita 
    */ 
    public void borrarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita); // llama a ObtenerCita para tener el codigo de cita y se almacena en cita
        if (cita == null) //si no encuentra una cita
            throw new Exception("Cita no existente"); //manda una excepcion
        citas.remove(cita); // si la cita se encuentra, se elimina de la lista de citas
        guardarDatoCita(); //guarda cambios realizados
    }
    
     /*
    Método para confirmar una cita 
    */ 
    public void confirmarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita); // llama a ObtenerCita para tener el codigo de cita y se almacena en cita
        if (cita == null) //si no encuentra una cita
            throw new Exception("Cita no existente"); //manda una excepcion
        cita.confirmarCita();
        guardarDatoCita(); //guarda cambios realizados
    }
    
    /*
    Método para Cosultar un cita y devuelve la información de la cita 
    */ 
    public String consultarCita(int codigoCita) throws Exception{ 
        Cita cita = obtenerCita(codigoCita); // se obtiene la cita y se guarda en cita
        if (cita == null) // si no encuentra una cita manda una excepción
            throw new Exception("Cita no existente");
        return cita.toString(); // si encontró una cita la convierte en una cadena de texto con la información de la cita
    }

     /*
    Método para agregar un Tipo de Servicio 
    */    
    public int crearTipoServicio(String tipo, String descripcion) throws Exception{
        //Registra el tipo de servicio
        Servicio servicio = new Servicio(tipo, descripcion);
        servicios.add(servicio); //agrega el servicio
        guardarDatoServicio(); // guarda el servicio
        return servicio.getCodigo(); //devuelve el código nuevo y único asignado al nuevo tipo de servicio creado
    }
    /*
    Método para modificar un Tipo de Servicio 
    */    
    public void modificarTipoServicio(int codigoServicio, String tipo, String descripcion) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio); // obtiene el codigo de servicio del tipo de servicio
        if (servicio == null) // si es null no se encontro ningun tipo de servicio
            throw new Exception("Servicio no existente"); // manda una excepción
        servicio.modificarServicio(tipo, descripcion); // si encuentra actualiza el tipo y la descripción
        guardarDatoServicio(); // actualiza los datos del servicio
    }
    /*
    Método para Borrar un Tipo de Servicio 
    */    
    public void borrarTipoServicio(int codigoServicio) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio);
        if (servicio == null)
            throw new Exception("Servicio no existente");
        for (Cita cita : citas){
            if (cita.getConfirmada() && cita.getServicio() == servicio)
                throw new Exception("El servicio está siendo utilizado en una cita ya confirmada");
        }
        servicios.remove(servicio); // si encuentra un servicio borra el servicio
        guardarDatoServicio();
    }
    /*
    Método para Consultar un Tipo de Servicio 
    */    
    public String consultarTipoServicio(int codigoServicio) throws Exception{
        Servicio servicio = obtenerServicio(codigoServicio);
        if (servicio == null)
            throw new Exception("Servicio no existente");
        return servicio.toString(); // devuelve el tipo de servicio a consultar
    }
     /*
    Método para Enseñar Lista de Espera
    */    
    public String mostrarListaEspera() throws Exception{
        String listaEsperaString = ""; //se inicia como un string vacío
        for (Cliente clienteEspera : listaDeEspera){ // entra en bucle para almacenar los string en la lista de Espera 
            listaEsperaString += clienteEspera.toString(); // devuelve los string en texto que representa la información del cliente
        }
        return listaEsperaString; //devuelve la lista de Espera actualizada
    }
     /*
    Método para Agregar cliente a la Lista de Espera
    */     
    public void agregarClienteListaEspera(int codigoCliente) throws Exception{
        //Registra el cliente en la lista de espera
        Cliente cliente = obtenerCliente(codigoCliente); 
        if (cliente == null)
            throw new Exception("Cliente no existente");
        listaDeEspera.add(cliente); // agrega el cliente a la lista
        guardarDatoListaEspera(); //actualiza
    }
     /*
    Método para Borrar cliente a la Lista de Espera
    */     
    public void borrarClienteListaEspera(int codigoCliente) throws Exception{
        Cliente cliente = null;
        for (Cliente clienteListaEspera : listaDeEspera){
            if (clienteListaEspera.getCodigo() == codigoCliente){ // obtiene el codigo del cliente actual
                cliente = clienteListaEspera;
                break;
            }
                
        }
        if (cliente == null)
            throw new Exception("Cliente no existente");
        listaDeEspera.remove(cliente);
        guardarDatoListaEspera();
    }
    /*
    Método para Establecer el Horario de Atención al cliente
    */    
    public void establecerHorarioAtencion(int dia, int inicio, int fin) throws Exception{
        //Registra el horario de atencion
        HorarioDia horario = new HorarioDia(dia, inicio, fin);
        listaHorariosDia.add(horario);
        guardarDatoHorario();
    }
    
    /*
    Método para Establecer el Horario de Atención al cliente
    */    
    public void borrarHorarioAtencion(int dia) throws Exception{
        //Borrar el horario de atencion
        listaHorariosDia.remove(obtenerHorario(dia));
        guardarDatoHorario();
    }
    
    /*
    Método para obtener el horario de atencion por dia de la semana
    */        
    public ArrayList<String> obtenerHorasDia(int dia) throws Exception {
        HorarioDia horario = obtenerHorario(dia);
        if (horario == null)
            throw new Exception("El día seleccionado no es un día dentro del horario de antención");
        ArrayList<String> horarioDelDia = new ArrayList<>();
        for(int i = horario.getInicio(); i < horario.getFin(); i++){
            horarioDelDia.add(String.valueOf(i));
        }
        return horarioDelDia;
    }
    
    /*
    Método para obtener el horario de atencion por dia de la semana
    */        
    public Map<Integer, String> getHorarios() {
        Map<Integer, String> mapHorarios = new TreeMap();
        for (HorarioDia horario: listaHorariosDia)
            mapHorarios.put(horario.getDia(), horario.toString());
        return mapHorarios;
    }

    //Funcion que retorna un Map de servicios con relación Codigo-String
    public Map<Integer, String> getServicios(){
        Map<Integer, String> mapClientes = new TreeMap();
        for (Servicio servicio: servicios)
            mapClientes.put(servicio.getCodigo(), servicio.toString());
        return mapClientes;
    }
    //Funcion que retorna un Map de clientes con relación Codigo-String
    public Map<Integer, String> getClientes(){
        Map<Integer, String> mapClientes = new TreeMap();
        for (Cliente cliente: clientes)
            mapClientes.put(cliente.getCodigo(), cliente.toString());
        return mapClientes;
    }
    //Funcion que retorna un Map de citas con relación Codigo-String
    public Map<Integer, String> getCitas(){
        Map<Integer, String> mapCitas = new TreeMap();
        for (Cita cita: citas)
            mapCitas.put(cita.getCodigo(), cita.toString());
        return mapCitas;
    }
    //Funcion que retorna un Map de los nombres de los clientes con relación Codigo-String
    public Map<Integer, String> getNombreClientes(){
        Map<Integer, String> mapClientes = new TreeMap();
        for (Cliente cliente: clientes)
            mapClientes.put(cliente.getCodigo(), cliente.getNombre());
        return mapClientes;
    }
    /*
    Método para obtener la Lista de Espera en relacion Codigo-String
    */    
    public Map<Integer, String> getListaEspera(){
        Map<Integer, String> mapClientes = new TreeMap();
        for (Cliente cliente: listaDeEspera)
            mapClientes.put(cliente.getCodigo(), cliente.toString());
        return mapClientes;
    }
    /*
    Método para obtener la fecha de una cita
    */    
    public LocalDate getDate(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        return cita.getDia();
    }
     /*
    Método para Guardar los datos del Cliente 
    */      
    private void guardarDatoCliente() {
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
     /*
    Método para Guardar los datos del Servicio
    */       
    private void guardarDatoServicio() {
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
     /*
    Método para Guardar datos de Cita
    */      
    private void guardarDatoCita() {
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
     /*
    Método para Guardar datos de lista de Espera
    */      
    private void guardarDatoListaEspera() {
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
     /*
    Método para Guardar datos de Horario
    */        
    private void guardarDatoHorario() {
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
     /*
    Método para Cargar datos de Cliente
    */        
    private void cargarDatosCliente() {
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
     /*
    Método para Cargar datos de Servicio
    */        
    private void cargarDatosServicio() {
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
     /*
    Método para Cargar datos de cita
    */        
    private void cargarDatosCita() {
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
     /*
    Método para Cargar datos de Lista de Espera
    */        
    private void cargarDatosListaEspera() {
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
     /*
    Método para Cargar datos de Horario
    */    
    private void cargarDatosHorario() {
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
