package telran;

public class SplittingText {

    public String splitText(String text, int N) {
        if (N >= text.length()) {
            return text;
        }

        String[] splittedText = text.split(" ");
        StringBuilder result = new StringBuilder();

        if (splittedText[0].length() > N) {
            return "";
        } else result.append(splittedText[0]);
        N -= splittedText[0].length();

        for (int i = 1; N > 0; i++) {
            if (splittedText[i].length() >= N) {
                return result.toString();
            } else result.append(" ").append(splittedText[i]);
            N -= splittedText[i].length() + 1;
        }
        return result.toString();
    }
}
