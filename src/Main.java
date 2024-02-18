import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> favoriteBooks = new ArrayList<>(Arrays.asList("Book1", "Book2", "Book3"));
        Man originalMan = new Man("John", 30, favoriteBooks);

        Man copiedMan = CopyUtils.deepCopy(originalMan);
        printManInfo("Original man", originalMan);
        printManInfo("Copied man", copiedMan);

        originalMan.setName("Changed name");
        originalMan.setAge(31);
        originalMan.getFavoriteBooks().add("Book4");

        printManInfo("Original man after changes", originalMan);
        printManInfo("Copied man after changes", copiedMan);
    }

    private static void printManInfo(String title, Man man) {
        System.out.println(title + ": "
                + man.getName() + ", "
                + man.getAge() + ", "
                + man.getFavoriteBooks());
    }
}
