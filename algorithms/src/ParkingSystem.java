import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    Map<Integer, Integer> map = new HashMap<>();
    public ParkingSystem(int big, int medium, int small) {
         map.put(1, big);
         map.put(2,medium);
         map.put(3,small);
    }

    public boolean addCar(int carType) {
        Integer integer = map.get(carType);
        if(integer > 0){
            map.put(carType, map.get(carType)-1);
            return true;
        }else {
            return false;
        }
    }
}
