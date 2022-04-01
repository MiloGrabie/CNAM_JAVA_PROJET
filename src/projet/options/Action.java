package projet.options;

public abstract class Action {

    /**
     * Ici l'utilisation de need n'est pas très optimisé et une classe ActionValue aurait été plus pertinente,
     * malheureusement par manque de temps, je n'ai pas pu l'implémentér.
     */
    public boolean needValue = false;

    public Action() {};

    public Action(boolean needValue) {
        this.needValue = needValue;
    }

    public void execute() {}

    public void execute(String input) {}

}
