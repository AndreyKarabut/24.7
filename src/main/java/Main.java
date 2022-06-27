import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/universityInfo.xlsx";
        ReadExcelFiles ref = new ReadExcelFiles(path);
        List<Student> students = ref.readStudents();
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.COURSE);
        //students.stream().sorted(studentComparator).forEach(System.out :: println);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsJson);

        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());

        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });

        List<University> universities = ref.readUniversity();
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.ID);
        universities.sort(universityComparator);
        //universities.stream().sorted(universityComparator).forEach(System.out :: println);
        universities.sort(universityComparator);
        String universitysJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitysJson);

        List<Student> universitysFromJson = JsonUtil.jsonToStudentList(universitysJson);
        System.out.println(universities.size() == universitysFromJson.size());

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");
    }
}
