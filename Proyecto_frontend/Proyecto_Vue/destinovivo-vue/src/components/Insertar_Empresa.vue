<template>
 <div class="formulario-empresa">
       
    <!-- Formulario de empresa -->
    <form @submit.prevent="Insertar_Empresa()">
      <div class="form-group">
        <label for="nombre">Nombre de la Empresa:</label>
        <input
          type="text"
          id="nombre"
          v-model="frm.nombre"
          placeholder="Ingresa el nombre de la empresa"
          required
        />
      </div>
      
      <div class="form-group">
        <label for="direccion">Dirección:</label>
        <input
          type="text"
          id="direccion"
          v-model="frm.direccion"
          placeholder="Ingresa la dirección"
          required
        />
      </div>

      <div class="form-group">
        <label for="descripcion">Descripción:</label>
        <input
          type="text"
          id="descripcion"
          v-model="frm.descripcion"
          placeholder="Ingresa la descripcion"
          required
        />
      </div>

      <div class="form-group">
        <label for="horario">Horario:</label>
        <input
          type="text"
          id="horario"
          v-model="frm.horario"
          placeholder="Ingresa el Horario"
          required
        />
      </div>
      
      <div class="form-group">
        <label for="telefono">Telefono:</label>
        <input
          type="text"
          id="telefono"
          v-model="frm.telefono"
          placeholder="Ingresa el Telefono"
          required
        />
      </div>

      <div class="form-group">
        <label for="email">Correo Electrónico:</label>
        <input
          type="email"
          id="email"
          v-model="frm.correo"
          placeholder="Ingresa el correo electrónico"
          required
        />
      </div>


      <div class="form-group">
        <label for="contrasena">Contraseña:</label>
        <input
          type="contrasena"
          id="contrasena"
          v-model="frm.contrasena"
          placeholder="Ingresa la contraseña"
          required
        />
      </div>

      <div class="form-group">
        <label for="imagen">Imagen:</label>
        <input
          type="imagen"
          id="imagen"
          v-model="frm.imagen"
          placeholder="Ingresa la Imagen"
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
        nombre:"",
        direccion:"",
        descripcion:"",
        horario:"",
        telefono:"",
        correo:"",
        contrasena:"",
        imagen:""

    }))
  const Insertar_Empresa=async()=>{
      try{
          const respuesta=await fetch ("http://localhost:8080/empresas/insertar",
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
.formulario-empresa {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
