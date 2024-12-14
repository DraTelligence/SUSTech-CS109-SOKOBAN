package user;

import exceptions.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.MapMatrix;

//管理user的工具类
public class UserSystem {
    private User currentUser;

    /**
     * Produce the path of saves
     * C://...//%user%//AppData//Roaming//ThereIsA_Studio//Sokoban//saves
     *
     * @return The path of the dir where saves are stored
     */
    private static Path getSavePath() {
        Path savePath;

        String rootFolder = "C:\\Users\\";
        String userFolder = System.getProperty("user.name");
        String saveFolder = "\\AppData\\Roaming\\ThereIsA_Studio\\Sokoban\\saves\\";

        savePath = Paths.get(rootFolder + userFolder + saveFolder);

        return savePath;
    }

    private static void makeSave(Path savePath, String saveCode) throws IOException {
        Files.createDirectories(savePath);

    }

    /**
     * @methodName:
     * @
     */
    private static void setUser() {

    }

    /**
     * To sign up for the user
     *
     * @param userName
     * @param pswd
     * @throws UserAlreadyExistsException
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public void signUp(String userName, String pswd) throws UserAlreadyExistsException {
        // this line is only for test!!
        try {
            Files.createDirectories(getSavePath());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        File directory = getSavePath().toFile();
        File[] fileList = directory.listFiles();

        // check if the user name has been occupied
        if (fileList != null) {
            for (File f : fileList) {
                if (f.getName().equals(userName + ".ser")) {
                    throw new UserAlreadyExistsException();
                }
            }
        }

        // sign up for the user
        this.currentUser = new User(userName, pswd);

        // create an archieve file for the user
        try {
            FileOutputStream fileOut = new FileOutputStream(getSavePath().toFile() + "\\" + userName + ".ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(this.currentUser);

            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * To log the user in, throws a exception if encounters any problem.
     *
     * @param userName
     * @param pswd
     * @throws PswdIncorrectException
     * @throws UserNotFoundException
     */
    public void logIn(String userName, String pswd)
            throws PswdIncorrectException, UserNotFoundException {
        File directory = getSavePath().toFile();
        File[] fileList = directory.listFiles();

        User temp;

        FileInputStream fin;
        ObjectInputStream oin;

        boolean flag = false;
        if (fileList != null) {
            for (File f : fileList) {
                if (f.getName().equals(userName + ".ser")) {
                    flag = true;
                    try {
                        fin = new FileInputStream(f);
                        oin = new ObjectInputStream(fin);

                        temp = (User) oin.readObject();

                        fin.close();
                        oin.close();

                        // check the pswd
                        if (temp.comparePassword(pswd)) {
                            this.currentUser=temp;
                        } else {
                            // pswd incorrect
                            throw new PswdIncorrectException();
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                        System.exit(-1);
                    }

                    break;
                }
            }
        }

        if (!flag) {
            // user not found
            throw new UserNotFoundException();
        }
    }

    /**
     * Get the current user's user ID
     *
     * @author 秦嘉曜
     * @return the id of the current user. If in guest mode, return -1
     */
    public String getCurrentUser() {
        return this.currentUser.toString();
    }

    /**
     * @author: 秦嘉曜
     * @description: update the save with new MapMatrix
     * @throw:
     */
    public void updateSave(final MapMatrix MM){
        this.currentUser.updateSave(MM);
    }
}