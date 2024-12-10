<template>
    <div class="formulario-usuario">
      
       
       <!-- Formulario de empresa -->
       <form @submit.prevent="Insertar_Usuario()">
         <div class="form-group-Usuario">
           <label for="documento">Documento:</label>
           <input
             type="text"
             id="documento"
             v-model="frm.documento"
             placeholder="Ingresa el Documento"
             required
           />
         </div>
   
         <div class="form-group-Usuario">
           <label for="nombre">nombre:</label>
           <input
             type="text"
             id="nombre"
             v-model="frm.nombre"
             placeholder="Ingresa el Nombre"
             required
           />
         </div>
   
         <div class="form-group-Usuario">
           <label for="correo">Correo Electrónico:</label>
           <input
             type="text"
             id="correo"
             v-model="frm.correo"
             placeholder="Ingresa el Correo"
             required
           />
         </div>
   
         <div class="form-group-Usuario">
           <label for="telefono">Teléfono:</label>
           <input
             type="tel"
             id="telefono"
             v-model="frm.telefono"
             placeholder="Ingresa el teléfono"
             required
           />
         </div>

         <div class="form-group-Usuario">
           <label for="nacionalidad">Nacionalidad:</label>
           <input
             type="nacional"
             id="nacionalidad"
             v-model="frm.nacionalidad"
             placeholder="Ingresa la Nacionalidad"
             required
           />
         </div>

         <div class="form-group-Usuario">
           <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
           <input
             type="fechanaci"
             id="fechanaci"
             v-model="frm.fecha_nacimiento"
             placeholder="Ingresa la Fecha de Nacimiento"
             required
           />
         </div>
   
         <button type="submit" class="btn-submit">Enviar</button>
       </form>
   
       <!-- Mensaje de éxito después del envío -->
       <div class="mensaje-exito">
         <p>Formulario enviado con éxito!</p>
       </div>
     </div>
   </template>


   <script setup>
   import { ref } from 'vue';
 
       const frm=ref(({
         documento:"",
         nombre:"",
         correo:"",
         telefono:"",
         nacionalidad:"",
         fecha_nacimiento:""
 
     }))
   const Insertar_Usuario=async()=>{
       try{
           const respuesta=await fetch ("http://localhost:8080/usuarios/insertar",
           {
               method:"POST",
               headers:{
                   "Content-Type":"application/json"
               },
               body:JSON.stringify(frm.value)
           })
         }catch (error){
           mensaje.value=error.mensaje;
         }
       }
 </script>




   
   
   <style scoped>
   .formulario-usuario {
     max-width: 500px;
     margin: 0 auto;
     padding: 20px;
     background-color: #f9f9f9;
     border-radius: 8px;
     box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
   }
   
   .form-group-Usuario {
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
     border: 1px solid #ccc;
     border-radius: 4px;
     font-size: 12px;
   }
   
   button {
     padding: 10px 20px;
     background-color: #4caf50;
     color: white;
     border: none;
     border-radius: 4px;
     cursor: pointer;
   }
   
   button:hover {
     background-color: #4565a0;
   }
   
   .mensaje-exito {
     margin-top: 20px;
     background-color: #d4edda;
     color: #155724;
     padding: 10px;
     border-radius: 4px;
   }
   </style>
   