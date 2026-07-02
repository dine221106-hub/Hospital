package U1_P6;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class Controlador {

    private ArrayList<Paciente> listaPacientes;

    public Controlador() {
        listaPacientes = new ArrayList<>();
    }
    
    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }
    
    //Edad
    public int calcularEdad(Date fechaNacimiento) {
        LocalDate nacimiento = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now();
        return Period.between(nacimiento, hoy).getYears();
    }

    // Hora Actual
    public String horaActual() {
        LocalTime hora = LocalTime.now();
        return String.format("%02d:%02d:%02d", hora.getHour(), hora.getMinute(), hora.getSecond());
    }
    
    // Fecha
    public String convertirFecha(Date fecha) {
        SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }

    //Buscar Paciente
    public Paciente buscarPaciente(String texto){
        for(Paciente paciente : listaPacientes){
            String nombreCompleto = paciente.getNombre()+" "+ paciente.getApellidoPaterno()+" "+ paciente.getApellidoMaterno();
            if(nombreCompleto.equalsIgnoreCase(texto)){
                return paciente;
            }
        }
        return null;
    }

    // Guardar Registro
    public boolean guardarRegistro(String nombre,String alergias,String observaciones,String diagnostico,String salida){
        Paciente paciente = buscarPaciente(nombre);
        if(paciente == null){
            return false;
        }
        paciente.setAlergias(alergias);
        paciente.setObservaciones(observaciones);
        paciente.setDiagnostico(diagnostico);
        paciente.setSalida(salida);
        return true;
    }

    // Guardar egreso
    public boolean guardarEgreso(String nombre, String observacion){
        Paciente paciente = buscarPaciente(nombre);

        if (paciente == null) {
            return false;
        }

        if (!paciente.getSalida().equalsIgnoreCase("Alta")) {
            return false;
        }

        if (paciente.getFechaEgreso() != null
                && !paciente.getFechaEgreso().trim().equals("")) {
            return false;
        }

        paciente.setFechaEgreso(convertirFecha(new Date()));
        paciente.setHoraEgreso(horaActual());
        paciente.setObservacionesEgreso(observacion);
        return true;
    }
    
    // Mostrar Pacientes
    public DefaultTableModel mostrarPacientes() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido P.");
        modelo.addColumn("Apellido M.");
        modelo.addColumn("Genero");
        modelo.addColumn("Fecha Nac.");
        modelo.addColumn("Edad");
        modelo.addColumn("Peso");
        modelo.addColumn("Fecha Ingreso");
        modelo.addColumn("Hora Ingreso");
        modelo.addColumn("Alergias");
        modelo.addColumn("Observaciones");
        modelo.addColumn("Diagnóstico");
        modelo.addColumn("Salida");
        modelo.addColumn("Fecha Egreso");
        modelo.addColumn("Hora Egreso");
        modelo.addColumn("Obs. Egreso");

        Paciente p = new Paciente();
        ArrayList<Paciente> lista = p.ver(listaPacientes);
        for (Paciente paciente : lista) {
            Object datos[] = new Object[16];

            datos[0] = paciente.getNombre();
            datos[1] = paciente.getApellidoPaterno();
            datos[2] = paciente.getApellidoMaterno();
            datos[3] = paciente.getGenero();
            datos[4] = paciente.getFechaNacimiento();
            datos[5] = paciente.getEdad();
            datos[6] = paciente.getPeso();
            datos[7] = paciente.getFechaIngreso();
            datos[8] = paciente.getHoraIngreso();
            datos[9] = paciente.getAlergias();
            datos[10] = paciente.getObservaciones();
            datos[11] = paciente.getDiagnostico();
            datos[12] = paciente.getSalida();
            datos[13] = paciente.getFechaEgreso();
            datos[14] = paciente.getHoraEgreso();
            datos[15] = paciente.getObservacionesEgreso();
            modelo.addRow(datos);

        }
        return modelo;
    }
    
    // Guardar Ingreso
    public boolean guardarIngreso(String nombre,
            String apellidoPaterno,
            String apellidoMaterno,
            String genero,
            String fechaNacimiento,
            int edad,
            double peso,
            String fechaIngreso,
            String horaIngreso) {

        if (buscarPaciente(nombre) != null) {
            return false;
        }
        Paciente paciente = new Paciente();

        paciente.setNombre(nombre);
        paciente.setApellidoPaterno(apellidoPaterno);
        paciente.setApellidoMaterno(apellidoMaterno);
        paciente.setGenero(genero);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setEdad(edad);
        paciente.setPeso(peso);
        paciente.setFechaIngreso(fechaIngreso);
        paciente.setHoraIngreso(horaIngreso);

        paciente.crear(listaPacientes);
        return true;
    }
    
    // Existe Paciente
    public boolean existePaciente(String nombre){
        return buscarPaciente(nombre)!=null;
    }
    
    // Actualizar tabla
    public DefaultTableModel actualizarTabla(){
        return mostrarPacientes();
    }
    
    // Buscar en la Tabla
    public DefaultTableModel buscarTabla(String nombreCompleto){

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido P.");
        modelo.addColumn("Apellido M.");
        modelo.addColumn("Genero");
        modelo.addColumn("Fecha Nac.");
        modelo.addColumn("Edad");
        modelo.addColumn("Peso");
        modelo.addColumn("Fecha Ingreso");
        modelo.addColumn("Hora Ingreso");
        modelo.addColumn("Alergias");
        modelo.addColumn("Observaciones");
        modelo.addColumn("Diagnóstico");
        modelo.addColumn("Salida");
        modelo.addColumn("Fecha Egreso");
        modelo.addColumn("Hora Egreso");
        modelo.addColumn("Obs. Egreso");

        for(Paciente paciente : listaPacientes){
            String nombre = paciente.getNombre()+" " + paciente.getApellidoPaterno()+" "+ paciente.getApellidoMaterno();
            if(nombre.equalsIgnoreCase(nombreCompleto)){
                Object datos[] = new Object[16];

                datos[0]=paciente.getNombre();
                datos[1]=paciente.getApellidoPaterno();
                datos[2]=paciente.getApellidoMaterno();
                datos[3]=paciente.getGenero();
                datos[4]=paciente.getFechaNacimiento();
                datos[5]=paciente.getEdad();
                datos[6]=paciente.getPeso();
                datos[7]=paciente.getFechaIngreso();
                datos[8]=paciente.getHoraIngreso();
                datos[9]=paciente.getAlergias();
                datos[10]=paciente.getObservaciones();
                datos[11]=paciente.getDiagnostico();
                datos[12]=paciente.getSalida();
                datos[13]=paciente.getFechaEgreso();
                datos[14]=paciente.getHoraEgreso();
                datos[15]=paciente.getObservacionesEgreso();

                modelo.addRow(datos);
            }
        }
        return modelo;
    }
    
    public ArrayList<String> obtenerNombresPacientes() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Paciente p : listaPacientes) {
            nombres.add(p.getNombre() + " "+ p.getApellidoPaterno() + " "+ p.getApellidoMaterno());
        }
        return nombres;
    }
    
    public ArrayList<String> filtrarPacientes(String texto) {
        ArrayList<String> lista = new ArrayList<>();
        for (Paciente p : listaPacientes) {
            String nombre = p.getNombre() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno();
            if (nombre.toLowerCase().contains(texto.toLowerCase())) {
                lista.add(nombre);
            }
        }
        return lista;
    }
}
