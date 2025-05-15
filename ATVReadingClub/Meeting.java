import java.util.HashSet;

class Meeting {
    private String date;
    private String theme;
    private HashSet<Integer> participants = new HashSet<>();

    public Meeting(String date, String theme, Integer idParticipant){
        this.date = date;
        this.theme = theme;
        participants.add(idParticipant);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public HashSet<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participant) {
        this.participants.add(participant);
    }


    
}