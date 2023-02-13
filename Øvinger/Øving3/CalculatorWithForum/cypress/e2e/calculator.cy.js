Cypress.on('uncaught:exception', (err, runnable) => {
    return false;
});

describe('calculator', () => {
    beforeEach(()=>{
        cy.visit('http://127.0.0.1:5173/calculator')
    })

    it('Finds objects', () => {
        cy.get('#display').should('have.text', '0')
        cy.get('#five').should('have.text', '5')
    })

    it('adds two numbers',() =>{
        cy.get('#three').should('have.text','3').click();
        cy.get('button:contains("+")').click();
        cy.get('#two').click();
        cy.get('button:contains("=")').click();
        cy.get('#display').should('have.text', '5')
    })


    it('subtracts two numbers',() =>{
        cy.get('#nine').click();
        cy.get('button:contains("-")').click();
        cy.get('#three').click();
        cy.get('button:contains("=")').click();
        cy.get('#display').should('have.text', '6');
    })

    it('should not get wrong output',() =>{
        cy.get('#eight').click();
        cy.get('#multiply').click();
        cy.get('#seven').click();
        cy.get('button:contains("=")').click();
        cy.get('#display').should('not.have.text', '60');
    })

})