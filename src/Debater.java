public abstract class Debater extends Human {
    public String name;
    public double rating;
    public Argument[] arguments;

    public Debater(String name) {
        this.name = name;
        this.rating = 0;
    }

    public void presentArgument(Argument argument) {
        System.out.println(this.name + ": " + argument.content());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setArgumentAt(int index, Argument argument) {
        if (index >= 0 && index < this.arguments.length) {
            arguments[index] = argument;
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива. Проверьте метод setArgumentAt()."); //непроверяемое(рантайм) исключение
        }
    }

    public Argument getArgumentAt(int index) throws IndexOutOfBoundsException{
        if (index >= 0 && index < this.arguments.length) {
            return this.arguments[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива. Проверьте метод getArgumentAt()."); //непроверяемое(рантайм) исключение
        }
    }

    public int getArgumentsNum() {
        return this.arguments.length;
    }


}

