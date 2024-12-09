import java.util.Date;
import javax.swing.JOptionPane;

public class Proyecto {
    private int id;
    private final String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private double presupuesto;
    private String categoria;

    public Proyecto(int id, String nombre, String descripcion, Date fechaInicio, Date fechaFin, String estado, double presupuesto, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.presupuesto = presupuesto;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String formatoFecha = "dd/MM/yyyy";
        return String.format(
            "ID: %d\n" +
            "Nombre: %s\n" +
            "Descripción: %s\n" +
            "Fecha de Inicio: %s\n" +
            "Fecha de Fin: %s\n" +
            "Estado: %s\n" +
            "Presupuesto: %.2f\n" +
            "Categoría: %s\n",
            id, nombre, descripcion,
            new java.text.SimpleDateFormat(formatoFecha).format(fechaInicio),
            new java.text.SimpleDateFormat(formatoFecha).format(fechaFin),
            estado, presupuesto, categoria
        );
    }

    public static String solicitarEstado() {
        String[] opciones = {"Planeado","En Proceso", "Finalizado", "Cancelado"};
        return (String) JOptionPane.showInputDialog(null, "Seleccione el estado del proyecto:",
                "Estado", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
    }
}
