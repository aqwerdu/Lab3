public class Main {
    public static void main(String[] args) {
        Znaika znaika = new Znaika("Знайка");
        Volcanist volcanist = new Volcanist("Вулканист");
        Meteorist meteorist = new Meteorist("Метеоритчик");
        Debate debate = new Debate(5);
        Debate.startDebate(znaika, volcanist, meteorist);
        try {
            try {
                debate.startRound(Round.FIRST, znaika, volcanist, meteorist, debate);
            } catch (ranOutOfArgumentsException e1) {
                meteorist.insultZnaika(znaika);
                volcanist.insultZnaika(znaika);
            }
            Debate.finishRound(Round.FIRST, znaika, volcanist, meteorist);
            try {
                debate.startRound(Round.SECOND, znaika, volcanist, meteorist, debate);
            } catch (ranOutOfArgumentsException e1) {
                meteorist.insultZnaika(znaika);
                volcanist.insultZnaika(znaika);
            }
            Debate.finishRound(Round.SECOND, znaika, volcanist, meteorist);
            try {
                debate.startRound(Round.FINAL, znaika, volcanist, meteorist, debate);
            } catch (ranOutOfArgumentsException e1) {
                meteorist.insultZnaika(znaika);
                volcanist.insultZnaika(znaika);
            }
            Debate.finishDebate(znaika, volcanist, meteorist);
        }catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }
}