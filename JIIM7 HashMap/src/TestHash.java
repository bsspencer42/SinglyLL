public class TestHash {
    public static void main(String[] args) {
        ExternalChainingHashMap<String,Integer> table = new ExternalChainingHashMap<>();
        table.put("testy",1);
        table.put("Yanel",32);
        table.put("Brad", 31);
        table.put("Paige",29);
        table.put("Ivan",30);
        table.put("Randy",55);
        table.put("Lani",60);
        table.put("Tanner",30); // 8
        table.printVals();
        table.put("Catboy",20); // 9
        table.printVals();
        table.put("Zeke", 4); // 10
        table.printVals();
        table.put("Zeke",5);
        table.printVals();
        System.out.println(table.getTable());
    }
}
