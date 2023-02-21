describe('Calculator tests', () => {
    it('visit calculator-page', () => {
        cy.visit('/calculator')
        cy.contains('h2', 'This is my calculator')
    })
})