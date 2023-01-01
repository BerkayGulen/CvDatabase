import java.util.ArrayList;

public interface CvOwnerDao {
    void add(CvOwner person);
    void delete(CvOwner person);
    void deleteAll();
    ArrayList<CvOwner> getAll();
}
