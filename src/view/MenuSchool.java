package view;

import manager.SchoolManager;
import model.School;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSchool {
    SchoolManager schoolManager = new SchoolManager();
    MenuInput menuInput = new MenuInput();
    Scanner inputString = new Scanner(System.in);
    Scanner inputNumber = new Scanner(System.in);

    public void MenuSchool() {
        int choice;
        do {
            System.out.println("========Quản lý trường học========");
            System.out.println("1. Thêm mới trường học");
            System.out.println("2. Sửa thông tin trường học");
            System.out.println("3. Xóa trường học");
            System.out.println("4. Danh sách trường học");
            System.out.println("5. Tìm kiếm trường học theo tên gần đúng");
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
                case 0:
                    System.out.println("Thoát chương trình quản lý trường học!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAdd() {
        System.out.println("=====Thêm mới trường học=====");
        System.out.print("Nhập tên trường học: ");
        String name = inputString.nextLine();
        System.out.print("Nhập địa chỉ trường học: ");
        String address = inputString.nextLine();
        School school = new School(name, address);
        schoolManager.add(school);
        System.out.println("Thêm trường học thành công!");
    }

    public void showMenuUpdate() {
        System.out.println("=====Sửa thông tin trường học=====");
        int idUpdate;
        do {
            if(schoolManager.getAll().isEmpty()){
                System.out.println("Hiện không có trường học nào!");
                return;
            }
            System.out.print("Nhập mã trường học muốn sửa: ");
            idUpdate = menuInput.inputInteger();
            if (schoolManager.findById(idUpdate) == -1) {
                System.out.println("Mã trường học không tồn tại! Yêu cầu nhập lại");
            }
        } while (schoolManager.findById(idUpdate) == -1);
        System.out.print("Nhập tên trường học: ");
        String name = inputString.nextLine();
        System.out.print("Nhập địa chỉ trường học: ");
        String address = inputString.nextLine();
        School school = new School(idUpdate, name, address);
        schoolManager.update(idUpdate, school);
        System.out.println("Sửa thông tin trường học thành công!");
    }

    public void showMenuRemove() {
        System.out.println("=====Xóa trường học=====");
        int idRemove;

        System.out.print("Nhập mã trường học muốn xóa: ");
        idRemove = menuInput.inputInteger();
        if (schoolManager.findById(idRemove) == -1) {
            System.out.println("Mã trường học không tồn tại!");
        } else {
            schoolManager.remove(idRemove);
            System.out.println("Xóa trường học thành công!");
        }
    }

    public void showAll() {
        System.out.println("=====Danh sách trường học=====");
        for (School school : schoolManager.getAll()) {
            System.out.println(school);
        }
    }

    public void showByName() {
        System.out.println("=====Tìm kiếm trường học theo tên gần đúng=====");
        System.out.print("Nhập tên trường học muốn tìm kiếm: ");
        String name = inputString.nextLine();
        ArrayList<School> schools = schoolManager.getByName(name);
        if (schools.isEmpty()) {
            System.out.println("Không có trường học nào tên chứa " + name);
        } else {
            System.out.println("Danh sách trường học tên có chứa " + name);
            for (School school : schools) {
                System.out.println(school);
            }
        }
    }
}
