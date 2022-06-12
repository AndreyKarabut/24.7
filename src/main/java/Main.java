import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/universityInfo.xlsx";
        ReadExcelFiles ref = new ReadExcelFiles(path);
        List<Student> students = ref.readStudents();
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.COURSE);
        students.stream().sorted(studentComparator).forEach(System.out :: println);
        List<University> universities = ref.readUniversity();
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.ID);
        universities.stream().sorted(universityComparator).forEach(System.out :: println);
    }
}
