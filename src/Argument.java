record Argument(String content, double power) {
    public boolean equals(Object obj) {
        if (!(obj instanceof Argument)) return false;
        if(this.content.equals(((Argument) obj).content) & this.power == ((Argument) obj).power) {
            return true;
        } else return false;
    }
}
