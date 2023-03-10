import java.util.ArrayList;

public class LocalDatabase implements DatabaseObserver {
    private static ArrayList<CvOwner> cvOwners;
    private static LocalDatabase instance;
    private static final CvOwnerDao dbHelper = new CvOwnerDaoImpl();


    private LocalDatabase() {
    }

    public static ArrayList<CvOwner> getLocalDatabase() {
        if (cvOwners == null) {
            cvOwners = dbHelper.getAll();

        }
        return cvOwners;
    }

    public static LocalDatabase getInstance() {
        if (instance == null) {
            instance = new LocalDatabase();
        }
        return instance;

    }
    @Override
    public void update(CvOwner person, int operation) {
        switch (operation) {
            case 1:
                cvOwners.add(person);
                break;
            case 2:
                cvOwners.remove(person);
                break;
            case 3:
                cvOwners.removeAll(cvOwners);
        }
    }

}
