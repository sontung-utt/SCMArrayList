package view;

import java.util.Scanner;

public class MenuInput {
    Scanner input = new Scanner(System.in);
    public int inputInteger() {
        do {
            try {
                int num = Integer.parseInt(input.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Yêu cầu nhập số nguyên: ");
            }
        } while (true);
    }

    public double inputDouble() {
        do {
            try {
                double num = Double.parseDouble(input.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Yêu cầu nhập số thực: ");
            }
        } while (true);
    }
}
