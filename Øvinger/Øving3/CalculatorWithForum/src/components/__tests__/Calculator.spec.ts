import { describe, it, expect } from "vitest";

import { mount } from "@vue/test-utils";
import Calculator from "../calculator/Calculator.vue"

describe("Calculator", () => {
    it("renders properly", () => {
        const wrapper = mount(Calculator);
        expect(wrapper.element.id).equals('grid-container');
    });
});
