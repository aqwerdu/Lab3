import java.util.Scanner;

public class Debate {
    private int numberOfGuests;
    int num1 = 0;
    int num2 = 0;
    static Scanner scanner = new Scanner(System.in);

    Debate(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public static void startDebate(Znaika znaika, Volcanist volcanist, Meteorist meteorist) {
        System.out.println(znaika.getName() + ", " + volcanist.getName() + " и " + meteorist.getName() + " долгое время спорили о природе происхождения кратеров на Луне. Чтобы выяснить, кто же из них прав, " + znaika.getName() + ", " + volcanist.getName() + " и " + meteorist.getName() + " собрались и решили устроили дебаты, а теория победителя отныне и впредь решили считать единственно верной.");
    }

    public void startRound(Round round, Znaika znaika, Volcanist volcanist, Meteorist meteorist, Debate debate) throws ranOutOfArgumentsException {
        System.out.println(round.getTitle() + " раунд начался!");
        switch (round) {
            case FIRST:
                System.out.println("Слово передается " + volcanist.getName());
                num1 = (int) (Math.random() * volcanist.getNumberOfArguments());
                volcanist.presentArgument(volcanist.getArgumentAt(num1));
                debate.countVotes(debate, volcanist, volcanist.getArgumentAt(num1));
                int x = choose(Round.FIRST, znaika);
                znaika.presentArgument(znaika.getArgumentAt(x - 1));
                debate.countVotes(debate, znaika, znaika.getArgumentAt(x - 1));
                break;
            case SECOND:
                System.out.println("Слово передается " + meteorist.getName());
                num2 = (int) (Math.random() * meteorist.getNumberOfArguments());
                meteorist.presentArgument(meteorist.getArgumentAt((num2)));
                debate.countVotes(debate, meteorist, meteorist.getArgumentAt(num2));
                x = choose(Round.SECOND, znaika);
                znaika.presentArgument(znaika.getArgumentAt(x + 2));
                debate.countVotes(debate, znaika, znaika.getArgumentAt(x + 2));
                break;
            case FINAL:
                System.out.println("Слово передается " + znaika.getName());
                x = choose(Round.FINAL, znaika);
                znaika.presentArgument(znaika.getArgumentAt(x + 5));
                debate.countVotes(debate, znaika, znaika.getArgumentAt(x + 5));
                if (num2 + 1 < meteorist.getArgumentsNum() && (num1 + 1 < volcanist.getArgumentsNum() || num1 - 1 >= 0)) {
                    meteorist.presentArgument(meteorist.getArgumentAt(num2 + 1));
                    debate.countVotes(debate, meteorist, meteorist.getArgumentAt(num2 + 1));
                } else if (num2 - 1 >= 0 && (num1 + 1 < volcanist.getArgumentsNum() || num1 - 1 >= 0)) {
                    meteorist.presentArgument(meteorist.getArgumentAt(num2 - 1));
                    debate.countVotes(debate, meteorist, meteorist.getArgumentAt(num2 - 1));
                } else {
                    throw new ranOutOfArgumentsException("У" + meteorist.getName() + " и " + volcanist.getName() + " закончились аргументы.");
                }
        }
    }

    public static void finishRound(Round round, Znaika znaika, Volcanist volcanist, Meteorist meteorist) {
        System.out.println(round.getTitle() + " раунд завершен!");
        Debate.announceVotes(znaika, volcanist, meteorist);
        full:
        if (Debate.chooseWinner(znaika, volcanist, meteorist) == null) {
            System.out.println("По итогам раунда никто не лидирует");
            break full;
        } else if (Debate.chooseWinner(znaika, volcanist, meteorist).equals(znaika)) {
            System.out.println("По итогам раунда лидирует " + znaika.getName());
        } else if (Debate.chooseWinner(znaika, volcanist, meteorist).equals(volcanist)) {
            System.out.println("По итогам раунда лидирует " + volcanist.getName());
        } else if (Debate.chooseWinner(znaika, volcanist, meteorist).equals(meteorist)) {
            System.out.println("По итогам раунда лидирует " + meteorist.getName());
        }
    }

    public static void finishDebate(Znaika znaika, Volcanist volcanist, Meteorist meteorist) {
        System.out.println("Дебаты подходят к концу. Подведем итоги.");
        Debate.announceVotes(znaika, volcanist, meteorist);
        full:
        if (Debate.chooseWinner(znaika, volcanist, meteorist) == null) {
            System.out.println("Победителя определить не удалось, ничья.");
            break full;
        } else if (Debate.chooseWinner(znaika, volcanist, meteorist).equals(znaika)) {
            System.out.println("По итогам дебатов победителем стал " + znaika.getName());
        } else if (Debate.chooseWinner(znaika, volcanist, meteorist).equals(volcanist)) {
            System.out.println("По итогам дебатов победителем стал " + volcanist.getName());
        } else if (Debate.chooseWinner(znaika, volcanist, meteorist).equals(meteorist)) {
            System.out.println("По итогам дебатов победителем стал " + meteorist.getName());
        }
    }

    public static void announceVotes(Znaika znaika, Volcanist volcanist, Meteorist meteorist) {
        System.out.println("Текущие оценки участников таковы:");
        System.out.println(znaika.getName() + ":" + znaika.getRating());
        System.out.println(volcanist.getName() + ":" + volcanist.getRating());
        System.out.println(meteorist.getName() + ":" + meteorist.getRating());
    }

    public void countVotes(Debate debate, Debater debator, Argument argument) {
        double sum = 0;
        for (int i = 0; i < numberOfGuests; i++) {
            sum = sum + Guest.evaluate(argument);
        }
        Guest.evaluate(debator, sum / numberOfGuests);
    }

    public static int choose(Round round, Znaika znaika) {
        System.out.println("Выберете аргумент " + znaika.getName() + ", введите число");
        switch (round) {
            case FIRST:
                System.out.print("1. ");
                znaika.seeArgument(znaika.getArgumentAt(0));
                System.out.print("2. ");
                znaika.seeArgument(znaika.getArgumentAt(1));
                System.out.print("3. ");
                znaika.seeArgument(znaika.getArgumentAt(2));
                break;
            case SECOND:
                System.out.print("1. ");
                znaika.seeArgument(znaika.getArgumentAt(3));
                System.out.print("2. ");
                znaika.seeArgument(znaika.getArgumentAt(4));
                System.out.print("3. ");
                znaika.seeArgument(znaika.getArgumentAt(5));
                break;
            case FINAL:
                System.out.print("1. ");
                znaika.seeArgument(znaika.getArgumentAt(6));
                System.out.print("2. ");
                znaika.seeArgument(znaika.getArgumentAt(7));
                break;
        }
        int answer = scanner.nextInt();
        return answer;
    }

    public static Debater chooseWinner(Znaika znaika, Volcanist volcanist, Meteorist meteorist) {
        if (znaika.getRating() > volcanist.getRating() && znaika.getRating() > meteorist.getRating()) {
            return znaika;
        } else if (volcanist.getRating() > znaika.getRating() && volcanist.getRating() > meteorist.getRating()) {
            return volcanist;
        } else if (meteorist.getRating() > znaika.getRating() && meteorist.getRating() > volcanist.getRating()) {
            return meteorist;
        } else return null;
    }

    public int getNumberOfGuests() {
        return this.numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        if (numberOfGuests > 0) {
            this.numberOfGuests = numberOfGuests;
        } else {
            throw new IllegalArgumentException("Число гостей не может быть отрицательным."); //непроверяемое (рантайм) исключение
        }
    }

    public String toString() {
        return "Дебаты для " + this.numberOfGuests + " человек";
    }

    public int hashCode() {
        return numberOfGuests;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Debate)) return false;
        if (this.numberOfGuests == ((Debate) obj).numberOfGuests) {
            return true;
        }
        return false;
    }
}
