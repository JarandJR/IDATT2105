import { describe, it, expect } from "vitest";

import { mount } from "@vue/test-utils";
import ContactForm from "../contactform/ContactForm.vue";

describe("CalculatorForm", () => {
    it("renders properly", () => {
        const wrapper = mount(ContactForm);
        expect(wrapper.element.id).equals('container');
    });
});
