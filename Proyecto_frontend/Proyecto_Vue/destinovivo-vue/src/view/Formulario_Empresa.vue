
<template>

     <Mheader></Mheader>


    <div class="formulario-view">
    <Insertar_Empresa></Insertar_Empresa>
  </div>
</template>

<script setup>
import Insertar_Empresa from '@/components/Insertar_Empresa.vue';
import Mheader from '@/components/Mheader.vue';
</script>

<style scoped>
    .formulario-view {
    text-align: center;
    font-style: normal;
    padding: 20px;
    }
    .formulario-title {
    text-align: left;
    font-size: large;
    font-style: normal;
    padding: 20px;
    }
</style>
