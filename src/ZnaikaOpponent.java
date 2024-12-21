public abstract class ZnaikaOpponent extends Debater {
    int numberOfArguments;

    public ZnaikaOpponent(String name) {
        super(name);
        this.numberOfArguments = 1;
    }

    public abstract void insultZnaika(Znaika znaika);

    public int getNumberOfArguments() {
        return this.numberOfArguments;
    }
}

