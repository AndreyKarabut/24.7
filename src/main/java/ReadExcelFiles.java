import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadExcelFiles {
    public String pathFile;
    public FileInputStream fis;
    public XSSFWorkbook workbook;
    private static final Logger logger = Logger.getLogger(ReadExcelFiles.class.getName());

    public ReadExcelFiles(String pathFile) throws IOException{
        this.pathFile = pathFile;
        try {
            logger.log(Level.INFO, "Начало чтения файла");
            fis = new FileInputStream(pathFile);
            workbook = new XSSFWorkbook(fis);
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Чтение файла не удалось", e);
        }

    }

    public List<University> readUniversity(){
        List<University> universities = new ArrayList<>();
        XSSFSheet xssfSheet = workbook.getSheet("Университеты");
        try {
            for (int i = 1; i < 8; i++) {
                Row row = xssfSheet.getRow(i);
                String UniversityId = row.getCell(0).getStringCellValue();
                String FullName = row.getCell(1).getStringCellValue();
                String shortName = row.getCell(2).getStringCellValue();
                double numericCellValue = row.getCell(3).getNumericCellValue();
                int yearOfFoundation = (int) numericCellValue;
                String stringmMainProfile = row.getCell(4).getStringCellValue();
                StudyProfile mainProfile = StudyProfile.valueOf(stringmMainProfile);
                University university = new University(UniversityId, FullName, shortName, yearOfFoundation, mainProfile);
                universities.add(university);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Неправильная структура файла", e);
            return universities;
        }
        logger.log(Level.INFO, "Файл прочитан");
        return universities;
    }

    public List<Student> readStudents() {
        List<Student> students = new ArrayList<>();
        XSSFSheet xssfSheet = workbook.getSheet("Студенты");
        try{
            for (int i = 1; i < 12; i++) {
                Row row = xssfSheet.getRow(i);
                String UniversityId = row.getCell(0).getStringCellValue();
                String FullName = row.getCell(1).getStringCellValue();
                double numericCellValue = row.getCell(2).getNumericCellValue();
                int CurrentCourseNumber = (int) numericCellValue;
                double numericCellValue1 = row.getCell(3).getNumericCellValue();
                float AvgExamScore = (float) numericCellValue1;
                Student student = new Student(UniversityId, FullName, CurrentCourseNumber, AvgExamScore);
                students.add(student);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Неправильная структура файла", e);
            return students;
        }
        logger.log(Level.INFO, "Файл прочитан");
        return students;
    }
}
