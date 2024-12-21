public enum Round {
    FIRST("Первый"),
    SECOND("Второй"),
    FINAL("Финальный");
    private String title;

    Round(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
