import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import('../pages/LandingPage.vue')
    },
    {
        path: '/about',
        name: 'about',
        component: () => import('../pages/AboutPage.vue')
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
