public class Meteorist extends ZnaikaOpponent {
    private String name;
    private double rating;
    private int numberOfArguments;
    private Argument[] arguments;

    Meteorist(String name) {
        super(name);
        this.numberOfArguments = 1;
        this.arguments = new Argument[]{
                new Argument("Конечно, лунные кратеры — не вулканы, но они так же и не блины. Всем известно, что это следы от ударов метеоритов.", 1)
        };
    }

    public void insultZnaika(Znaika znaika) {
        System.out.println(znaika.getName() + ", Вы блинист!");
    }

    public Argument getArgumentAt(int index) {
        if (index >= 0 && index < this.arguments.length) {
            return this.arguments[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива.Проверьте метод getArgumentAt()."); //непроверяемое(рантайм) исключение
        }
    }

    public void setArgumentAt(int index, Argument argument) {
        if (index >= 0 && index < this.arguments.length) {
            arguments[index] = argument;
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива.Проверьте метод setArgumentAt()."); //непроверяемое(рантайм) исключение
        }
    }

    public int getArgumentsNum() {
        return this.arguments.length;
    }

    public String toString() {
        return name + rating;
    }

    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Meteorist)) return false;
        if(!(this.name.equals(((Meteorist) obj).name) || this.rating == ((Meteorist) obj).rating) || this.arguments.length ==((Meteorist) obj).arguments.length) {
            return false;
        }
        for(int i = 0; i < this.arguments.length; i++) {
            if(!(this.arguments[i].equals(((Meteorist) obj).arguments[i]))) {
                return false;
            }
        }
        return true;
    }
}
