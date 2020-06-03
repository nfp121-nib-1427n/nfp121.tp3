package question2;

/**
 * Classe-test Pile2Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile2Test extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
        private PileI pile1;
        private PileI pile2;
    /**
     * Constructeur de la classe-test Pile2Test
     */
    public Pile2Test() {
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        pile1 = new question2.Pile2();
        pile2 = new question2.Pile2();
        // Initialisez ici vos engagements
    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        pile1 = null;
        pile2 = null;
        // Libérez ici les ressources engagées par setUp()
    }
        
    public void testPilePleine() throws Exception {
        PileI p = new question2.Pile2(3);
        p.empiler(10);
        p.empiler(20);
        p.empiler(30);
        assertEquals(3, p.taille());
        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        
    }
    
    public void testPileVide() throws Exception {
        PileI p = new question2.Pile2(3);
        assertEquals(true, p.estVide());
        
    }
    
     public void testPileEquals() throws Exception {

        pile1.empiler(10);
        pile1.empiler(20);
        pile1.empiler(30);

        pile2.empiler(10);
        pile2.empiler(20);
        pile2.empiler(30);

        assertTrue("egaux", pile1.equals(pile2));
        assertTrue("egaux", pile2.equals(pile1));

        pile2.empiler(40);
        assertFalse("egaux", pile1.equals(pile2));

    }
    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */

}
