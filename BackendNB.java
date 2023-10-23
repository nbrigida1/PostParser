import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BackendNB extends CHSearchBackendBD{
    /**
     * Initialize backend to make use of the provided HashtableWithDuplicateKeys and
     * PostReader, and initialize the number of posts in this dataset to 0.
     *
     * @param hashtable  placeholder by me, working implementation by
     *                   AlgorithmEngineer
     * @param postReader placeholder by me, working implementation by DataWrangler
     */
    public BackendNB(HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable, PostReaderInterface postReader) {
        super(hashtable, postReader);
    }

    @Override
    public void loadData(String filename) throws FileNotFoundException {
        System.out.println("Ltest");
    }

    @Override
    public List<String> findPostsByTitleWords(String words) {
        List<String> tester = new ArrayList<String>();
        tester.add("Ttest");
        return tester;
    }

    @Override
    public List<String> findPostsByBodyWords(String words) {
        List<String> tester = new ArrayList<String>();
        tester.add("Btest");
        return tester;
    }

    @Override
    public List<String> findPostsByTitleOrBodyWords(String words) {
        List<String> tester = new ArrayList<String>();
        tester.add("Ptest");
        return tester;
    }

    @Override
    public String getStatisticsString() {
        return  "Stest";
    }
}

