import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CHSearchFrontendFD implements CHSearchFrontendInterface{

    private final String validInputs = "LTBPSQ";
    private Scanner scanner;
    private final String menuText = """
            Press Key To Run Command:
            [L]oad data from file
            Search Post [T]itles
            Search Post [B]odies
            Search [P]ost titles and bodies
            Display [S]tatistics for dataset
            [Q]uit
            """;

    private CHSearchBackendBD backend;

    public CHSearchFrontendFD(Scanner initScanner, CHSearchBackendBD initBackend)
    {
        scanner= initScanner;
        backend = initBackend;
    }
    @Override
    public void runCommandLoop() {
        char input = '\0';
        while(!(input =='Q'))
        {
            input = mainMenuPrompt();
            if(input == 'L')
            {
                loadDataCommand();
            } else if (input == 'T') {
                System.out.println("Enter in titles to search: ");
                List<String> toSearch = chooseSearchWordsPrompt();
                searchTitleCommand(toSearch);
            }
            else if (input == 'B') {
                System.out.println("Enter in post body words to search: ");
                List<String> toSearch = chooseSearchWordsPrompt();
                searchBodyCommand(toSearch);
            }
            else if (input == 'P') {
                System.out.println("Enter in title or body words to search: ");
                List<String> toSearch = chooseSearchWordsPrompt();
                searchPostCommand(toSearch);
            }
            else if (input == 'S') {
                displayStatsCommand();
            }
            else if (input == 'Q') {
                //exits program
                System.out.println("Exiting Program");
            }
        }
    }

    @Override
    public char mainMenuPrompt() {
        System.out.println(menuText);
        String input = scanner.next().substring(0,1).toUpperCase();
        if(!validInputs.contains(input))
        {
            return '\0';
        }
        return input.charAt(0);
    }

    @Override
    public void loadDataCommand() {
        System.out.println("Enter filename to be loaded");
        String filename = scanner.next();
        try {
            backend.loadData(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> chooseSearchWordsPrompt() {
        System.out.println("Enter each term on a new line or type 'Q' to stop adding search words");
        String input = "";
        List<String> searchWords = new ArrayList<String>();
        while(!input.equals("Q"))
        {
            input = scanner.next();
            if(!(input.equals("Q")))
            {
                searchWords.add(input);
            }
        }
        return searchWords;
    }

    @Override
    public void searchTitleCommand(List<String> words) {
        String wordsToString = "";
        for (int i = 0; i < words.size(); i++) {
            wordsToString += words.get(i);
            wordsToString += " ";
        }
         List<String> results = backend.findPostsByTitleWords(wordsToString);
        System.out.println("Results found: ");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i) + "\n\n");
        }
    }

    @Override
    public void searchBodyCommand(List<String> words) {
        String wordsToString = "";
        for (int i = 0; i < words.size(); i++) {
            wordsToString += words.get(i);
            wordsToString += " ";
        }
        List<String> results = backend.findPostsByBodyWords(wordsToString);
        System.out.println("Results found: ");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i) + "\n\n");
        }
    }

    @Override
    public void searchPostCommand(List<String> words) {
        String wordsToString = "";
        for (int i = 0; i < words.size(); i++) {
            wordsToString += words.get(i);
            wordsToString += " ";
        }
        List<String> results = backend.findPostsByTitleOrBodyWords(wordsToString);
        System.out.println("Results found: ");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i) + "\n");
        }
    }

    @Override
    public void displayStatsCommand() {
        System.out.println(backend.getStatisticsString());
    }
}

