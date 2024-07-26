package model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private int age;
    private double[] mark;
    private static int idIncrement = 1;

    public Student() {
    }

    public Student(String name, int age, double[] mark) {
        this.id = idIncrement;
        this.name = name;
        this.age = age;
        this.mark = mark;
        idIncrement++;
    }

    public Student(int id, String name, int age, double[] mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mark = mark;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double[] getMark() {
        return mark;
    }

    public void setMark(double[] mark) {
        this.mark = mark;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Student.idIncrement = idIncrement;
    }

    public double getAverageMark(){
        double sum = 0;
        for(int i = 0; i < mark.length; i++){
            sum += mark[i];
        }
        return (double)Math.round((sum/mark.length)*100)/100 ;
    }

    public String toString() {
        return "Mã sinh viên: " + id +
               "\nTên sinh viên: " + name +
               "\nTuổi sinh viên: " + age +
               "\nĐiểm số: " + Arrays.toString(mark) +
               "\nĐiểm trung bình: " + getAverageMark();
    }
}
