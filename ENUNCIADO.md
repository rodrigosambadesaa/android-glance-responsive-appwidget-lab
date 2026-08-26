# Enunciado didáctico reconstruido — AppWidget responsive con Jetpack Glance

Laboratorio Android para crear un widget de pantalla de inicio mediante **Jetpack Glance**.

La práctica debe:

- implementar un `GlanceAppWidget` y su `GlanceAppWidgetReceiver`;
- definir un comportamiento responsive mediante `SizeMode.Responsive`;
- ofrecer, al menos, una presentación compacta y otra expandida;
- adaptar el contenido al tamaño actual consultando `LocalSize`;
- reaccionar al redimensionado del widget desde el launcher;
- incluir una acción interna de actualización mediante `ActionCallback` y `updateAll()`.

El usuario debe poder añadir el widget desde el selector del launcher, redimensionarlo y observar cómo cambia su contenido.

No existe una base de datos asociada.
