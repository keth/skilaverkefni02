import is.ru.honn.rupin.domain.Gender;
import is.ru.honn.rupin.service.*;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * User: kristjant08@ru.is
 * Kristján Eldjárn Þóroddsson
 * Date: 11.10.2012
 * Time: 22:00
 */
public class TestPinService extends TestCase {

    private PinService pinService = new PinServiceStub();

    private String username = "user01";
    private String firstName = "Bob";
    private String lastName = "Lennon";
    private String email = "john@heven.is";
    private String password = "password123";
    private Gender gender = Gender.MALE;

    public void testSignUpUser() {
        try {
            pinService.signUpUser(username, firstName, lastName, email, password, gender);
            Assert.assertNotNull(username);
            pinService.signUpUser(username, firstName, lastName, email, password, gender);
            fail("UsernameExistsException was not thrown");
        } catch (UsernameExistsException e) {
            // Success!   //todo: skoða hvort þetta sé ekki rétt http://www.exubero.com/junit/antipatterns.html
        }
    }

    public void testBoard() throws UsernameExistsException, UserNotFoundException {
        pinService.signUpUser(username, firstName, lastName, email, password, gender);
        pinService.createBoard(username, "Technology", "Technology");
    }

    public void testPin() throws UsernameExistsException, UserNotFoundException, BoardNotFoundException {
        pinService.signUpUser(username, firstName, lastName, email, password, gender);
        pinService.createBoard(username, "Technology", "Technology");
        pinService.createPin(username, "Technology", "http://www.junit.org/", "PinText");
    }

}
