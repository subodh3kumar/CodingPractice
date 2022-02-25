package workshop;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.CharBag;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.impl.factory.Strings;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class HaikuTest {

    private final String haiku = """
            Breaking Through                  Pavement                  Wakin' with Bacon        Homeward Found
            ----------------                  --------                  -----------------        --------------
            The wall disappears               Beautiful pavement!       Wakin' with Bacon        House is where I am
            As soon as you break through the  Imperfect path before me  On a Saturday morning    Home is where I want to be
            Intimidation                      Thank you for the ride    Life’s little pleasures  Both may be the same
                        
            Winter Slip and Slide              Simple Nothings                With Deepest Regrets
            ---------------------              ---------------                --------------------
            Run up the ladder                  A simple flower                With deepest regrets
            Swoosh down the slide in the snow  Petals shine vibrant and pure  That which you have yet to write
            Winter slip and slide              Stares into the void           At death, won't be wrote
                        
            Caffeinated Coding Rituals  Finding Solace               Curious Cat                Eleven
            --------------------------  --------------               -----------                ------
            I arrange my desk,          Floating marshmallows        I see something move       This is how many
            refactor some ugly code,    Cocoa brewed hot underneath  What it is, I am not sure  Haiku I write before I
            and drink my coffee.        Comfort in a cup             Should I pounce or not?    Write a new tech blog.
            """;

    @Test
    public void topLettersEclipseCollections() {
        CharBag chars = Strings.asChars(this.haiku)
                .select(Character::isAlphabetic)
                .collectChar(Character::toLowerCase)
                .toBag();

        ListIterable<CharIntPair> top3 = chars.topOccurrences(3);

        Assertions.assertEquals(PrimitiveTuples.pair('e', 94), top3.get(0));
        Assertions.assertEquals(PrimitiveTuples.pair('t', 65), top3.get(1));
        Assertions.assertEquals(PrimitiveTuples.pair('i', 62), top3.get(2));
    }

    @Test
    public void topLettersJavaStream() {
        Map<Character, Long> chars = this.haiku.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), counting()));

        List<Map.Entry<Character, Long>> top3 = chars.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .toList();

        Assertions.assertEquals(new AbstractMap.SimpleEntry<>('e', 94L), top3.get(0));
        Assertions.assertEquals(new AbstractMap.SimpleEntry<>('t', 65L), top3.get(1));
        Assertions.assertEquals(new AbstractMap.SimpleEntry<>('i', 62L), top3.get(2));
    }

    @Test
    public void distinctLettersEclipseCollections() {
        String distinctLetters = Strings.asChars(this.haiku)
                .select(Character::isAlphabetic)
                .collectChar(Character::toLowerCase)
                .distinct()
                .toString();

        Assertions.assertEquals("breakingthoupvmwcdflsy", distinctLetters);
    }

    @Test
    public void distinctLettersJavaStream() {
        String distinctLetters = this.haiku.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .distinct()
                .mapToObj(i -> (char) i)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        Assertions.assertEquals("breakingthoupvmwcdflsy", distinctLetters);
    }

    @Test
    public void duplicatesAndUniqueEclipseCollections() {
        MutableBag<Character> chars = Strings.asChars(this.haiku)
                .select(Character::isAlphabetic)
                .collect(Character::toLowerCase)
                .toBag();

        MutableBag<Character> duplicates = chars.selectDuplicates();
        MutableSet<Character> unique = chars.selectUnique();

        Assertions.assertEquals(chars, duplicates);
        Assertions.assertEquals(CharSets.immutable.empty().toString(), unique.toString());
    }

    @Test
    public void duplicatesAndUniqueJavaStream() {
        Map<Character, Long> chars = this.haiku.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), counting()));

        Map<Character, Long> duplicates = chars.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

        Set<Character> unique = chars.entrySet().stream()
                .filter(entry -> entry.getValue() < 2)
                .map(Map.Entry::getKey)
                .collect(toSet());

        Assertions.assertEquals(chars, duplicates);
        Assertions.assertEquals(Set.of(), unique);
    }

    @Test
    public void topVowelAndConsonantEclipseCollection() {
        MutableList<CharIntPair> charIntPairs = Strings.asChars(this.haiku)
                .asLazy()
                .select(Character::isAlphabetic)
                .collectChar(Character::toLowerCase)
                .toBag()
                .topOccurrences(26);

        char topVowel = charIntPairs.detect(pair -> this.isVowel(pair.getOne())).getOne();
        char topConsonant = charIntPairs.detect(pair -> !isVowel(pair.getOne())).getOne();

        Assertions.assertEquals(topVowel, 'e');
        Assertions.assertEquals(topConsonant, 't');
    }

    @Test
    public void topVowelAndConsonantJavaStream() {
        List<Map.Entry<Character, Long>> entries = this.haiku.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

        Character topVowel = entries.stream()
                .filter(entry -> this.isVowel(entry.getKey()))
                .findFirst()
                .orElseThrow()
                .getKey();

        Character topConsonant = entries.stream()
                .filter(entry -> !this.isVowel(entry.getKey()))
                .findFirst()
                .orElseThrow()
                .getKey();

        Assertions.assertEquals(topVowel, 'e');
        Assertions.assertEquals(topConsonant, 't');
    }

    private boolean isVowel(char character) {
        return switch (character) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}
