import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    Map<String, Date> timeMap = new HashMap<>();
    Map<String, String> valueMap = new HashMap<>();
    public String query(String key, Date time, long n){
        if(!timeMap.containsKey(key)){
            String news = getNews(key);
            valueMap.put(key, news);
            timeMap.put(key, time);
            return news;
        }else {
            Date lastTime = timeMap.get(key);
            if(time.getTime()-lastTime.getTime()> 1000*n){
                String news = getNews(key);
                valueMap.put(key, news);
                timeMap.put(key, time);
                return news;
            }else {
                return valueMap.get(key);
            }
        }
    }
    public String getNews(String key){
        return "value";
    }
}
