import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        final String hW = "Hello World!";
        System.out.println(hW);
        System.out.println(reverse(hW));
        System.out.println(delateNSymbol(hW, "l", 2, 0));
        System.out.println(delateNSymbol(hW, "l", 2, 1));
        String ss = "aabbddcc";
        System.out.println(wordSplitting(ss));
    }

    private static String reverse(String stringInput) {
        char[] string = stringInput.toCharArray();
        char[] stringReverse = new char[string.length];
        for (int i = 0; i < string.length; i++) {
            stringReverse[(string.length - 1) - i] = string[i];
        }
        return String.valueOf(stringReverse);
    }

    private static String delateNSymbol(String stringInput, String symbol, int numberOfDeletions, int removalDirection) {
        StringBuilder st = new StringBuilder(stringInput);
        switch (removalDirection) {
            case 0:
                for (int i = numberOfDeletions; i > 0; ) {
                    int lenSt = st.length();
                    st = deletChar(st.indexOf(symbol.toUpperCase()), st.indexOf(symbol.toLowerCase()), st);
                    if (lenSt > st.length()) {
                        i--;
                    }
                }
                return st.toString();
            case 1:
                char[] string = new char[st.length()];
                int indexOfSymbolUpperCase;
                int indexOfSymbolLowerCase;
                int lenSt;
                int j = numberOfDeletions;
                System.arraycopy(st.toString().toCharArray(), 0, string, 0, string.length);
                for (int i = (string.length - 1); i >= 0 && j > 0; i--) {
                    if (string[i] == symbol.toUpperCase().toCharArray()[0]) {
                        indexOfSymbolUpperCase = i;
                    } else {
                        indexOfSymbolUpperCase = -1;
                    }
                    if (string[i] == symbol.toLowerCase().toCharArray()[0]) {
                        indexOfSymbolLowerCase = i;
                    } else {
                        indexOfSymbolLowerCase = -1;
                    }
                    lenSt = st.length();
                    st = deletChar(indexOfSymbolLowerCase, indexOfSymbolUpperCase, st);
                    if (lenSt > st.length()) {
                        j--;
                    }
                }
        }
        return st.toString();
    }

    private static StringBuilder deletChar(int indexOfSymbolUpperCase, int indexOfSymbolLowerCase, StringBuilder st) {
        if (indexOfSymbolUpperCase == -1 && indexOfSymbolLowerCase == -1) {
            return st;
        }
        if (indexOfSymbolUpperCase == -1 || indexOfSymbolLowerCase == -1) {
            if (indexOfSymbolUpperCase == -1) {
                st.deleteCharAt(indexOfSymbolLowerCase);
            } else {
                st.deleteCharAt(indexOfSymbolUpperCase);
            }
        } else {
            if (indexOfSymbolLowerCase > indexOfSymbolUpperCase) {
                st.deleteCharAt(indexOfSymbolUpperCase);
            } else {
                st.deleteCharAt(indexOfSymbolLowerCase);
            }
        }
        return st;
    }

    private static String wordSplitting(String stringInput) {
        Set<String> st = new TreeSet<>();
        for (int i = 0; i < stringInput.length(); i++) {
            try {
                st.add(Character.toString(stringInput.toCharArray()[i]));
            } catch (ClassCastException ignored) {
            }
        }
        return st.toString();
    }
}
