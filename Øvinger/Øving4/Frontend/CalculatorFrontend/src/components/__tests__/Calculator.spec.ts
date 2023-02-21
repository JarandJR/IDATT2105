import { describe, it, expect } from 'vitest'

import { mount } from '@vue/test-utils'
import Calculator from '../../components/calculatorpage/Calculator.vue'

describe('Calculator', () => {
  it('renders properly', () => {
    const wrapper = mount(Calculator)
    expect(wrapper.text()).toContain('This is my calculator')
  })
})
