public class Statistics {
    private StudyProfile mainProfile;
    private float avgExamScore;
    private int countStudents;
    private int countUniversity;
    private String nameUniversity;

    public Statistics() {
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public Statistics setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getCountStudents() {
        return countStudents;
    }

    public Statistics setCountStudents(int countStudents) {
        this.countStudents = countStudents;
        return this;
    }

    public int getCountUniversity() {
        return countUniversity;
    }

    public Statistics setCountUniversity(int countUniversity) {
        this.countUniversity = countUniversity;
        return this;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public Statistics setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
        return this;
    }
}
