package com.likelion.wisesaying;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.service.SayingService;
import java.util.Scanner;

public class Application {
    private final Scanner sc = new Scanner(System.in);
    private  final SayingService service = new SayingService();
    public void run() {
        String request = "";
        System.out.println("== 명언 앱 ==");

        while (!request.equals("종료")) {
            System.out.print("명령) ");
            request = sc.nextLine();

            // add
            if (request.equals("등록")) {
                System.out.print("명언 : ");
                String requestContent = sc.nextLine();

                System.out.print("작가 : ");
                String requestAuthor = sc.nextLine();

                Saying saying = new Saying();
                saying.setContent(requestContent);
                saying.setAuthor(requestAuthor);

                Long saveId = service.save(saying);

                System.out.println(saveId + "번 명언이 등록되었습니다.");
            }
        }
    }
}