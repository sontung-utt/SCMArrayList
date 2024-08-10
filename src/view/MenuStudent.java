package view;

import manager.StudentManager;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuStudent {
    StudentManager studentManager = new StudentManager();
    MenuInput menuInput = new MenuInput();
    Scanner inputString = new Scanner(System.in);
    Scanner inputNumber = new Scanner(System.in);
    public void MenuStudent() {
        int choice;
        do{
            System.out.println("========Menu quản lý sinh viên========");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Danh sách sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên gần đúng");
            System.out.println("6. Tìm kiếm sinh viên trong khoảng điểm");
            System.out.println("7. Tìm kiếm sinh viên theo khoảng tuổi");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = menuInput.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuUpdate();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    showByName();
                    break;
                case 6:
                    showByRangeMark();
                    break;
                case 7:
                    showByRangeAge();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý sinh viên!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAdd(){
        System.out.println("=====Thêm mới sinh viên=====");
        System.out.print("Nhập tên sinh viên: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int age = menuInput.inputInteger();
        System.out.println("Nhập điểm sinh viên");
        double[] marks = new double[3];
        for(int i = 0; i<marks.length; i++){
            do {
                System.out.print("Nhập điểm thứ " + (i + 1) + ": ");
                marks[i] = menuInput.inputDouble();
                if (marks[i] < 0 || marks[i] > 10) {
                    System.out.println("Điểm thứ " + (i + 1) + " không hợp lệ. Yêu cầu nhập lại!");
                }
            } while (marks[i] < 0 || marks[i] > 10);
        }
        Student student = new Student(name, age, marks);
        studentManager.add(student);
        System.out.println("Thêm sinh viên thành công!");
    }

    public void showAll(){
        System.out.println("=====Danh sách sinh viên=====");
        for(Student student: studentManager.getAll()){
            System.out.println(student);
        }
    }

    public void showMenuRemove(){
        System.out.println("=====Xóa sinh viên=====");
        int idRemove;
        System.out.print("Nhập mã sinh viên muốn xóa: ");
        idRemove = menuInput.inputInteger();
        if(studentManager.findById(idRemove)==-1){
            System.out.println("Mã sinh viên không tồn tại!");
        } else {
            studentManager.remove(idRemove);
            System.out.println("Xóa sinh viên thành công!");
        }
    }

    public void showMenuUpdate(){
        int idUpdate;
        System.out.println("=====Sửa thông tin sinh viên=====");
        do{
            if(studentManager.getAll().isEmpty()){
                System.out.println("Hiện không có sinh viên nào!");
                return;
            }
            System.out.print("Nhập mã sinh viên muốn sửa: ");
            idUpdate = menuInput.inputInteger();
            if(studentManager.findById(idUpdate)==-1){
                System.out.println("Mã sinh viên không tồn tại! Yêu cầu nhập lại.");
            }
        } while (studentManager.findById(idUpdate)==-1);
        System.out.print("Nhập tên sinh viên: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int age = menuInput.inputInteger();
        System.out.println("Nhập điểm sinh viên");
        double[] marks = new double[3];
        for(int i = 0; i<marks.length; i++){
            do {
                System.out.print("Nhập điểm thứ " + (i + 1) + ": ");
                marks[i] = menuInput.inputDouble();
                if (marks[i] < 0 || marks[i] > 10) {
                    System.out.println("Điểm thứ " + (i + 1) + " không hợp lệ. Yêu cầu nhập lại!");
                }
            } while (marks[i] < 0 || marks[i] > 10);
        }
        Student student = new Student (idUpdate, name, age, marks);
        studentManager.update(idUpdate, student);
        System.out.println("Sửa thông tin sinh viên thành công!");
    }

    public void showByName(){
        System.out.println("=====Tìm kiếm sinh viên theo tên gần đúng=====");
        System.out.print("Nhập tên sinh viên muốn tìm kiếm: ");
        String name = inputString.nextLine();
        ArrayList<Student> students = studentManager.getByName(name);
        if(students.isEmpty()){
            System.out.println("Không có sinh viên nào tên chứa " + name);
        } else {
            System.out.println("Danh sách sinh viên tên có chứa " + name);
            for(Student student: students){
                System.out.println(student);
            }
        }
    }

    public void showByRangeMark(){
        System.out.println("=====Tìm kiếm sinh viên trong khoảng điểm=====");
        double minMark, maxMark;

        do{
            do{
                System.out.print("Nhập điểm trung bình bé nhất: ");
                minMark = menuInput.inputDouble();
                if(minMark < 0 || minMark > 10){
                    System.out.println("Điểm không hợp lệ! Yêu cầu nhập lại.");
                }
            }while (minMark < 0 || minMark > 10);
            do{
                System.out.print("Nhập điểm trung bình lớn nhất: ");
                maxMark = menuInput.inputDouble();
                if(maxMark < 0 || maxMark > 10){
                    System.out.println("Điểm không hợp lệ! Yêu cầu nhập lại.");
                }
            } while (maxMark < 0|| maxMark > 10);
            if(minMark >= maxMark){
                System.out.println("Nhập không hợp lệ! Yêu cầu nhập lại.");
            }
        } while (minMark >= maxMark);

        ArrayList<Student> students = studentManager.getByRangeMark(minMark, maxMark);
        if(students.isEmpty()){
            System.out.println("Không có sinh viên nào có điểm trung bình từ " + minMark + " đến " + maxMark);
        } else {
            System.out.println("Danh sách sinh viên có điểm trung bình từ " + minMark + " đến " + maxMark);
            for(Student student: students){
                System.out.println(student);
            }
        }
    }

    public void showByRangeAge(){
        System.out.println("=====Tìm kiếm sinh viên theo khoảng tuổi=====");
        int minAge, maxAge;
        do{
            System.out.print("Nhập tuổi bé nhất: ");
            minAge= menuInput.inputInteger();
            System.out.print("Nhập tuổi lớn nhất: ");
            maxAge= menuInput.inputInteger();
            if(minAge > maxAge){
                System.out.println("Nhập tuổi không hợp lệ! Yêu cầu nhập lại.");
            }
        }while (minAge >= maxAge);
        ArrayList<Student> students = studentManager.getByRangeAge(minAge, maxAge);
        if(students.isEmpty()){
            System.out.println("Không có sinh viên nào có tuổi từ " + minAge + " đến " + maxAge);
        } else {
            System.out.println("Danh sách sinh viên có tuổi từ " + minAge + " đến " + maxAge);
            for(Student student: students){
                System.out.println(student);
            }
        }
    }
}
