# Ejercicios: Módulo 3 - Clase 4

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.


###  **Ejemplo 1: Realizar un GET simple y mostrar el cuerpo de la respuesta**

> Se desea realizar una solicitud HTTP GET a un servicio público y mostrar el contenido textual de la respuesta, junto con el código de estado HTTP.

---

###  **Ejemplo 2: Realizar una solicitud POST con cuerpo JSON**

> Se quiere enviar un objeto como cuerpo JSON mediante POST, estableciendo el `Content-Type` como `application/json` y mostrando la respuesta del servidor.

---

###  **Ejemplo 3: Realizar un GET de forma asíncrona**

> Se quiere realizar una solicitud GET sin bloquear el hilo principal, utilizando `sendAsync`, y procesar la respuesta cuando llegue.

---

###  **Ejemplo 4: Enviar parámetros vía URL (GET con query params)**

> Se desea construir una URL con parámetros como si fuera un formulario o una búsqueda, y mostrar el contenido de la respuesta.

---

###  **Ejemplo 5: Enviar un formulario (`application/x-www-form-urlencoded`)**

> Se desea enviar datos como si fuera un formulario HTML clásico usando `POST`, codificados como `clave=valor`.

---

###  **Ejemplo 6: Enviar encabezados personalizados**

> Se necesita enviar una solicitud HTTP con headers adicionales, como un token de autenticación o información del cliente, y verificar que el servidor los reciba.

---

###  **Ejemplo 7: Manejar redirecciones automáticas**

> Se envía una solicitud que genera una redirección (HTTP 3xx), y se quiere que el cliente siga la redirección automáticamente hasta el destino final.

---

###  **Ejemplo 8: Realizar una solicitud con autenticación básica**

> Se accede a un endpoint protegido con autenticación HTTP básica (`Basic Auth`) usando un nombre de usuario y contraseña codificados en base64.

---

### **Ejemplo 9: Guardar la respuesta de una solicitud en un archivo**

> Se realiza una solicitud a una URL y se guarda directamente el contenido de la respuesta (como HTML o imagen) en un archivo del sistema local.

---

###  **Ejemplo 10: Manejar errores y mostrar detalles del fallo**

> Se realiza una solicitud a un endpoint que responde con un error (como 500), y se capturan posibles excepciones de red o interrupciones para manejar fallos de forma controlada.

---