import { describe, it, expect } from "vitest";

import { mount } from "@vue/test-utils";
import HomeView from "../../views/HomeView.vue"

describe("Calculator", () => {
    it("renders properly", () => {
        const wrapper = mount(HomeView);
        expect(wrapper.text()).toContain("Welcome");
        expect(wrapper.text()).toContain("This is my homepage");
        expect(wrapper.element.id).equals('container');
    });
});
