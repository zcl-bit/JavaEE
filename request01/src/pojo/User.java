package pojo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 包名:com.itheima.pojo
 *
 * @author Leevi
 * 日期2020-10-14  09:46
 */
public class User implements Serializable{
    private String username;
    private String[] hobby;
    private String password;
    private String nickname;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
