<template>
    <header>
        <div class="logotitulo">

        <h1>DESTINOVIVO</h1>
        <br></br>
            <img src="../../public/images/logo1.png" alt="destinovivo">
        </div>
        <Mnavbar>

        </Mnavbar>
        
</header>
</template>

<script setup>
import Mnavbar from './Mnavbar.vue';
</script>

<style scoped>

header{
  display: flex;
  justify-content: space-between;  
  align-items: center;  
  padding: 20px 50px; 
  background-color: #333;  
  color: white;  

}
</style>