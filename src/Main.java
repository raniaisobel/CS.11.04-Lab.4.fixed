public class Main {
    public static void main(String[] args){

    }
    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int sLength = str.length();
        int counter = 0;
        for (int index = 0; index < sLength; index++) {
            if (str.substring(index, index + 1).equals("(")) {
                counter = counter + 1;
            } else if (str.substring(index, index + 1).equals(")")) {
                counter = counter - 1;
            } else return false;
        }
        return counter == 0;
    }
    // 2. reverseInteger
   public static String reverseInteger(int numbers){
       String sNumber = Integer.toString(numbers);
       int length = sNumber.length();
       String  reversed = "";
       int numbsCopy = numbers;
       for (int count = 0; count < length; count++){
           int digit = numbsCopy%10;
           reversed = reversed + digit;
           numbsCopy = numbsCopy/10;
       }
       return reversed;
   }
    // 3. encryptThis
    public static String encryptThis(String message){
        StringBuilder result = new StringBuilder();
        int length = message.length();
        int wordStart = 0;
        for (int count = 0; count < length; count++){
            if (message.charAt(count) == ' ') {
                String word = message.substring(wordStart,count);
                int wLength = word.length();
                int charCode = word.charAt(0);
                String charCodeStr = String.valueOf(charCode);
                if (wLength > 2) {
                    String swapped = charCodeStr + word.charAt(wLength - 1) + word.substring(2, wLength - 1) + word.charAt(1);
                    result.append(swapped).append(" ");
                }
                else {
                    result.append(charCodeStr + word.substring(1)).append(" ");
                }
                wordStart = count + 1;
            }
        }
        String lastWord = message.substring(wordStart);
        int lastLength = lastWord.length();
        int charCode = lastWord.charAt(0);
        String charCodeStr = String.valueOf(charCode);
        if (lastLength > 2) {
            String swapped = charCodeStr + lastWord.charAt(lastLength - 1) + lastWord.substring(2, lastLength - 1) + lastWord.charAt(1);
            result.append(swapped);
        }
        else {
            result.append(charCodeStr + lastWord.substring(1));
        }
        return result.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String message) {
        StringBuilder result = new StringBuilder();
        int length = message.length();
        int wordStart = 0;
        for (int count = 0; count < length; count++) {
            if (message.charAt(count) == ' ') {
                String word = message.substring(wordStart, count);
                int charCodeLength = 0;
                while (charCodeLength < word.length() && Character.isDigit(word.charAt(charCodeLength))) {
                    charCodeLength++;
                }
                int charCode = Integer.parseInt(word.substring(0, charCodeLength));
                char firstLetter = (char) charCode;
                String restOfWord = word.substring(charCodeLength);
                int wLength = restOfWord.length();
                if (wLength > 1) {
                    char temp = restOfWord.charAt(0);
                    restOfWord = restOfWord.charAt(wLength - 1) + restOfWord.substring(1, wLength - 1) + temp;
                }
                result.append(firstLetter).append(restOfWord).append(" ");
                wordStart = count + 1;
            }
        }
        String lastWord = message.substring(wordStart);
        int charCodeLength = 0;
        while (charCodeLength < lastWord.length() && Character.isDigit(lastWord.charAt(charCodeLength))) {
            charCodeLength++;
        }
        int charCode = Integer.parseInt(lastWord.substring(0, charCodeLength));
        char firstLetter = (char) charCode;
        String restOfWord = lastWord.substring(charCodeLength);
        int lastLength = restOfWord.length();
        if (lastLength > 1) {
            char temp = restOfWord.charAt(0);
            restOfWord = restOfWord.charAt(lastLength - 1) + restOfWord.substring(1, lastLength - 1) + temp;
        }
        result.append(firstLetter).append(restOfWord);
        return result.toString();
    }
}