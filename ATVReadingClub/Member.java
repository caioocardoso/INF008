import java.util.ArrayList;

class Member {
    private int id;
    private String cpf;
    private String name;
    private static int countMember = 0;
    private ArrayList<Integer> readingHistory = new ArrayList<>();

    public Member(String cpf, String name){
        this.cpf = cpf;
        this.name = name;
        id = countMember;
        countMember++;
    }

    public void read(int bookId){
        readingHistory.add(bookId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCountMember() {
        return countMember;
    }

    public static void setCountMember(int countMember) {
        Member.countMember = countMember;
    }

    public ArrayList<Integer> getReadingHistory() {
        return readingHistory;
    }

    public void setReadingHistory(ArrayList<Integer> readingHistory) {
        this.readingHistory = readingHistory;
    }

    
}