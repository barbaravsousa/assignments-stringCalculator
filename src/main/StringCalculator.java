import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public Integer add(String numbers) throws Exception {

        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        String[] nums;


        if (numbers.startsWith("//")) {
            String[] lines = numbers.split("\n");
            String firstLine = lines[0].substring(3, lines[0].length() - 1);
            String[] delimitersArray = firstLine.split("\\]\\[");
            String regex = Arrays.stream(delimitersArray)
                    .map(Pattern::quote) // Escape each delimiter
                    .collect(Collectors.joining("|"));

            nums = lines[1].split(regex);
        } else {
            nums = numbers.split(delimiter);
        }

        int counter = 0;
        List<Integer> negativeNumbers = new ArrayList<>();


        for (String num : nums) {
            Integer singleInteger = Integer.parseInt(num);
            if (singleInteger < 0) {
                negativeNumbers.add(counter);
            } else if (singleInteger <= 1000) {
                counter += singleInteger;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new Exception("Negatives not allowed: " + negativeNumbers);
        }
        return counter;
    }
}
