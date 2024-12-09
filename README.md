# Community Project Management Software

## Desarrollo de un Software en Java para la Gestión de Proyectos Comunitarios en Cartagena
---
### 📋 Descripción del Proyecto

En Cartagena de Indias, la baja participación ciudadana en proyectos comunitarios impacta negativamente el desarrollo social y urbano. Esto limita el progreso en iniciativas importantes como:  
- La mejora de espacios públicos.  
- La gestión ambiental.  
- El desarrollo de actividades culturales.  

Este software aborda este problema al proporcionar una plataforma para:  
- **Facilitar el acceso a información detallada** sobre los proyectos.  
- **Promover la participación activa y transparente** de los ciudadanos.  
- **Permitir el seguimiento del avance de las iniciativas comunitarias**.  

El objetivo principal es empoderar a la comunidad y fortalecer los lazos entre ciudadanos, instituciones locales y organizaciones.

---

### 🚀 Funcionalidades Principales

1. **Gestión de Proyectos:**  
   - Crear, listar, actualizar y eliminar proyectos.  
   - Filtrar proyectos por mes y categoría.  
   - Generar estadísticas de presupuesto por categoría.  

2. **Persistencia de Datos:**  
   - Almacenamiento de proyectos en formato JSON.  

3. **Cálculos Especializados:**  
   - Cálculo de aceleración de incrementos para proyectos.  

4. **Interfaz Gráfica Simple:**  
   - Uso de JOptionPane para facilitar la interacción con los usuarios.

---

### 🛠️ Estructura del Proyecto
### 📂 Archivos Clave

1. **`Main.java`**  
   - Punto de entrada del programa.  
   - Contiene el menú principal y las interacciones del usuario.  

2. **`ControladorProyecto.java`**  
   - Implementa las operaciones principales del sistema:  
     - Gestión de proyectos.  
     - Filtros por mes y categoría.  
     - Generación de estadísticas.  
   - Utiliza la biblioteca Gson para manejar JSON.  

3. **`Proyecto.java`**  
   - Define los atributos y métodos de la clase `Proyecto`.

---

### 📈 Ejemplo de Uso

#### **Menú Principal**  
```text
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

### Creación de un Proyecto
El usuario ingresa datos como:

ID
Nombre
Descripción
Presupuesto
Fecha de inicio y fin
Categoría
Persistencia con JSON
Los datos se almacenan automáticamente en proyectos.json para garantizar que no se pierdan entre ejecuciones.

📚 Tecnologías Utilizadas
Java: Lenguaje principal del proyecto.
Gson: Biblioteca para manejo de JSON.
JOptionPane: Interfaz gráfica para facilitar la interacción del usuario.

