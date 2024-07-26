package model;

public class School {
    private int id;
    private String name;
    private String address;
    private static int idIncrement = 1;

    public School() {
    }

    public School(String name, String address) {
        this.id = idIncrement;
        this.name = name;
        this.address = address;
        idIncrement ++;
    }

    public School(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        School.idIncrement = idIncrement;
    }

    public String toString(){
        return "Mã trường học: " + id +
                "\nTên trường học: " + name +
                "\nĐịa chỉ trường học: " + address;
    }
}
