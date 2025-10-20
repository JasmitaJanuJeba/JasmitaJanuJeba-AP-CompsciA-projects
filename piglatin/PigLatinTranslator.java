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
       String vowels = "aeiouAEIOU";
       String result = "";

       //Check if first letter is a vowel 
       if (vowels.indexOf(input.charAt(0)) != -1){
        //Word starts with a vowel
        result = input + "ay";
       }
       else {
        int firstVowelIndex = -1;
        //Find the index of the first vowel in the word
        for (int i = 0; i < input.length(); i++){
            if (vowels.indexOf(input.charAt(i)) !=-1){
                firstVowelIndex = i;
                break;
            }
        }

        if (firstVowelIndex == -1){
            result = input+ "ay";
        }
        else {
            result = input.substring(firstVowelIndex) + input.substring(0, firstVowelIndex) + "ay";
        }
       }
        return result;
       
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
