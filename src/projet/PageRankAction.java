package projet;

import projet.options.Action;

public class PageRankAction extends Action {

    protected Configuration configuration;

    public PageRankAction(Configuration configuration) {
        this.configuration = configuration;
    }

    public PageRankAction(Configuration configuration, boolean needValue) {
        super(needValue);
        this.configuration = configuration;
    }
}
