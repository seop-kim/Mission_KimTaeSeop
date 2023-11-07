package com.likelion.wisesaying.util.file;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.service.SayingService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDataSave {
    private static final String USER_HOME_PATH = System.getProperty("user.home");
    private static final String FILE_PATH =  USER_HOME_PATH +"/workspace/saveWiseData.txt";
    private static final SayingService service = new SayingService();
    public void save() {
        try {
            // 파일 생성 및 텍스트 작성을 위한 버퍼드 객체 생성
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));

            // 반복문을 통해 wiseArr에 들어있는 데이터를 txt 파일에 순차적 작성
            for (Saying saying : service.findAll()) {
                String saveData =
                        String.format("%d,%s,%s", saying.getId(), saying.getAuthor(),
                        saying.getContent());
                writer.write(saveData);
                writer.newLine();
            }

            // 버퍼드 객체 close
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
