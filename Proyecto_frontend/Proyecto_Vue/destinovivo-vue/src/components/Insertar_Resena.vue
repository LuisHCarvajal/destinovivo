<template>
  <div>
    <h2>Ingresar Reseña</h2>
    <form @submit.prevent="insertarResena">
      <!-- Campo para calificación -->
      <div> 
        <label for="calificacion">Calificación (1-5):</label>
        <input
          id="calificacion"
          type="number"
          v-model="reseña.calificacion"
          min="1"
          max="5"
          required
        />
      </div>

      <!-- Campo para texto de reseña -->
      <div>
        <label for="resena">Reseña:</label>
        <textarea
          id="resena"
          v-model="reseña.resena"
          placeholder="Escribe tu reseña aquí"
          maxlength="50"
          required
        ></textarea>
      </div>

      <!-- Lista desplegable para seleccionar empresa -->
      <div>
        <label for="id_empresa">Empresa:</label>
        <select id="id_empresa" v-model="reseña.empresa.id_empresa" required>
          <option value="" disabled>Selecciona una empresa</option>
          <option v-for="empresa in empresas" :key="empresa.id_empresa" :value="empresa.id_empresa">
            {{ empresa.nombre }}
          </option>
        </select>
      </div>

      <!-- Lista desplegable para seleccionar usuario -->
      <div>
        <label for="documento">Usuario:</label>
        <select id="documento" v-model="reseña.usuario.documento" required>
          <option value="" disabled>Selecciona un usuario</option>
          <option v-for="usuario in usuarios" :key="usuario.documento" :value="usuario.documento">
            {{ usuario.nombre }}
          </option>
        </select>
      </div>

      <!-- Botón para enviar el formulario -->
      <button type="submit">Ingresar Reseña</button>
    </form>

    <!-- Mensajes de éxito o error -->
    <p v-if="mensaje" :class="{ success: exito, error: !exito }">{{ mensaje }}</p>
  </div>
</template>

<script>
export default {
  name: "InsertarResena",
  data() {
    return {
      reseña: {
        calificacion: null,
        resena: "",
        empresa: { id_empresa: null },
        usuario: { documento: null },
      },
      empresas: [], // Lista de empresas disponibles
      usuarios: [], // Lista de usuarios disponibles
      mensaje: "",
      exito: false,
    };
  },
  mounted() {
    this.cargarEmpresas();
    this.cargarUsuarios();
  },
  methods: {
    // Cargar la lista de empresas desde el backend
    async cargarEmpresas() {
      try {
        const respuesta = await fetch("http://localhost:8080/empresas/consultar");
        if (respuesta.ok) {
          this.empresas = await respuesta.json();
        } else {
          console.error("Error al cargar empresas");
        }
      } catch (error) {
        console.error("Error de conexión al cargar empresas:", error);
      }
    },

    // Cargar la lista de usuarios desde el backend
    async cargarUsuarios() {
      try {
        const respuesta = await fetch("http://localhost:8080/usuarios/consultar");
        if (respuesta.ok) {
          this.usuarios = await respuesta.json();
        } else {
          console.error("Error al cargar usuarios");
        }
      } catch (error) {
        console.error("Error de conexión al cargar usuarios:", error);
      }
    },

    // Insertar una nueva reseña en el backend
    async insertarResena() {
      try {
        const respuesta = await fetch("http://localhost:8080/resenas/insertar", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(this.reseña),
        });

        if (respuesta.ok) {
          this.mensaje = "Reseña ingresada correctamente.";
          this.exito = true;

          // Reiniciar los campos del formulario
          this.reseña = {
            calificacion: null,
            resena: "",
            empresa: { id_empresa: null },
            usuario: { documento: null },
          };
        } else {
          const errorData = await respuesta.json();
          this.mensaje = `Error al ingresar reseña: ${errorData.message}`;
          this.exito = false;
        }
      } catch (error) {
        this.mensaje = `Error de conexión: ${error.message}`;
        this.exito = false;
      }
    },
  },
};
</script>

<style scoped>
.success {
  color: green;
}
.error {
  color: red;
}
</style>


<style scoped>
/* Estilos básicos */
form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  max-width: 400px;
  margin: auto;
}

label {
  font-weight: bold;
}

input,
textarea,
select {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 0.5rem 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

.success {
  color: green;
}

.error {
  color: red;
}
</style>
