<template>
    <div class="eliminar-empresa">
      <h2>Eliminar Empresa</h2>
  
      <form @submit.prevent="EliminarEmpresa">
        <!-- Campo de ID de la empresa -->
        <div class="form-group">
          <label for="id_empresa">ID de la Empresa (Número Entero):</label>
          <input
            type="number"
            id="id_empresa"
            v-model.number="id_empresa"
            placeholder="Ingresa el ID de la empresa"
            required
          />
        </div>
  
        <!-- Botón de eliminar -->
        <button type="submit" class="btn-submit" :disabled="isSubmitting">
          {{ isSubmitting ? "Eliminando..." : "Eliminar Empresa" }}
        </button>
      </form>
  
      <!-- Mensaje de éxito o error -->
      <div v-if="mensaje" :class="{'mensaje-exito': isExito, 'mensaje-error': !isExito}">
        {{ mensaje }}
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    name: "Eliminar_Empresa",
    setup() {
      // Variables reactivas
      const id_empresa = ref(null); // Almacena el ID de la empresa a eliminar (número entero)
      const isSubmitting = ref(false); // Controla el estado del botón
      const mensaje = ref(''); // Mensaje de respuesta del servidor
      const isExito = ref(false); // Indica si la operación fue exitosa
  
      // Función para eliminar empresa
      const EliminarEmpresa = async () => {
        // Validar que el campo no esté vacío y sea un número válido
        if (!id_empresa.value || isNaN(id_empresa.value) || id_empresa.value <= 0) {
          mensaje.value = 'Por favor, ingresa un ID de empresa válido (número entero mayor a 0).';
          isExito.value = false;
          return;
        }
  
        // Confirmación antes de eliminar
        const confirmar = confirm(`¿Estás seguro de que deseas eliminar la empresa con ID ${id_empresa.value}?`);
        if (!confirmar) return;
  
        // Iniciar proceso de eliminación
        isSubmitting.value = true;
        mensaje.value = '';
  
        try {
          // Realizar la solicitud DELETE al servidor
          const respuesta = await fetch(`http://localhost:8080/empresas/eliminar/${id_empresa.value}`, {
            method: 'DELETE',
          });
  
          // Manejo de la respuesta del servidor
          const respuestaTexto = await respuesta.text(); // Leer como texto para manejar posibles errores
          if (respuesta.ok) {
            mensaje.value = respuestaTexto || 'Empresa eliminada correctamente.';
            isExito.value = true;
            id_empresa.value = null; // Limpiar el campo de entrada
          } else {
            mensaje.value = respuestaTexto || 'Error al eliminar la empresa.';
            isExito.value = false;
          }
        } catch (error) {
          // Error de red o conexión
          mensaje.value = `Error de red o servidor: ${error.message}`;
          isExito.value = false;
        } finally {
          isSubmitting.value = false; // Reactivar el botón
        }
      };
  
      return { id_empresa, isSubmitting, mensaje, isExito, EliminarEmpresa };
    },
  };
  </script>
  
  <style scoped>
  .eliminar-empresa {
    max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #f9f9f9;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  input {
    width: 100%;
    padding: 8px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .btn-submit {
    padding: 10px 15px;
    font-size: 16px;
    background-color: #d9534f;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .btn-submit:disabled {
    background-color: #ccc;
    cursor: not-allowed;
  }
  
  .btn-submit:hover:not(:disabled) {
    background-color: #c9302c;
  }
  
  .mensaje-exito {
    color: green;
    margin-top: 20px;
    font-weight: bold;
  }
  
  .mensaje-error {
    color: red;
    margin-top: 20px;
    font-weight: bold;
  }
  </style>
  