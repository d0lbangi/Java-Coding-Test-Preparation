import java.util.ArrayList;

public class Practice4 {

    public static int solution(int cacheSize, String[] searches) {
        ArrayList<String> lru = new ArrayList<>();
        int result = 0;

        if (cacheSize == 0) {
            return searches.length * 5;
        }

        for (String search : searches) {
            String s = search.toLowerCase();

            if (lru.contains(s)) {
                lru.remove(s);
                lru.add(s);
                result++;
            } else {
                if (lru.size() == cacheSize) {
                    lru.remove(0);
                }
                lru.add(s);
                result += 5;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // Test code
        String[] searches = {"Google", "Google", "Microsoft", "Apple", "Qualcomm", "Google", "Qualcomm"};
        System.out.println(solution(3, searches));
    }
}
