import java.util.Properties;
import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProperties extends Properties implements FileIO {
    public FileProperties() {
        super();
    }

    @Override
    public void readFromFile(String filename) {
        try {
            this.load(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String filename) {
        try {
            this.store(new FileWriter(filename), "written by FileProperties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setValue(String key, String value) {
        this.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return this.getProperty(key);
    }
}