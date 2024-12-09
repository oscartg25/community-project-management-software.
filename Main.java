import javax.swing.JOptionPane; import java.text.SimpleDateFormat; import java.text.ParseException; import java.util.Date;

public class Main { public static void main(String[] args) { ControladorProyecto controlador = new ControladorProyecto(); int opcion;
    do {
        String menu = """
            GESTIÓN DE PROYECTOS COMUNITARIOS
            1. Crear Proyecto
            2. Listar Proyectos
            3. Actualizar Estado de Proyecto
            4. Eliminar Proyecto
            5. Ver Proyectos por Mes
            6. Calcular Aceleración de Incremento
            7. Ver Proyectos por Categoría
            8. Generar Estadísticas por Presupuesto
            9. Salir
            """;

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu + "\nSeleccione una opción:"));

            switch (opcion) {
                case 1 -> crearProyecto(controlador);
                case 2 -> controlador.listarProyectos();
                case 3 -> actualizarProyecto(controlador);
                case 4 -> eliminarProyecto(controlador);
                case 5 -> verProyectosPorMes(controlador);
                case 6 -> calcularAceleracion(controlador);
                case 7 -> verProyectosPorCategoria(controlador);
                case 8 -> generarEstadisticasPresupuesto(controlador);
                case 9 -> JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            opcion = 0;
        }
    } while (opcion != 9);
}

private static void crearProyecto(ControladorProyecto controlador) {
    try {
        int id = solicitarId();
        String nombre = solicitarNombre();
        String descripcion = solicitarDescripcion();
        double presupuesto = solicitarPresupuesto();
        Date fechaInicio = solicitarFecha("inicio");
        Date fechaFin = solicitarFechaFin(fechaInicio);
        String estado = solicitarEstado();
        String categoria = solicitarCategoria();

        Proyecto proyecto = new Proyecto(id, nombre, descripcion, fechaInicio, fechaFin, estado, presupuesto, categoria);
        controlador.crearProyecto(proyecto);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al crear el proyecto: " + e.getMessage());
    }
}

private static Date solicitarFecha(String tipo) {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha = null;
    boolean fechaValida = false;

    while (!fechaValida) {
        try {
            String fechaInput = JOptionPane.showInputDialog("Ingrese la fecha de " + tipo + " (dd/MM/yyyy):");
            fecha = formatoFecha.parse(fechaInput);
            fechaValida = true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Fecha no válida. Intente nuevamente.");
        }
    }

    return fecha;
}

private static Date solicitarFechaFin(Date fechaInicio) {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaFin = null;
    boolean fechaValida = false;

    while (!fechaValida) {
        try {
            String fechaInput = JOptionPane.showInputDialog("Ingrese la fecha de fin (dd/MM/yyyy):");
            fechaFin = formatoFecha.parse(fechaInput);

            if (fechaFin.before(fechaInicio)) {
                JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio.");
            } else {
                fechaValida = true;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Fecha no válida. Intente nuevamente.");
        }
    }

    return fechaFin;
}

private static void actualizarProyecto(ControladorProyecto controlador) {
    int id = solicitarId();
    String nuevoEstado = solicitarEstado();
    controlador.actualizarProyecto(id, nuevoEstado);
}

private static void eliminarProyecto(ControladorProyecto controlador) {
    int id = solicitarId();
    controlador.eliminarProyecto(id);
}

private static void verProyectosPorMes(ControladorProyecto controlador) {
    String mes = JOptionPane.showInputDialog("Ingrese el mes (Enero, Febrero, etc.):").trim();
    mes = mes.substring(0, 1).toUpperCase() + mes.substring(1).toLowerCase();
    controlador.verProyectosPorMes(mes);
}

private static void calcularAceleracion(ControladorProyecto controlador) {
    try {
        double incremento1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer valor de incremento:"));
        double incremento2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo valor de incremento:"));
        double tiempo1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer tiempo (segundos):"));
        double tiempo2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo tiempo (segundos):"));

        double aceleracion = controlador.calcularAceleracion(incremento1, incremento2, tiempo1, tiempo2);
        JOptionPane.showMessageDialog(null, "La aceleración de incremento es: " + aceleracion + " m/s²");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error al ingresar un número válido: " + e.getMessage());
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "Error de argumento: " + e.getMessage());
    }
}

private static void verProyectosPorCategoria(ControladorProyecto controlador) {
    String[] categorias = {"Ambiental", "Industrial", "Software", "Civil", "Salud"};
    String categoria = (String) JOptionPane.showInputDialog(null, "Seleccione la categoría:",
            "Categoría", JOptionPane.QUESTION_MESSAGE, null, categorias, categorias[0]);
    controlador.verProyectosPorCategoria(categoria);
}

private static void generarEstadisticasPresupuesto(ControladorProyecto controlador) {
    controlador.generarEstadisticasPresupuesto();
}

private static int solicitarId() {
    while (true) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del proyecto:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número entero.");
        }
    }
}

private static String solicitarNombre() {
    return JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
}

private static String solicitarDescripcion() {
    return JOptionPane.showInputDialog("Ingrese la descripción del proyecto:");
}

private static double solicitarPresupuesto() {
    while (true) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog("Ingrese el presupuesto del proyecto:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El presupuesto debe ser un número válido.");
        }
    }
}

private static String solicitarEstado() {
    String[] opciones = {"En Proceso", "Finalizado", "Cancelado"};
    return (String) JOptionPane.showInputDialog(null, "Seleccione el estado del proyecto:",
            "Estado", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
}

private static String solicitarCategoria() {
    String[] opciones = {"Ambiental", "Industrial", "Software", "Civil", "Salud"};
    return (String) JOptionPane.showInputDialog(null, "Seleccione la categoría del proyecto:",
            "Categoría", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
}
}
