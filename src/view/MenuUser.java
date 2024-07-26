package view;

import manager.UserManager;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUser {
    UserManager userManager = new UserManager();
    MainMenu mainMenu = new MainMenu();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void MenuUser() {
        int choice;
        do {
            System.out.println("========Quản lý tài khoản========");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Quản lý");
            System.out.println("4. Đăng xuất");
            System.out.println("5. Danh sách tài khoản");
            System.out.println("6. Tài khoản đang đăng nhập");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    showMenuLogin();
                    break;
                case 2:
                    showMenuRegister();
                    break;
                case 3:
                    if (userManager.getCurrentUser() != null) {
                        mainMenu.MainMenu();
                    } else {
                        System.out.println("Bạn phải đăng nhập để truy cập!");
                    }
                    break;
                case 4:
                    userManager.logoutUser();
                    System.out.println("Đăng xuất thành công!");
                    break;
                case 5:
                    showAll();
                    break;
                case 6:
                    showCurrentUser();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuRegister() {
        System.out.println("=====Đăng ký tài khoản=====");
        System.out.print("Nhập tên người dùng: ");
        String userName = inputString.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = inputString.nextLine();
        if (userManager.registerUser(userName, password)) {
            System.out.println("Đăng ký tài khoản thành công!");
        } else {
            System.out.println("Tên người dùng đã tồn tại!");
        }
    }

    public void showMenuLogin() {
        System.out.println("=====Đăng nhập=====");
        if (userManager.getAll().isEmpty()) {
            System.out.println("Hiện không có tài khoản!");
            return;
        }
        System.out.print("Nhập tên người dùng: ");
        String userName = inputString.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = inputString.nextLine();
        if (userManager.loginUser(userName, password)) {
            System.out.println("Đăng nhập thành công!");
            System.out.println("Tài khoản hiện tại: " + userName);
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    public void showAll() {
        System.out.println("=====Danh sách tài khoản=====");
        ArrayList<User> users = userManager.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void showCurrentUser() {
        System.out.println("Tài khoản đang đăng nhập");
        System.out.println(userManager.getUserInfo());
    }
}
