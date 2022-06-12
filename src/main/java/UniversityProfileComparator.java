import org.apache.commons.lang3.StringUtils;

public interface UniversityProfileComparator implements UniversityComparator{
    @Override
    public int compare(University u1, University u2){
        if (u1.getMainProfile() == null){
            return 1;
        } else if(u2.getMainProfile() == null){
            return -1;
        }
        return StringUtils.compare(u1.getMainProfile().name(), u2.getMainProfile().name());
    }
}
