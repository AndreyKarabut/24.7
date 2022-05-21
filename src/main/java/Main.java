public class Main {
    public static void main(String[] args) {
        University university = new University("1", "Омский Государственный Аграрный Университет", "ОмГАУ", 1918,StudyProfile.ENGINEERE);
        Student student = new Student("Иванов Иван Иваныч", "1", 3, (float) 4.1);
        System.out.println(university);
        System.out.println(student);
    }
}
