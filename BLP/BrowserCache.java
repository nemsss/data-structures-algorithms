package BLP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BrowserCache {

    private Map<String,WebPage> pages = new HashMap<>();
    LinkedList<String> history = new LinkedList<>();

    private void visit(String uri){
        WebPage webPage = new WebPage(uri);
        if(history.size() == 5){
            history.removeFirst();
        }
        history.addLast(uri);
    }

    private

    class WebPage{
        private String uri;
        private WebPage next;
        private WebPage prev;

        public WebPage(String uri) {
            this.uri = uri;
        }
    }
}
