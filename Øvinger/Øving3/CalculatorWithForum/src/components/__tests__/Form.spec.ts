import { describe, it, expect } from "vitest";

import { mount } from "@vue/test-utils";
import ContactForm from "../contactform/ContactForm.vue";

describe("CalculatorForm", () => {
    it("renders properly", () => {
        const wrapper = mount(ContactForm);
        expect(wrapper.text()).toContain("Full name:");
        expect(wrapper.text()).toContain("E-mail:");
        expect(wrapper.text()).toContain("Message:");
        expect(wrapper.element.id).equals('container');
    });
});
