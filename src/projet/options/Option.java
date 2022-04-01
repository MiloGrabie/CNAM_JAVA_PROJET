package projet.options;

public class Option {

    public String acces;
    public String description;
    public Action action;

    public Option(String acces, String description, Action action) {
        this.acces = acces;
        this.description = description;
        this.action = action;
    }

    public boolean needValue(){
        return action.needValue;
    }

}
