import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
       try {
           LogManager.getLogManager().readConfiguration(
                   Main.class.getResourceAsStream("/logging.properties"));
       } catch (Exception e) {
           System.err.println("Проблема с конфигурированием логгера: " + e.toString());
       }


        logger.log(Level.INFO, "Приложение запущено");

        String path = "src/main/resources/universityInfo.xlsx";
        ReadExcelFiles ref = new ReadExcelFiles(path);
        List<Student> students = ref.readStudents();
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.COURSE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);

        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());

        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
        });

        List<University> universities = ref.readUniversity();
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.ID);
        universities.sort(universityComparator);
        String universitysJson = JsonUtil.universityListToJson(universities);


        List<Student> universitysFromJson = JsonUtil.jsonToStudentList(universitysJson);
        System.out.println(universities.size() == universitysFromJson.size());

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
        });

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        logger.log(Level.INFO, "Приложение закрыто");
    }
}
