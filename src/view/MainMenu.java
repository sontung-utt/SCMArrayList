package view;

import manager.UserManager;

import java.util.Scanner;

public class MainMenu {
    MenuStudent menuStudent = new MenuStudent();
    MenuSchool menuSchool = new MenuSchool();
    UserManager userManager = new UserManager();
    Scanner inputNumber = new Scanner(System.in);

    public void MainMenu(){
        int choice;
        do{
            System.out.println("==========Quản lý==========");
            System.out.println("1. Thông tin tài khoản");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Quản lý trường học");
            System.out.println("0. Thoát chương trình!");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch(choice){
                case 1:
                    System.out.println(userManager.getUserInfo());
                    break;
                case 2:
                    menuStudent.MenuStudent();
                    break;
                case 3:
                    menuSchool.MenuSchool();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
