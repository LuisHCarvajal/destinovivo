import { createRouter, createWebHistory } from "vue-router";
import Home from "@/view/Home.vue";
import { Comment } from "vue";
import Formulario_Empresa from "@/view/Formulario_Empresa.vue";
import Formulario_Usuario from "@/view/Formulario_Usuario.vue";
import Formulario_Resena from "@/view/Formulario_Resena.vue";


const routes=[

    {
        path: '/',
        name: 'home',
        component: Home

    },
    {
        path: '/insertar_Empresa',
        name: 'insertar_Empresa',
        component: Formulario_Empresa

    },
    {
        path: '/insertar_Usuario',
        name: 'insertar_Usuario',
        component: Formulario_Usuario

    },
    {
        path: '/insertar_Resena',
        name: 'insertar_Resena',
        component: Formulario_Resena

    }

]

    const router=createRouter({
        history:createWebHistory(),
        routes
    })

    export default router
