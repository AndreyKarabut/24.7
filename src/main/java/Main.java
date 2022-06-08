import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/universityInfo.xlsx";
        ReadExcelFiles ref = new ReadExcelFiles(path);
        ref.readStudents();
        ref.readUniversity();
    }
}
