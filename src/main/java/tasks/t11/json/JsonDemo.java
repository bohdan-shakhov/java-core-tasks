package tasks.t11.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import tasks.t11.User;

import java.io.File;
import java.io.IOException;

public class JsonDemo {
    public static void main(String[] args) throws IOException {
        User user = new User("USER", 20);
        File file = serialization(user);
        User user1 = deserialization(file);
        System.out.println(user1);
    }

    static File serialization(User user) throws IOException {
        File file = null;
        try {
            file = new File("src/main/java/tasks/t11/json/object.json");
            if (!file.createNewFile())
                System.out.println("file already exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, user);
        return file;
    }

    static User deserialization(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, User.class);
    }
}
