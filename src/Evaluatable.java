public interface Evaluatable {
    static void evaluate(Debater debater, double mark) {
        debater.setRating(debater.getRating() + mark);
    }

    static double evaluate(Argument argument) {
        return argument.power() * Math.random() * 2;
    }
}
