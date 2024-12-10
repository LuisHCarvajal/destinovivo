<template>
<nav>
    <ul>
        <li>
            <router-link to ="/">Home</router-link>
        </li>
        <li>
            <router-link to ="/Insertar_Empresa">Empresa</router-link>
        </li>
        <li>
            <router-link to ="/Insertar_Usuario">Usuario</router-link>
        </li>
        <li>
            <router-link to ="/Insertar_Resena">Reseña</router-link>
        </li>

    </ul>
</nav>

</template>

<style scoped>
    nav ul {
    display: flex;
    gap: 10px;
    list-style: none;
    padding: 0;
    }

    nav ul li a {
    text-decoration: none;
    color: rgb(253, 253, 255);
    }

    nav ul li a:hover {
    text-decoration: underline;
    background-color: rgb(4, 196, 255);
    }

</style>