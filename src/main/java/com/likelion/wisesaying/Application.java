package com.likelion.wisesaying;

import java.util.Scanner;

public class Application {
    private final Scanner sc = new Scanner(System.in);
    public void run() {
        String request = "";
        System.out.println("== 명언 앱 ==");

        while (!request.equals("종료")) {
            System.out.print("명령) ");
            request = sc.nextLine();
        }
    }
}