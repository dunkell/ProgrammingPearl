package chapter2;


import java.util.*;


public class util {
    private static final String[] WORD_LIST = {"apple", "abandon","banana", "but","cat", "dog", "elephant", "fish", "grape","good",
            "horse", "hero","iguana", "jellyfish", "kangaroo", "lemon", "monkey", "noodle", "orange","off","time",
            "pear", "quail","quit", "rabbit","really", "string","strawberry", "tiger", "umbrella", "violet", "watermelon",
            "xylophone", "yell","yak", "zebra","zero"};

    public static void main(String[] args) {
        List<String> wordList = wordsGenerate();

        // Print out the words
        for (String word : wordList) {
            System.out.println(word);
        }
    }

    /**
     * 生成数据
     * @return
     */
    public static List<String> wordsGenerate(){
        Set<String> words = new HashSet<>();
        Random random = new Random();
        words.addAll(Arrays.asList(WORD_LIST));
        while (words.size() < 100) {
            String word = WORD_LIST[random.nextInt(WORD_LIST.length)];
            String anagram = shuffleString(word);
            words.add(anagram);
        }

        // Convert the set to a list and shuffle it
        List<String> wordList = new ArrayList<>(words);
        Collections.shuffle(wordList);

        return wordList;
    }

    public static String shuffleString(String string) {
        List<Character> chars = new ArrayList<>();
        for (char c : string.toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}




