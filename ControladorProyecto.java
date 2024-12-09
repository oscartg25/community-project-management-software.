import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.JOptionPane;
import java.io.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControladorProyecto {
    private final List<Proyecto> proyectos;
    private final Gson gson;
    private static final String ARCHIVO_PROYECTOS = "proyectos.json";

    public ControladorProyecto() {
        gson = new Gson();
        proyectos = cargarProyectos();
    }

    public void crearProyecto(Proyecto proyecto) {
        if (buscarProyecto(proyecto.getId()) != null) {
            JOptionPane.showMessageDialog(null, "El ID ya existe. No se puede crear un proyecto duplicado.");
            return;
        }

        proyectos.add(proyecto);
        guardarProyectos();
        JOptionPane.showMessageDialog(null, "Proyecto creado exitosamente.");
    }

    public void listarProyectos() {
        if (proyectos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder("LISTADO DE PROYECTOS:\n\n");
        for (Proyecto proyecto : proyectos) {
            lista.append(proyecto).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public void actualizarProyecto(int id, String nuevoEstado) {
        Proyecto proyecto = buscarProyecto(id);
        if (proyecto == null) {
            JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
            return;
        }

        proyecto.setEstado(nuevoEstado);
        guardarProyectos();
        JOptionPane.showMessageDialog(null, "Estado del proyecto actualizado exitosamente.");
    }

    public void eliminarProyecto(int id) {
        Proyecto proyecto = buscarProyecto(id);
        if (proyecto == null) {
            JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
            return;
        }

        proyectos.remove(proyecto);
        guardarProyectos();
        JOptionPane.showMessageDialog(null, "Proyecto eliminado exitosamente.");
    }

    public void verProyectosPorMes(String mes) {
        if (proyectos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
            return;
        }

        SimpleDateFormat formatoMes = new SimpleDateFormat("MMMM", Locale.getDefault());
        StringBuilder lista = new StringBuilder("PROYECTOS DEL MES: ").append(mes).append("\n\n");

        for (Proyecto proyecto : proyectos) {
            if (formatoMes.format(proyecto.getFechaInicio()).equalsIgnoreCase(mes)) {
                lista.append(proyecto).append("\n");
            }
        }

        if (lista.length() > 0) {
            JOptionPane.showMessageDialog(null, lista.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay proyectos para el mes seleccionado.");
        }
    }

    public void verProyectosPorCategoria(String categoria) {
        if (proyectos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder("PROYECTOS DE LA CATEGORÍA: ").append(categoria).append("\n\n");
        boolean hayProyectos = false; // Para verificar si hay proyectos en la categoría

        for (Proyecto proyecto : proyectos) {
            // Verificar que la categoría no sea nula antes de compararla
            if (proyecto.getCategoria() != null && proyecto.getCategoria().equalsIgnoreCase(categoria)) {
                lista.append(proyecto).append("\n");
                hayProyectos = true; // Se encontró al menos un proyecto
            }
        }

        if (hayProyectos) {
            JOptionPane.showMessageDialog(null, lista.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay proyectos en la categoría seleccionada.");
        }
    }

    public void generarEstadisticasPresupuesto() {
        if (proyectos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
            return;
        }

        Map<String, Double> presupuestoPorCategoria = new HashMap<>();
        for (Proyecto proyecto : proyectos) {
            String categoria = proyecto.getCategoria();
            double presupuesto = proyecto.getPresupuesto();

            presupuestoPorCategoria.put(categoria, presupuestoPorCategoria.getOrDefault(categoria, 0.0) + presupuesto);
        }

        StringBuilder estadisticas = new StringBuilder("ESTADÍSTICAS DE PRESUPUESTO POR CATEGORÍA:\n\n");
        for (Map.Entry<String, Double> entry : presupuestoPorCategoria.entrySet()) {
            estadisticas.append("Categoría: ").append(entry.getKey())
                    .append(" - Presupuesto Total: $").append(String.format("%.2f", entry.getValue())).append("\n");
        }

        JOptionPane.showMessageDialog(null, estadisticas.toString());
    }

    public double calcularAceleracion(double incremento1, double incremento2, double tiempo1, double tiempo2) {
        if (tiempo2 <= tiempo1) {
            throw new IllegalArgumentException("El tiempo final debe ser mayor que el tiempo inicial.");
        }
        return (incremento2 - incremento1) / (tiempo2 - tiempo1);
    }

    private Proyecto buscarProyecto(int id) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getId() == id) {
                return proyecto;
            }
        }
        return null;
    }

    private void guardarProyectos() {
        try (Writer writer = new FileWriter(ARCHIVO_PROYECTOS)) {
            gson.toJson(proyectos, writer);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los proyectos: " + e.getMessage());
        }
    }

    private List<Proyecto> cargarProyectos() {
        try (Reader reader = new FileReader(ARCHIVO_PROYECTOS)) {
            Type tipoLista = new TypeToken<List<Proyecto>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los proyectos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
