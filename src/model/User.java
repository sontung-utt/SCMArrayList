package model;

public class User {
    private int id;
    private String name;
    private String password;
    private static int idIncrement = 1;
    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.id = idIncrement;
        this.name = name;
        this.password = password;
        idIncrement++;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getIdIncrement(){
        return idIncrement;
    }

    public void setIdIncrement(int idIncrement){
        User.idIncrement = idIncrement;
    }

    public String toString(){
        return "Mã người dùng: " + id +
                "\nTên người dùng: " + name +
                "\nPassword: " + password;
    }
}
