import java.awt.*;
import java.util.HashSet;

public class UserAccount {
    private String name;
    private String password;

    public UserAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Accounts {
        public final static HashSet<UserAccount> accountsList = new HashSet<>();
        static {
            accountsList.add(new UserAccount("Oleg", "23"));
            accountsList.add(new UserAccount("howEver", "123"));
        }
        public static UserAccount findUser(String name, String password) {
            UserAccount userAccount = accountsList.stream().filter(x -> x.getName().equals(name) && x.getPassword().equals(password)).findFirst().get();
            if (userAccount == null) {
                return null;
            }
            return userAccount;
        }
    }
}
