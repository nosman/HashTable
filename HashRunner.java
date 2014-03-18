public class HashRunner {
    public static void main(String[] args) {
        HashTableSolution<String, String> tbl = new HashTableSolution<String, String>();

        String[] s = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] s2 = {"a", "b", "c", "d", "e", "f", "g", "h"};

        /*
        tbl.put("a", "apple");
        System.out.println(tbl.get("a"));
        System.out.println("Expected: apple");
        tbl.put("as", "apple2");
        System.out.println(tbl.get("as"));
        System.out.println("Expected: apple2");
        */
        for (int i = 0; i<s.length; i++)
            tbl.put(s[i], s2[i]);
        for (int i = 0; i<s.length; i++)
            System.out.println(tbl.get(s[i]) == s2[i]);
    }
}
