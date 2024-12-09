📋 Descripción del Proyecto
En Cartagena de Indias, la baja participación ciudadana en proyectos comunitarios impacta negativamente el desarrollo social y urbano. Esto limita el progreso en iniciativas importantes como:

La mejora de espacios públicos.
La gestión ambiental.
El desarrollo de actividades culturales.
Este software aborda este problema al proporcionar una plataforma para:

Facilitar el acceso a información detallada sobre los proyectos.
Promover la participación activa y transparente de los ciudadanos.
Permitir el seguimiento del avance de las iniciativas comunitarias.
El objetivo principal es empoderar a la comunidad y fortalecer los lazos entre ciudadanos, instituciones locales y organizaciones.

🚀 Funcionalidades Principales
Gestión de Proyectos:

Crear, listar, actualizar y eliminar proyectos.
Filtrar proyectos por mes y categoría.
Generar estadísticas de presupuesto por categoría.
Persistencia de Datos:

Almacenamiento de proyectos en formato JSON.
Cálculos Especializados:

Cálculo de aceleración de incrementos para proyectos.
Interfaz Gráfica Simple:

Uso de JOptionPane para facilitar la interacción con los usuarios.
🛠️ Estructura del Proyecto
bash
Copiar código
/src
  ├── Main.java                # Punto de entrada del programa
  ├── ControladorProyecto.java # Lógica principal del sistema
  ├── Proyecto.java            # Clase que modela los proyectos
/data
  ├── proyectos.json           # Archivo JSON para persistencia de datos
/docs
  ├── DiagramaClases.png       # (Opcional) Diagrama de clases del proyecto
📂 Archivos Clave
Main.java

Punto de entrada del programa.
Contiene el menú principal y las interacciones del usuario.
ControladorProyecto.java

Implementa las operaciones principales del sistema:
Gestión de proyectos.
Filtros por mes y categoría.
Generación de estadísticas.
Utiliza la biblioteca Gson para manejar JSON.
Proyecto.java

Define los atributos y métodos de la clase Proyecto.
📈 Ejemplo de Uso
Menú Principal
text
Copiar código
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
Creación de un Proyecto
El usuario ingresa datos como:

ID
Nombre
Descripción
Presupuesto
Fecha de inicio y fin
Categoría
Persistencia con JSON
Los datos se almacenan automáticamente en proyectos.json para garantizar que no se pierdan entre ejecuciones.

🌟 Cómo Ejecutar
Clona el repositorio:

bash
Copiar código
git clone https://github.com/tu_usuario/community-project-management-software.git
Abre el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, etc.).

Ejecuta el archivo Main.java.

📚 Tecnologías Utilizadas
Java: Lenguaje principal del proyecto.
Gson: Biblioteca para manejo de JSON.
JOptionPane: Interfaz gráfica para facilitar la interacción del usuario.
📝 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

