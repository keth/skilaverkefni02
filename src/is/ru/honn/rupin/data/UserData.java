package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.User;
import is.ruframework.data.RuData;
import is.ruframework.data.RuDuplicateDataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * To change this template use File | Settings | File Templates.
 */
public class UserData extends RuData implements UserDataGateway
{

    @Override
    public int addUser(User user)
    {
        SimpleJdbcInsert insertContent =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_users")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(7);
        parameters.put("username", user.getUsername());
        parameters.put("firstName", user.getFirstName());
        parameters.put("lastName", user.getLastName());
        parameters.put("email", user.getEmail());
        parameters.put("password", user.getPassword());
        parameters.put("gender", user.getGender());

        int returnKey = 0;
        try
        {
            returnKey = insertContent.executeAndReturnKey(parameters).intValue();
        }
        catch (DataIntegrityViolationException divex)
        {
            String message = "User already exists";
            log.info(message);
            throw new RuDuplicateDataException(message, divex);
        }

        return returnKey;
    }

    @Override
    public User getUserByUsername(String username)
    {
        JdbcTemplate queryResult = new JdbcTemplate(getDataSource());
        User user = null;
        try
        {
            user = (User)queryResult.queryForObject(
                    "select * from ru_users where username=?", new UserRowMapper(), username);
        }
        catch (EmptyResultDataAccessException erdae)
        {
            return null;
        }
        return user;
    }
}
