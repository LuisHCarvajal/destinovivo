<template>
  <div class="actualizar-empresa">
    <h2>Actualizar Empresa</h2>

    <!-- Formulario para buscar la empresa -->
    <form @submit.prevent="ConsultarEmpresa">
      <div class="form-group">
        <label for="id_empresa">ID de la Empresa:</label>
        <input
          type="number"
          id="id_empresa"
          v-model.number="id_empresa"
          placeholder="Ingresa el ID de la empresa"
          required
        />
      </div>
      <button type="submit" class="btn-submit" :disabled="isSubmitting">
        {{ isSubmitting ? "Buscando..." : "Consultar Empresa" }}
      </button>
    </form>

    <!-- Mensaje de error o éxito al buscar -->
    <div v-if="mensajeConsulta" :class="{'mensaje-exito': isConsultaExito, 'mensaje-error': !isConsultaExito}">
      {{ mensajeConsulta }}
    </div>

    <!-- Formulario para actualizar la empresa -->
    <form v-if="empresa" @submit.prevent="ActualizarEmpresa">
      <div class="form-group" v-for="campo in campos" :key="campo.nombre">
        <label :for="campo.nombre">{{ campo.etiqueta }}</label>
        <input
          type="text"
          :id="campo.nombre"
          v-model="empresa[campo.nombre]"
          :placeholder="'Ingresa ' + campo.etiqueta"
          :required="campo.nombre !== 'id_empresa'"
        />
      </div>

      <button type="submit" class="btn-submit" :disabled="isSubmitting">
        {{ isSubmitting ? "Actualizando..." : "Actualizar Empresa" }}
      </button>
    </form>

    <!-- Mensaje de error o éxito al actualizar -->
    <div v-if="mensajeActualizacion" :class="{'mensaje-exito': isActualizacionExito, 'mensaje-error': !isActualizacionExito}">
      {{ mensajeActualizacion }}
    </div>
  </div>
</template>


<script>
import { ref } from "vue";

export default {
  name: "Actualizar_Empresa",
  setup() {
    // Variables
    const id_empresa = ref(null); // ID de la empresa a buscar
    const empresa = ref(null); // Datos de la empresa consultada
    const campos = [
  { nombre: 'nombre', etiqueta: 'Nombre', tipo: 'text' },
  { nombre: 'direccion', etiqueta: 'Dirección', tipo: 'text' },
  { nombre: 'descripcion', etiqueta: 'Descripción', tipo: 'text' },
  { nombre: 'horario', etiqueta: 'Horario', tipo: 'text' },
  { nombre: 'telefono', etiqueta: 'Teléfono', tipo: 'text' },
  { nombre: 'correo', etiqueta: 'Correo', tipo: 'email' },
  { nombre: 'contrasena', etiqueta: 'Contraseña', tipo: 'password' },
  { nombre: 'imagen', etiqueta: 'Imagen', tipo: 'text' }
];
    const isSubmitting = ref(false); // Estado de envío
    const mensajeConsulta = ref("");
    const mensajeActualizacion = ref("");
    const isConsultaExito = ref(false); // Estado de éxito en consulta
    const isActualizacionExito = ref(false); // Estado de éxito en actualización

    // Consultar empresa por ID
    const ConsultarEmpresa = async () => {
      if (!id_empresa.value || isNaN(id_empresa.value) || id_empresa.value <= 0) {
        mensajeConsulta.value = "Por favor, ingresa un ID de empresa válido.";
        isConsultaExito.value = false;
        return;
      }

      isSubmitting.value = true;
      mensajeConsulta.value = "";

      try {
        const respuesta = await fetch(`http://localhost:8080/empresas/consultar/${id_empresa.value}`, {
          method: "GET",
        });

        if (respuesta.ok) {
          empresa.value = await respuesta.json();
          mensajeConsulta.value = "Empresa consultada correctamente.";
          isConsultaExito.value = true;
        } else {
          empresa.value = null;
          const errorTexto = await respuesta.text();
          mensajeConsulta.value = errorTexto || "No se encontró la empresa.";
          isConsultaExito.value = false;
        }
      } catch (error) {
        mensajeConsulta.value = `Error de red o servidor: ${error.message}`;
        isConsultaExito.value = false;
      } finally {
        isSubmitting.value = false;
      }
    };

    // Actualizar empresa
    const ActualizarEmpresa = async () => {
      if (!empresa.value || !id_empresa.value) {
        mensajeActualizacion.value = "Primero consulta la empresa antes de actualizar.";
        isActualizacionExito.value = false;
        return;
      }

      isSubmitting.value = true;
      mensajeActualizacion.value = "";

      try {
        const respuesta = await fetch(`http://localhost:8080/empresas/actualizar`, {
          method: "POST", // Usamos PUT en lugar de POST para actualización
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(empresa.value),
        });

        if (respuesta.ok) {
          const data = await respuesta.json();
          mensajeActualizacion.value = data.mensaje || "Empresa actualizada correctamente.";
          isActualizacionExito.value = true;

          // Limpia el formulario después de actualizar
          empresa.value = null;
          id_empresa.value = null;
        } else {
          const errorTexto = await respuesta.text();
          mensajeActualizacion.value = errorTexto || "Error al actualizar la empresa.";
          isActualizacionExito.value = false;
        }
      } catch (error) {
        mensajeActualizacion.value = `Error de red o servidor: ${error.message}`;
        isActualizacionExito.value = false;
      } finally {
        isSubmitting.value = false;
      }
    };

    return {
      id_empresa,
      empresa,
      campos,
      isSubmitting,
      mensajeConsulta,
      mensajeActualizacion,
      isConsultaExito,
      isActualizacionExito,
      ConsultarEmpresa,
      ActualizarEmpresa,
    };
  },
};
</script>

<style scoped>
.mensaje-exito {
  color: green;
  font-weight: bold;
}

.mensaje-error {
  color: red;
  font-weight: bold;
}

.form-group {
  margin-bottom: 15px;
}

.btn-submit {
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-submit:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
</style>
