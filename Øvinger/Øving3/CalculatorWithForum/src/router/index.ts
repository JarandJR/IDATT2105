import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component:() => import("../views/HomeView.vue"),
    },
    {
      path: "/contact-form",
      name: "contact",
      component: () => import("../views/ContactFormView.vue"),
    },
    {
      path: "/calculator",
      name: "calculator",
      component: () => import("../views/CalculatorView.vue"),
    },
  ],
});

export default router;
