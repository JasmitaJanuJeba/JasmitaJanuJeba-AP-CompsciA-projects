package piglatin;

public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle());

        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            String translatedLine = translate(line);
            translatedBook.appendLine(translatedLine);
        }

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println(" -> translate('" + input + "')");

        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        String[] words = input.split("\\s+");
        StringBuilder translated = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            translated.append(translateWord(words[i]));
            if (i < words.length - 1) {
                translated.append(" ");
            }
        }

        return translated.toString();
    }

    private static String translateWord(String input) {
        System.out.println(" -> translateWord('" + input + "')");

        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        // Extract leading and trailing punctuation
        String leadingPunct = "";
        String trailingPunct = "";
        int start = 0, end = input.length();

        while (start < end && !Character.isLetterOrDigit(input.charAt(start))) {
            leadingPunct += input.charAt(start++);
        }
        while (end > start && !Character.isLetterOrDigit(input.charAt(end - 1))) {
            trailingPunct = input.charAt(end - 1) + trailingPunct;
            end--;
        }

        String core = input.substring(start, end);

        // Handle hyphenated words
        String[] parts = core.split("-");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = translateSingleWord(parts[i]);
        }
        String translatedCore = String.join("-", parts);

        return leadingPunct + translatedCore + trailingPunct;
    }

    private static String translateSingleWord(String word) {
        if (word.isEmpty()) return "";

        String vowels = "aeiouAEIOU";
        String lower = word.toLowerCase();
        String result;

        // Pig Latin logic
        if (vowels.indexOf(lower.charAt(0)) != -1) {
            result = lower + "ay";
        } else {
            int firstVowelIndex = -1;
            for (int i = 0; i < lower.length(); i++) {
                if (vowels.indexOf(lower.charAt(i)) != -1) {
                    firstVowelIndex = i;
                    break;
                }
            }
            if (firstVowelIndex == -1) {
                result = lower + "ay";
            } else {
                result = lower.substring(firstVowelIndex) + lower.substring(0, firstVowelIndex) + "ay";
            }
        }

        // Capitalize first letter if original word was capitalized
        if (Character.isUpperCase(word.charAt(0))) {
            result = Character.toUpperCase(result.charAt(0)) + result.substring(1).toLowerCase();
        }

        return result;
    }
}
