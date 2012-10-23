package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Board;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * @author Birgir S. Ásþórsson og Kristján Eldjárn Þóroddsson
 *
 * Gátt fyrir board tengingu í gagnagrunn
 */
public interface BoardDataGateway extends RuDataAccess
{
    public void addBoard(Board board);
    public List<Board> getBoardsByUsername(String username);
    public Board getBoard(String boardname, String username);
}
