package model.user;

import model.exceptions.PswdIncorrectException;
import java.io.Serial;
import java.io.Serializable;
import model.game.Map;

//储存用户信息，提供从读取存档文件创建user
public class User implements Serializable {
    /**
     * Stores the information of the user
     */
    final private String userName;

    @Serial
    private String pswd;
    @Serial
    private Save save;

    /**
     * to see if the pswd is correct or not
     *
     * @param pswd give a pswd to try
     * @return true if the password is correct
     */
    boolean comparePassword(String pswd) {
        return pswd.equals(this.pswd);
    }

    /**
     * the constructor of User
     * 
     * @author
     * @param userName the name of the user
     * @param pswd     the passwoed of the account
     */
    User(String userName, String pswd) {
        this.userName = userName;
        this.pswd = pswd;
        this.save= new Save();
    }

    public void changePassword(String oldPassword, String newPassword) throws PswdIncorrectException {
        if (comparePassword(oldPassword)) {
            this.pswd = newPassword;
        } else {
            throw new PswdIncorrectException();
        }
    }

    void updateSave(Map map) {
        this.save.setCurrMap(map);
    }

    Save getSave() {
        return save;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("userName=").append(userName);
        sb.append(", pswd=").append(pswd);
        return sb.toString();
    }
}
