public class Guest extends Human implements Evaluatable{
    static double evaluate(Argument argument) {
        return argument.power() * Math.random() * 2;
    }

    static void evaluate(Debater debater, double mark) {
        debater.setRating(debater.getRating() + mark);
    }
}
