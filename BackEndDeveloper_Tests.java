import java.util.List;
import java.util.Scanner;

public class BackEndDeveloper_Tests {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Frontend Integration Test 1: " + (Integrationtest1() ? "passed" : "failed"));
        System.out.println("Frontend Integration Test 2: " + (Integrationtest2() ? "passed" : "failed"));
        System.out.println("Frontend Partner (Backend) Test 1: " + (OtherRoleTest1() ? "passed" : "failed"));
        System.out.println("Frontend Partner (Backend) Test 4: " + (OtherRoleTest2() ? "passed" : "failed"));
    }


    public static boolean Integrationtest1()
    {
        //tests valid load data and search functions
        TextUITester uiTester = new TextUITester("L\ndata/small.txt\nP\nfood\nQ\nQ\n");
        try {
            PostReaderInterface postLoader = new PostReaderDW();
            HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
            hashtable = new HashtableWithDuplicateKeysAE<>();
            CHSearchBackendInterface backend = new CHSearchBackendBD(hashtable, postLoader);
            Scanner scanner = new Scanner(System.in);
            CHSearchFrontendFD frontend = new CHSearchFrontendFD(scanner, (CHSearchBackendBD) backend);
            frontend.runCommandLoop();
        }
        catch (Exception e)
        {
            String systemOutput = uiTester.checkOutput();
            return false;
        }
        String systemOutput = uiTester.checkOutput();
        return true;
    }

    public static boolean Integrationtest2()
    {
        TextUITester uiTester = new TextUITester("L\ndata/notafile.txt\nQ\n");
        try {
            PostReaderInterface postLoader = new PostReaderDW();
            HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
            hashtable = new HashtableWithDuplicateKeysAE<>();
            CHSearchBackendInterface backend = new CHSearchBackendBD(hashtable, postLoader);
            Scanner scanner = new Scanner(System.in);
            CHSearchFrontendFD frontend = new CHSearchFrontendFD(scanner, (CHSearchBackendBD) backend);
            frontend.runCommandLoop();
        }
        catch (RuntimeException e)
        {
            String systemOutput = uiTester.checkOutput();
            return true;
        }
        String systemOutput = uiTester.checkOutput();
        return false;
    }

    public static boolean OtherRoleTest1()
    {
        PostReaderInterface postLoader = new PostReaderDW();
        HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
        hashtable = new HashtableWithDuplicateKeysAE<>();
        CHSearchBackendInterface backend = new CHSearchBackendBD(hashtable, postLoader);
        List<String> returned;
        try
        {
            backend.loadData("data/small.txt");
            returned = backend.findPostsByTitleWords("Chickpea");
        }
        catch (Exception e)
        {
            return false;
        }
        if(returned.isEmpty())
        {
            return false;
        }
        if(!returned.get(0).contains("Vegan Chickpea Piccata!!"))
        {
            return false;
        }
        return true;
    }

    public static boolean OtherRoleTest2()
    {
        PostReaderInterface postLoader = new PostReaderDW();
        HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
        hashtable = new HashtableWithDuplicateKeysAE<>();
        CHSearchBackendInterface backend = new CHSearchBackendBD(hashtable, postLoader);
        List<String> returned;
        try
        {
            backend.loadData("data/small.txt");
            returned = backend.findPostsByBodyWords("zesty");
        }
        catch (Exception e)
        {
            return false;
        }
        if(returned.isEmpty())
        {
            return false;
        }
        if(!returned.get(0).contains("ORANGE CHICKEN"))
        {
            return false;
        }
        return true;
    }




}
