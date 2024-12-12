<template>
  <Mheader></Mheader>

  <div class="formulario-view">
    <!-- Menú desplegable -->
    <div class="menu-empresa">
      <label for="opciones-empresa">Opciones de Empresa:</label>
      <select id="opciones-empresa" v-model="vistaSeleccionada">
        <option value="Insertar_Empresa">Insertar Empresa</option>
        <option value="Actualizar_Empresa">Actualizar Empresa</option>
        <option value="Consultar_Empresa">Consultar Empresa</option>
        <option value="Eliminar_Empresa">Eliminar Empresa</option>
      </select>
    </div>

    <!-- Renderizado condicional de las vistas -->
    <div v-if="vistaSeleccionada === 'Insertar_Empresa'">
      <Insertar_Empresa />
    </div>
    <div v-if="vistaSeleccionada === 'Actualizar_Empresa'">
      <Actualizar_Empresa />
    </div>
    <div v-if="vistaSeleccionada === 'Consultar_Empresa'">
      <Consultar_Empresa />
    </div>
    <div v-if="vistaSeleccionada === 'Eliminar_Empresa'">
      <Eliminar_Empresa />
    </div>
  </div>
</template>


<script setup>
import { ref } from 'vue';

// Importar las vistas
import Insertar_Empresa from '@/components/Insertar_Empresa.vue';
import Actualizar_Empresa from '@/components/Actualizar_Empresa.vue';
import Consultar_Empresa from '@/components/Consultar_Empresa.vue';
import Eliminar_Empresa from '@/components/Eliminar_Empresa.vue';
import Mheader from '@/components/Mheader.vue';

// Variable reactiva para manejar la vista seleccionada
const vistaSeleccionada = ref('Insertar_Empresa');
</script>


<style scoped>
.menu-empresa {
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
}

#opciones-empresa {
  padding: 10px;
  font-size: 16px;
  margin-top: 5px;
}

.formulario-view {
  margin-top: 20px;
}
</style>
