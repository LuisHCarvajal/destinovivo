<template>
    <div class="formulario-resena">
      
       
       <!-- Formulario de empresa -->
       <form>
         <div class="form-group-resena">
           <label for="resena">Insertar Reseña</label>
           <textarea id="resumen" name="resumen" rows="5" cols="40" placeholder="Escriba su reseña aquí..."></textarea>
         </div>
   
         <div class="form-group-resena">
           <label for="calif">Calificación:</label>
           <select id="opciones" name="opciones">
                <option value="opcion1">0</option>
                <option value="opcion1">1</option>
                <option value="opcion2">2</option>
                <option value="opcion3">3</option>
                <option value="opcion4">4</option>
                <option value="opcion4">5</option>
            </select>
         </div>
     
         <button type="submit" class="btn-submit">Enviar</button>
       </form>
   
       <!-- Mensaje de éxito después del envío -->
       <div class="mensaje-exito">
         <p>Formulario enviado con éxito!</p>
       </div>
     </div>
   </template>
   
   
   
   <style scoped>
   .formulario-empresa {
     max-width: 500px;
     margin: 0 auto;
     padding: 20px;
     background-color: #f9f9f9;
     border-radius: 8px;
     box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
   }
   
   .form-group-resena {
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

   select {
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    border: 1px solid #ccc;
  }
  textarea {
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    border: 1px solid #ccc;
  }

  button {
    padding: 10px 20px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  button:hover {
    background-color: #45a049;
  }
   
   </style>
   