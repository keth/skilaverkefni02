package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Board;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * @author Birgir S. Ásþórsson og Kristján Eldjárn Þóroddsson
 *
 * Implementation of BoardDataGateway
 * Implements access to database for boards
 */
public class BoardData extends RuData implements BoardDataGateway
{
     /**
     * addBoard tekur saman upplýsingar um borð og færir þær síðan yfir í gagnagrunn
     * @param board
     */
    public void addBoard(Board board)
    {
        SimpleJdbcInsert insertBoard =
                new SimpleJdbcInsert(getDataSource())
                .withTableName("ru_boards");

        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("boardname", board.getName());
        parameters.put("category", board.getCategory());
        parameters.put("username", "Jonas");
       // parameters.put("username", board.getCreator());
        //parameters.put("created", board.getCreated());

        try
        {
            insertBoard.execute(parameters);
        }
        catch (DataIntegrityViolationException divex)
        {
            log.warning("Board with same name exists");
        }
    }

    /**
     * getBoardByUsername finnur öll borð tengd username og skilar þeim úr gagnagrunni
     * @param username
     * @return
     */
    public List<Board> getBoardsByUsername(String username)
    {
        JdbcTemplate queryBoardsByUsername = new JdbcTemplate(getDataSource());
        String select = "select * from ru_boards where username = ?";
        List<Board> boards = queryBoardsByUsername.query(select, new Object[]{username}, new BoardRowMapper());
        return boards;
    }

    /**
     * getBoard finnur borð með ákveðnu nafni og tengt ákevðnum user í gagnagrunni og skilar því
     * @param boardname
     * @param username
     * @return
     */
    public Board getBoard(String boardname, String username)
    {
        JdbcTemplate queryContent = new JdbcTemplate(getDataSource());

        List<Board> b = queryContent.query("SELECT * FROM ru_boards WHERE boardname=? AND username=?",
                new BoardRowMapper(), new Object[]{boardname, username});

        if(b.size() > 0)
        {
            return b.get(0);
        }
        else
        {
            return null;
        }
    }
}
