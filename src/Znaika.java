public class Znaika extends Debater {
    private String name;
    private double rating;
    private Argument[] arguments;

    Znaika(String name) {
        super(name);
        this.arguments = new Argument[]{
                new Argument("Вулкан — это очень большая гора, на верхушке которой имеется сравнительно небольшой кратер, то есть отверстие. Если бы хоть один лунный кратер был кратером вулкана, то сам вулкан был бы величиной чуть ли не во всю Луну, а этого вовсе не наблюдается.", 1),
                new Argument("На Луне имеются трещины и другие геологические формации, которые мог бы создать процесс выхода горячих газов, а не только эффекты ударов и вулканической активности.", 0.5),
                new Argument("Ваша теория абсурдна, на Луне нет никакой вулканической активности.", 0),
                new Argument("Даже теория Метеоритчиков более убедительна, чем теория Вулканистов.", 0),
                new Argument("Метеориты могли падать на Луну не только отвесно, но и под наклоном и в таком случае оставляли бы следы не круглые, а вытянутые, продолговатые или овальные. Между тем на Луне все кратеры в основном круглые, а не овальные.", 1),
                new Argument("Напомню о разнообразии форм и размеров кратеров на Луне, что может свидетельствовать о различных процессах их образования.", 1),
                new Argument("Существуют кратеры, образованные в результате вулканической активности, но в некоторых случаях кратеры образуются именно из-за выбросов газа.", 0),
                new Argument("Можно предположить, что раньше Луна была раскаленным шаром, но затем ее поверхность начала остывать. Поверхность Луны подобна блину. Пока блин жидкий, его поверхность совершенно гладкая, но по мере того как он подогревается на сковородке, на его поверхности начинают появляться пузырьки нагретого пара. Проступив на поверхность блина, пузырьки лопаются, в результате чего на блине образуются неглубокие дырки, которые так и остаются, когда тесто как следует пропечётся и потеряет вязкость.", 1)
        };
    }

    public void seeArgument(Argument argument) {
        System.out.println(argument.content());
    }

    public Argument getArgumentAt(int index) {
        if (index >= 0 && index < this.arguments.length) {
            return this.arguments[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива.Проверьте метод getArgumentAt()."); //непроверяемое(рантайм) исключение
        }
    }

    public int getArgumentsNum() {
        return this.arguments.length;
    }

    public void setArgumentAt(int index, Argument argument) {
        if (index >= 0 && index < this.arguments.length) {
            arguments[index] = argument;
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива.Проверьте метод setArgumentAt()."); //непроверяемое(рантайм) исключение
        }
    }

    public String toString() {
        return name + rating;
    }

    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Znaika)) return false;
        if(!(this.name.equals(((Znaika) obj).name) || this.rating == ((Znaika) obj).rating) || this.arguments.length ==((Znaika) obj).arguments.length) {
            return false;
        }
        for(int i = 0; i < this.arguments.length; i++) {
            if(!(this.arguments[i].equals(((Znaika) obj).arguments[i]))) {
                return false;
            }
        }
        return true;
    }
}
