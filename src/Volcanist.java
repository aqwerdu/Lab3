public class Volcanist extends ZnaikaOpponent {
    private String name;
    private double rating;
    private int numberOfArguments;
    private Argument[] arguments;

    Volcanist(String name) {
        super(name);
        this.arguments = new Argument[]{
                new Argument("Схожесть кратеров Луны с вулканическими кратерами на Земле и других планетах очевидна. Форма и размеры кратеров на Луне точно соответствуют формированию через лавовые извержения.", 1)
        };
    }

    public void insultZnaika(Znaika znaika) {
        System.out.println("Смешно даже сравнивать Луну, которая является крупным космическим телом, с каким-то несчастным блином из прокисшего теста!");
    }

    public Argument getArgumentAt(int index) {
        if (index >= 0 && index < this.arguments.length) {
            return this.arguments[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива. Проверьте метод getArgumentAt()."); //непроверяемое(рантайм) исключение
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
        if (!(obj instanceof Volcanist)) return false;
        if(!(this.name.equals(((Volcanist) obj).name) || this.rating == ((Volcanist) obj).rating) || this.arguments.length ==((Volcanist) obj).arguments.length) {
            return false;
        }
        for(int i = 0; i < this.arguments.length; i++) {
            if(!(this.arguments[i].equals(((Volcanist) obj).arguments[i]))) {
                return false;
            }
        }
        return true;
    }
}
