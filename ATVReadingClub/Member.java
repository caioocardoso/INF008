import java.util;

class Member {
    private String cpf;
    private String name;
    private static int countMember;
    private List<Integer> readingHistory = new ArrayList<>();

    public Member(String cpf, String name){
        this.cpf = cpf;
        this.name = name;
        countMember++;
    }

    public read(int bookId){
        readingHistory.add(bookId);
    }

    public recomendate(int bookId){
    }
}