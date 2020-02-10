import java.util.Optional;
import java.util.stream.Collectors;

public class JC1_OptionalChallenge {

    private static String finalZionValue = "a";
    private static int matrixCount = 0;

    public static void main(String[] args) {
        Optional<String> optFromMatrix = Optional.ofNullable(finalZionValue);
        var agentSmith = "Virus";

        finalZionValue += Optional.ofNullable(agentSmith).orElse(getVisionFromOracle());
        finalZionValue += optFromMatrix.orElseGet(JC1_OptionalChallenge::getVisionFromOracle);
        finalZionValue += matrixCount;

        String neo = null;

        try {
            Optional.ofNullable(neo).orElseThrow(IllegalArgumentException::new);
        } catch (Exception e) {
            finalZionValue += Optional.ofNullable(neo).or(() -> Optional.of("theOne")).get();
        }

        finalZionValue += Optional.of("trinity").stream()
                .map(String::toUpperCase)
                .filter(trinity -> trinity.equals("TRINITY"))
                .collect(Collectors.joining());

        System.out.println(finalZionValue);
    }

    private static String getVisionFromOracle() {
        matrixCount++;
        System.out.println("matrixCount: " + matrixCount);
        finalZionValue += "KeyMaker";
        return "Architect";
    }
}
