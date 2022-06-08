import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFiles {
    public String pathFile;
    public FileInputStream fis;
    public XSSFWorkbook workbook;

    public ReadExcelFiles(String pathFile) throws IOException{
        this.pathFile = pathFile;
        fis = new FileInputStream(pathFile);
        workbook = new XSSFWorkbook(fis);
    }

    public void readUniversity() {
        XSSFSheet xssfSheet = workbook.getSheet("Университеты");
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
            System.out.println(university);
        }
    }

    public void readStudents() {
        XSSFSheet xssfSheet = workbook.getSheet("Студенты");
        for (int i = 1; i < 12; i++) {
            Row row = xssfSheet.getRow(i);
            String UniversityId = row.getCell(0).getStringCellValue();
            String FullName = row.getCell(1).getStringCellValue();
            double numericCellValue = row.getCell(2).getNumericCellValue();
            int CurrentCourseNumber = (int) numericCellValue;
            double numericCellValue1 = row.getCell(3).getNumericCellValue();
            float AvgExamScore = (float) numericCellValue1;
            Student student = new Student(UniversityId, FullName, CurrentCourseNumber, AvgExamScore);
            System.out.println(student);
        }
    }
}
