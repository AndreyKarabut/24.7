import org.apache.commons.lang3.StringUtils;

public class UniversityIDComparator implements UniversityComparator{
    @Override
    public int compare(University u1, University u2){
        return StringUtils.compare(u1.getId(), u2.getId());
    }
}
