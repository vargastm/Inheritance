package dataAccessObject;

import model.Individual;

/**
 *
 * @author Tiago Martins Vargas
 * 
 */
public class IndividualDaoImplTest {
    
    private Individual individual;
    private IndividualDaoImpl individualDaoImpl;
    
    public IndividualDaoImplTest() {
        individualDaoImpl = new IndividualDaoImpl();
    }

    @org.junit.Test
    public void testSave() {
        System.out.println("save");
        individual = new Individual("32323", "52341", null, "Nome Sobrenome", "nome@email.com", "3123123", "15-10-1990");
        individualDaoImpl.save(individual);
    }
    
}
