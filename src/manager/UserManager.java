package manager;

import model.User;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> listUser;
    private User currentUser;
    public UserManager() {
        listUser = new ArrayList<>();
        currentUser = null;
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public boolean registerUser(String name, String password) {
        if(findUserByName(name)!=null){
            return false;
        }
        listUser.add(new User(name, password));
        return true;
    }

    public boolean loginUser(String name, String password) {
        User user = findUser(name, password);
        if(user!=null){
            currentUser = user;
            return true;
        }
        return false;
    }

    public void logoutUser(){
        currentUser = null;
    }

    private User findUser(String name,String password) {
        for(User user: listUser){
            if(user.getName().equals(name)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    private User findUserByName(String name) {
        for(User user: listUser){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public String getUserInfo(){
        if(currentUser!=null){
            return currentUser.toString();
        } else {
            return "Vui lòng đăng nhập!";
        }
    }

    public ArrayList<User> getAll(){
        return listUser;
    }
}
