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
    },
    {
        path: '/search',
        name: 'search',
        component: () => import('../pages/SearchResultPage.vue'),
    }
];


const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
