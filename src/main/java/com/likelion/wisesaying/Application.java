package com.likelion.wisesaying;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.service.SayingService;
import com.likelion.wisesaying.util.exception.CustomRequestException;
import com.likelion.wisesaying.util.file.LocalDataLoad;
import com.likelion.wisesaying.util.file.LocalDataSave;
import com.likelion.wisesaying.util.gson.GsonDataConverter;
import java.util.Scanner;

public class Application {
    private final Scanner sc = new Scanner(System.in);
    private final SayingService service = new SayingService();
    private final LocalDataSave localDataSave = new LocalDataSave();
    private final LocalDataLoad localDataLoad = new LocalDataLoad();
    private final GsonDataConverter gson = new GsonDataConverter();


    public void run() {
        localDataLoad.load();
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

            // list
            if (request.equals("목록")) {
                System.out.println("번호\t/\t작가\t/\t명언\n----------------------");
                for (Saying saying : service.findAllReverse()) {
                    System.out.println(saying.getId() + "\t/\t" + saying.getAuthor() + "\t/\t" + saying.getContent());
                }
            }

            // delete
            if (request.startsWith("삭제")) {
                Long deleteId;

                try {
                    deleteId = service.delete(request);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (CustomRequestException e) {
                    continue;
                }

                System.out.println(deleteId + "번 명언이 삭제되었습니다.");
            }

            // update
            if (request.startsWith("수정")) {
                Saying saying;
                try {
                    saying = service.update(request);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (CustomRequestException e) {
                    continue;
                }
                System.out.println("명언(기존) : " + saying.getContent());
                System.out.print("명언 : ");
                String updateContent = sc.nextLine();
                System.out.println("작가(기존) : " + saying.getAuthor());
                System.out.print("작가 : ");
                String updateAuthor = sc.nextLine();
                saying.setAuthor(updateAuthor);
                saying.setContent(updateContent);
            }

            // build
            if (request.equals("빌드")) {
                String jsonStr = gson.sayingToJson(service.findAll());
                localDataSave.saveJson(jsonStr);
            }
        }
        localDataSave.saveTxt();
    }

    public void dummyDataInit() {
        for (int i = 0; i < 5; i++) {
            Saying saying = new Saying();
            saying.setContent("test content " + (i + 1));
            saying.setAuthor("test author " + (i + 1));
            service.save(saying);
        }
    }
}