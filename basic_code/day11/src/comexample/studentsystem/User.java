package comexample.studentsystem;

public class User {
    private String username;
    private String password;
    private String Card;
    private String phone;

    public User() {
    }

    public User(String username, String password, String card, String phone) {
        this.username = username;
        this.password = password;
        Card = card;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCard() {
        return Card;
    }

    public void setCard(String card) {
        Card = card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
