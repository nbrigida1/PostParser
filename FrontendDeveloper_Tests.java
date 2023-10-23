import java.util.Scanner;

public class FrontendDeveloper_Tests {

    public static void main(String[] args) {
        System.out.println("Frontend Individual Test 1: " + (test1() ? "passed" : "failed"));
        System.out.println("Frontend Individual Test 2: " + (test2() ? "passed" : "failed"));
        System.out.println("Frontend Individual Test 3: " + (test3() ? "passed" : "failed"));
        System.out.println("Frontend Individual Test 4: " + (test4() ? "passed" : "failed"));
        System.out.println("Frontend Individual Test 5: " + (test5() ? "passed" : "failed"));
    }

    public static boolean test1() {
        TextUITester uiTester = new TextUITester("L\ndummy\nQ\n");
        try {
            PostReaderInterface postLoader = new PostReaderDW();
            HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
            hashtable = new HashtableWithDuplicateKeysAE<>();
            CHSearchBackendInterface backend = new BackendNB(hashtable, postLoader);
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
        return systemOutput.contains("\nLtest\n");
    }
    public static boolean test2() {
        TextUITester uiTester = new TextUITester("T\nwhatever\nQ\nQ\n");
        try {
            PostReaderInterface postLoader = new PostReaderDW();
            HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
            hashtable = new HashtableWithDuplicateKeysAE<>();
            CHSearchBackendInterface backend = new BackendNB(hashtable, postLoader);
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
        return systemOutput.contains("\nTtest\n");
    }
    public static boolean test3() {
        TextUITester uiTester = new TextUITester("B\nwhatever\nQ\nQ\n");
        try {
            PostReaderInterface postLoader = new PostReaderDW();
            HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
            hashtable = new HashtableWithDuplicateKeysAE<>();
            CHSearchBackendInterface backend = new BackendNB(hashtable, postLoader);
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
        return systemOutput.contains("\nBtest\n");
    }
    public static boolean test4() {
        TextUITester uiTester = new TextUITester("P\nwhatever\nQ\nQ\n");
        try {
            PostReaderInterface postLoader = new PostReaderDW();
            HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
            hashtable = new HashtableWithDuplicateKeysAE<>();
            CHSearchBackendInterface backend = new BackendNB(hashtable, postLoader);
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
        return systemOutput.contains("\nPtest\n");
        }
    public static boolean test5() {
        TextUITester uiTester = new TextUITester("S\nQ\n");
        try {
            PostReaderInterface postLoader = new PostReaderDW();
            HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
            hashtable = new HashtableWithDuplicateKeysAE<>();
            CHSearchBackendInterface backend = new BackendNB(hashtable, postLoader);
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
        return systemOutput.contains("\nStest\n");
    }
}
