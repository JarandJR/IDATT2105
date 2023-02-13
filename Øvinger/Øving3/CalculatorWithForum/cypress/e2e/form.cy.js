Cypress.on('uncaught:exception', (err, runnable) => {
    return false;
});

describe('form', () => {
    beforeEach(()=>{
        cy.visit('http://127.0.0.1:5173/contact-form')
    })


    it('should find objects', ()=>{
        cy.get('form').should('be.visible')
        cy.get('input').should('be.of')
        cy.get('#submitBtn').should('be.disabled')
    })

    it('should enable button correctly', ()=>{
        cy.get('button').should('be.disabled')
        cy.get('#inputName').type("Ola Normann")
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').should('be.enabled')
    })

    it('should not enable button when input is not correct', ()=>{
        cy.get('button').should('be.disabled')
        cy.get('#inputName').type("Ola")
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').should('be.disabled')
    })

    it('message should be removed, and "name" and "mail" should be stored in state', ()=>{
        cy.get('#inputName').type("Ola Normann")
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').click()
        cy.get('#routerHome').click()
        cy.get('#routerForm').click()
        cy.get('#inputName').should("have.value","Ola Normann")
        cy.get('#inputMessage').should("be.empty")
    })

    it('should alert success upon correct data input', ()=>{
        cy.get('#inputName').type("Ola Normann")
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').click()
        cy.on('window:alert', (str) => {
            expect(str).to.equal(`Success`)
        })
    })
})