package training.algo.dynamic;

public class PrintWhatYouSay {

    // Look-and-say în română: 44442233 => "4 de 4, 2 de 2, 2 de 3"

    public static void main(String[] args) {

        processInput("44442233");
        processInput("");
        processInput("44");
        processInput("1234");
        processInput("12234");
        processInput("122334");
        processInput("12344");
    }

    private static void processInput(String input) {
        System.out.printf("\n======[ %s ]=======\n", input);
        if (input == null) {
            System.out.println("null input.");
            return;
        }
        if (input.length() == 0) {
            System.out.println("empty string");
            return;
        }

        char[] chars = input.toCharArray();

        char previousChar = chars[0];
        char currentChar = 0;

        int counter = 1;

        for(int i=1; i<chars.length; i++){

            currentChar = chars[i];
            if(currentChar == previousChar){
                counter ++;
            }
            else{
                System.out.printf("Char [%s] of [%d] times%n", previousChar, counter);
                counter = 1;
                previousChar = currentChar;
            }

        }

        System.out.printf("Char [%s] of [%d] times%n", previousChar, counter);
    }

}
