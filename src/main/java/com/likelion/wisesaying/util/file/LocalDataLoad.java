package com.likelion.wisesaying.util.file;

import com.likelion.wisesaying.domain.Saying;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalDataLoad {
    private static final String USER_HOME_PATH = System.getProperty("user.home");
    private static final String FILE_PATH = USER_HOME_PATH + "/workspace/saveSayingsData.txt";

    public List<Saying> load() {
        List<Saying> sayings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] len = line.split(",");

                if (len.length == 3) {
                    Long loadPostNum = Long.parseLong(len[0]);
                    String loadAuthor = len[1];
                    String loadContent = len[2];

                    Saying saying = new Saying(loadPostNum, loadContent, loadAuthor);

                    sayings.add(saying);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sayings;
    }
}
