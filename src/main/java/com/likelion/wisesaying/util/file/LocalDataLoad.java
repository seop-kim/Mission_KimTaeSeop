package com.likelion.wisesaying.util.file;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.service.SayingService;
import com.likelion.wisesaying.util.generator.IdGenerator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LocalDataLoad {
    private static final String USER_HOME_PATH = System.getProperty("user.home");
    private static final String FILE_PATH = USER_HOME_PATH + "/workspace/saveSayingsData.txt";
    private final SayingService service = new SayingService();
    private final IdGenerator generator = new IdGenerator();

    public void load() {
        System.out.println(FILE_PATH);

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] len = line.split(",");

                if (len.length == 3) {
                    Long loadPostNum = Long.parseLong(len[0]);
                    String loadAuthor = len[1];
                    String loadSentence = len[2];

                    Saying saying = new Saying();
                    saying.setId(loadPostNum);
                    saying.setAuthor(loadAuthor);
                    saying.setContent(loadSentence);

                    service.load(saying);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
