Cypress.on('uncaught:exception', (err, runnable) => {
    return false;
});

describe('form', () => {
    beforeEach(()=>{
        cy.visit('http://127.0.0.1:5173/contact-form')
    })


    it('Should render properly and find objects', ()=>{
        cy.get('form').should('be.visible')
        cy.get('input').should('be.of')
        cy.get('#submitBtn').should('be.disabled')
    })

    it('Should enable submit button correctly', ()=>{
        cy.get('button').should('be.disabled')
        cy.get('#inputName').type("Ola Normann")
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').should('be.enabled')
    })

    it('Should not enable button when input is incorrect', ()=>{
        cy.get('button').should('be.disabled')
        cy.get('#inputName').type("Ola") // Needs to be a full name, not just ht e first name
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').should('be.disabled')
    })

    it('Message should be removed, and "name" and "mail" should be stored in state when switching pages after submit', ()=>{
        cy.get('#inputName').type("Ola Normann")
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').click()
        cy.get('#routerHome').click()
        cy.get('#routerForm').click()
        cy.get('#inputName').should("have.value","Ola Normann")
        cy.get('#inputMessage').should("be.empty")
    })

    it('Should alert success upon pressing the submit button', ()=>{
        cy.get('#inputName').type("Ola Normann")
        cy.get('#inputMail').type('ola@normann.no')
        cy.get('#inputMessage').type("message")
        cy.get('#submitBtn').click()
        cy.on('window:alert', (str) => {
            expect(str).to.equal(`Success`)
        })
    })
})