package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
    System.out.println("  -> translateWord('" + input + "')");

    if (input == null || input.trim().isEmpty()) {
        return "";
    }

    input = input.trim();
    String vowels = "aeiouAEIOU";
    String punctuation = "";

    // Handle punctuation
    if (!Character.isLetter(input.charAt(input.length() - 1))) {
        punctuation = String.valueOf(input.charAt(input.length() - 1));
        input = input.substring(0, input.length() - 1);
    }

    // Store capitalization pattern
    boolean[] isUpper = new boolean[input.length()];
    for (int i = 0; i < input.length(); i++) {
        isUpper[i] = Character.isUpperCase(input.charAt(i));
    }

    String lower = input.toLowerCase();
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

    // Reapply capitalization pattern to the part that came from the original word
    StringBuilder cased = new StringBuilder(result);
    int lettersOnly = Math.min(isUpper.length, result.length() - 2); // exclude "ay"
    for (int i = 0; i < lettersOnly; i++) {
        if (isUpper[i]) {
            cased.setCharAt(i, Character.toUpperCase(cased.charAt(i)));
        } else {
            cased.setCharAt(i, Character.toLowerCase(cased.charAt(i)));
        }
    }

    

    return cased.toString() + punctuation;
}

    private static String translate(String sentence){
        System.out.println(" ->translate('" + sentence + "')");

        if (sentence == null || sentence.trim().isEmpty()){
           return "";
        }

        String[] words = sentence.split("\\s+");
        StringBuilder translated = new StringBuilder();

        for(int i = 0; i< words.length; i++){
            translated.append(translateWord(words[i]));
            if (i<words.length - 1){
               translated.append(" ");
            }
        }
        return translated.toString();
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
