package projet;

import projet.options.Action;
import projet.options.Option;

public class PageRankOption extends Option {

    private Configuration configuration;

    public PageRankOption(String acces, String description, PageRankAction action, Configuration configuration) {
        super(acces, description, action);
        this.configuration = configuration;
    }
}

