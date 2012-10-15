package is.ru.honn.rupin.process;

import is.ru.honn.rupin.feeds.FeedEntry;
import is.ru.honn.rupin.feeds.FeedHandler;
import is.ru.honn.rupin.service.PinService;
import is.ruframework.process.RuAbstractProcess;

/**
 * User: kristjant08@ru.is
 * Kristján Eldjárn Þóroddsson
 * Date: 15.10.2012
 * Time: 09:05
 */
public class PinImportProcess extends RuAbstractProcess implements FeedHandler {

    PinService pinService;

    public void processEntry(FeedEntry entry) {
        //todo: þetta á að vera eins og processContent fallið í verkefni vika06
        //pinService.
    }

    @Override
    public void startProcess() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
