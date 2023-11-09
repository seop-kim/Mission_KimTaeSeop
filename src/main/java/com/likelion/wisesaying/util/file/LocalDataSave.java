package com.likelion.wisesaying.util.file;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.service.SayingService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDataSave {
    private static final String USER_HOME_PATH = System.getProperty("user.home");
    private static final String FILE_PATH = USER_HOME_PATH + "/workspace";
    private static final SayingService service = new SayingService();

    public void saveTxt() {
        String fileName = "/saveSayingsData.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + fileName))) {

            for (Saying saying : service.findAllReverse()) {
                String saveData =
                        String.format("%d,%s,%s", saying.getId(), saying.getAuthor(),
                                saying.getContent());
                writer.write(saveData);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public void saveJson(String jsonStr) {
        String fileName = "/saveJsonSayings.json";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + fileName))) {
            writer.write(jsonStr);

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
