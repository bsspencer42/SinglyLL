public class TestHash {
    public static void main(String[] args) {
        ExternalChainingHashMap<String,Integer> table = new ExternalChainingHashMap<>();
        System.out.println(table.put("test",1));
        table.put("Yanel",32);
        table.put("Brad", 31);
        table.put("Paige",29);
        table.put("Ivan",30);
        table.put("Randy",55);
        table.put("Lani",60);
        table.put("Tanner",30);
        table.put("Catboy",20);
        table.put()
        table.printVals();
    }
}
