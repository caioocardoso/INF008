class Book {
    private int id;
    private String title;
    private String author;
    private int recomendations = 0;
    private static int count = 0;

    public Book(){
       id = count;
       count++;
    }

    public void incrementRecomendation(){
        recomendations++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(int recomendations) {
        this.recomendations = recomendations;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }

    
}