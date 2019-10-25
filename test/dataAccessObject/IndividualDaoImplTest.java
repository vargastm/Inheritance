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

//    @org.junit.Test
    public void testSave() {
        System.out.println("save");
        individual = new Individual("32323", "52341", null, "Nome Sobrenome", "nome@email.com", "3123123", "15-10-1990");
        individualDaoImpl.save(individual);
    }
    
//    @org.junit.Test
    public void testChange() {
        System.out.println("alterar");
        int id = 3;
        individual = new Individual("132323", "152341", id, "Nome 2 Sobrenome", "nome1@email.com", "13123123", "15-10-1990");
        individualDaoImpl.change(individual);
    }
    
    @org.junit.Test
    public void testDelete() {
        System.out.println("deletar");
        int id = 3;
        individualDaoImpl.delete(id);
    }
    
    @org.junit.Test
    public void testListById() {
        System.out.println("pesquisar por id");
        individual = individualDaoImpl.listById(1);
        System.out.println("ID: " + individual.getId());
        System.out.println("Nome: " + individual.getName());
        System.out.println("Email: " + individual.getEmail());
        System.out.println("Telefone: " + individual.getPhone());
        System.out.println("Data de Nascimento: " + individual.getDateOfBirth());
        System.out.println("CPF: " + individual.getIndividualRegistration());
        System.out.println("RG: " + individual.getIdentityDocument());
    }
}
