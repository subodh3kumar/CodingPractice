package builder;

import java.time.Year;

public class MainApplication {


    public static void main(String[] args) {
        Book book = new Book.Builder("978-8126715855", "Chitralekha")
                .author("Bhagwaticharan Verma")
                .genre(Genre.FICTION)
                .published(Year.of(2018))
                .description("story describing what is virtue and sin")
                .build();

        System.out.println(book.toString());
    }
}
