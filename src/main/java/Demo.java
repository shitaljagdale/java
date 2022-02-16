import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Demo {

    public static String asYaml(String file) throws IOException {

        String result;
        result = new String(Files.readAllBytes(Paths.get(file)));
        // parse JSON
        JsonNode jsonNodeTree = new ObjectMapper().readTree(result);
        // save it as YAML
        String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
        //System.out.println(jsonAsYaml);


        ObjectMapper om = new ObjectMapper(new YAMLFactory());

// We write the `employee` into `person2.yaml`
        om.writeValue(new File("/Users/shitaljadhav/Desktop/shital/JsonToYMLConversion/src/main/resources/output.yaml"), jsonAsYaml);
        return jsonAsYaml;
    }

    public static void main(String[] args) throws Exception {
        String path;
        path = "/Users/shitaljadhav/Desktop/shital/JsonToYMLConversion/src/main/java/input.json";
        // call convertFileIntoString() method that will return the file data as string. We store the returned data into file variable
        System.out.println(asYaml(path));

    }
}
