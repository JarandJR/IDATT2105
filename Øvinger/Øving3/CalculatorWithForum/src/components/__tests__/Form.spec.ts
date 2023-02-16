import { describe, it, expect } from "vitest";
import App from "../../App.vue";

import { mount } from "@vue/test-utils";
import ContactForm from "../contactform/ContactForm.vue";
import { createPinia } from "pinia";
import {createApp} from "vue";

describe("CalculatorForm", () => {
    it("renders properly", () => {
        const app = createApp(App);
        app.use(createPinia());
        const wrapper = mount(ContactForm);
        expect(wrapper.text()).toContain("Full name:");
        expect(wrapper.text()).toContain("E-mail:");
        expect(wrapper.text()).toContain("Message:");
        expect(wrapper.element.id).equals('container');
    });
});
