package U1_P6;

import java.util.ArrayList;

public class Paciente {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String fechaNacimiento;
    private int edad;
    private double peso;
    private String fechaIngreso;
    private String horaIngreso;

    private String alergias;
    private String observaciones;
    private String diagnostico;
    private String salida;

    private String horaEgreso;
    private String observacionesEgreso;

    public Paciente() {

    }
    
    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getSalida() {
        return salida;
    }

    public String getHoraEgreso() {
        return horaEgreso;
    }

    public String getObservacionesEgreso() {
        return observacionesEgreso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public void setHoraEgreso(String horaEgreso) {
        this.horaEgreso = horaEgreso;
    }

    public void setObservacionesEgreso(String observacionesEgreso) {
        this.observacionesEgreso = observacionesEgreso;
    }

    // Metodo crear y ver
    public void crear(ArrayList<Paciente> lista) {
        lista.add(this);

    }
    public ArrayList<Paciente> ver(ArrayList<Paciente> lista) {
        return lista;
    }
}