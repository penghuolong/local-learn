import java.util.HashSet;
import java.util.Set;

public class Shoppe_Mincost_Tickets_015 {
    Set<Integer> day = new HashSet<>();
    int[] temp = new int[365];
    int[] costs;
    public int mincostTickets(int[] days, int[] costs) {
        for (int i = 0; i < days.length; i++) {
            day.add(days[i]);
        }
        this.costs = costs;
        return calculate(1);
    }

    private int calculate(int start) {
        if(start > 365){
            return 0;
        }
        if(temp[start-1]!=0){
            return temp[start-1];
        }
        if(day.contains(start)){
            temp[start-1] = Math.min(Math.min((calculate(start+1)+costs[0]),calculate(start+7)+costs[1]),calculate(start+30)+costs[2]);
        }else {
            temp[start-1] = calculate(start+1);
        }
        return temp[start-1];
    }
}
