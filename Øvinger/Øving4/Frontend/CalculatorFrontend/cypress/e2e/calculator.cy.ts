describe('Calculator tests', () => {
    beforeEach(()=>{
        cy.visit('http://localhost:5173/calculator')
    })

    it('Finds objects', () => {
        cy.get('#display').should('have.text', '0')
        cy.get('button:contains("5")').should('have.text', '5')
    })

    it('Add two numbers',() =>{
        cy.get('button:contains("3")').should('have.text','3').click();
        cy.get('button:contains("+")').click();
        cy.get('button:contains("2")').click();
        cy.get('button:contains("=")').click();
        cy.get('#display').should('have.text', '5')
    })

    it('Subtracts two numbers',() =>{
        cy.get('button:contains("9")').click();
        cy.get('button:contains("-")').click();
        cy.get('button:contains("3")').click();
        cy.get('button:contains("=")').click();
        cy.get('#display').should('have.text', '6');
    })

    it('Should not get output',() =>{
        cy.get('button:contains("8")').click();
        cy.get('button:contains("*")').click();
        cy.get('button:contains("7")').click();
        cy.get('button:contains("=")').click();
        cy.get('#display').should('not.have.text', '57');
    })
})