package org.example.test_hw2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class filee {
    public static List<Play> plays = new ArrayList<>();
    static ObjectMapper objectMapper = new ObjectMapper();

    static File file = new File("plays.json");

    static void read(){
//        User ali = new User("alij","12345678");
//        users.add(ali);
        ObjectMapper mapper = new ObjectMapper();
        if (file.exists()) {
            try (InputStream input = new FileInputStream(file)) {
                CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, Play.class);
                plays = mapper.readValue(input, listType);
                //System.out.println("Users loaded: " + loadedUsers);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static void save(){
        try {
            objectMapper.writeValue(file,plays);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
