<template>
    <div class="consultar-empresa">
      <h2>Consultar Empresa</h2>
  
      <form @submit.prevent="ConsultarEmpresa">
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
  
        <!-- Botón de consultar -->
        <button type="submit" class="btn-submit" :disabled="isSubmitting">
          {{ isSubmitting ? "Consultando..." : "Consultar Empresa" }}
        </button>
      </form>
  
      <!-- Mostrar los datos de la empresa -->
      <div v-if="empresa" class="empresa-datos">
        <h3>Datos de la Empresa</h3>
        <ul>
          <li><strong>ID:</strong> {{ empresa.id_empresa }}</li>
          <li><strong>Nombre:</strong> {{ empresa.nombre }}</li>
          <li><strong>Dirección:</strong> {{ empresa.direccion }}</li>
          <li><strong>Descripción:</strong> {{ empresa.descripcion }}</li>
          <li><strong>Horario:</strong> {{ empresa.horario }}</li>
          <li><strong>Teléfono:</strong> {{ empresa.telefono }}</li>
          <li><strong>Email:</strong> {{ empresa.correo }}</li>
        </ul>
      </div>
  
      <!-- Mensaje de error -->
      <div v-if="mensaje" :class="{'mensaje-error': !empresa}">
        {{ mensaje }}
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    name: "Consultar_Empresa",
    setup() {
      // Variables reactivas
      const id_empresa = ref(null);
      const isSubmitting = ref(false);
      const empresa = ref(null);
      const mensaje = ref('');
  
      const ConsultarEmpresa = async () => {
        // Validar ID de empresa
        if (!id_empresa.value || isNaN(id_empresa.value) || id_empresa.value <= 0) {
          mensaje.value = 'Por favor, ingresa un ID de empresa válido (número entero mayor a 0).';
          empresa.value = null;
          return;
        }
  
        isSubmitting.value = true;
        mensaje.value = '';
        empresa.value = null;
  
        try {
          const respuesta = await fetch(`http://localhost:8080/empresas/consultar/${id_empresa.value}`, {
            method: 'GET',
          });
  
          const data = await respuesta.json();
          if (respuesta.ok) {
            empresa.value = data;
            mensaje.value = '';
          } else {
            mensaje.value = data.mensaje || 'No se encontró la empresa.';
          }
        } catch (error) {
          mensaje.value = `Error de red o servidor: ${error.message}`;
        } finally {
          isSubmitting.value = false;
        }
      };
  
      return { id_empresa, isSubmitting, empresa, mensaje, ConsultarEmpresa };
    },
  };
  </script>
  
  <style scoped>
  .consultar-empresa {
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
  
  