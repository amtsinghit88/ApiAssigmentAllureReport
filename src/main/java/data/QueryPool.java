package data;

import java.util.HashMap;

public class QueryPool {


    public HashMap<String,String> productQuery(){
            HashMap<String,String> map = new HashMap<>();
            map.put("brand","maybelline");
            map.put("product_type","eyeliner");
            map.put("category","pencil");

         return map;
    }
}
