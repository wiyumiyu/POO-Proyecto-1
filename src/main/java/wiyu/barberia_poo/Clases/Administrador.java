package wiyu.barberia_poo.Clases;

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
    public Administrador(){
        this.clientes = new ArrayList();
        this.citas = new ArrayList();
        this.servicios = new ArrayList();
        this.listaDeEspera = new ArrayList();
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
    public int crearCliente(String nombre, String email, String telefono) throws Exception{
        if (!Cliente.correoEsValido(email))
            throw new Exception("Email inválido!");
        if (!Cliente.numeroEsValido(telefono))
            throw new Exception("Teléfono inválido!");
        Cliente cliente = new Cliente(nombre, telefono, email);
        clientes.add(cliente);
        return cliente.getCodigo();
    }
    public int modificarCliente(int codigoCliente, String nombre, String telefono, String correo) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente);
        if (cliente == null)
            throw new Exception("Cliente no existente");
        if (!Cliente.correoEsValido(correo))
            throw new Exception("Email inválido!");
        if (!Cliente.numeroEsValido(telefono))
            throw new Exception("Teléfono inválido!");
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setNombre(nombre);
        return cliente.getCodigo();
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
    public int crearCita(int codigoCliente, String dia, int hora, Servicio servicio) throws Exception{
        Cliente cliente = obtenerCliente(codigoCliente);
        if (cliente == null)
            throw new Exception("Cliente no existente");
        int numeroCita = cliente.crearCita(dia, hora, servicio);
        Cita cita = cliente.obtenerCita(numeroCita);
        citas.add(cita);
        return cita.getCodigo();
    }
    public int modificarCita(int codigoCita, String dia, int hora, Servicio servicio) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        return cita.modificarCita(dia, hora, servicio);
    }
    public void borrarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        Cliente cliente = obtenerCliente(cita.getCodigoCliente());
        citas.remove(cita);
        cliente.eliminarCita(codigoCita);
    }
    public String consultarCita(int codigoCita) throws Exception{
        Cita cita = obtenerCita(codigoCita);
        if (cita == null)
            throw new Exception("Cita no existente");
        return cita.toString();
    }
}
