public class SingletonFactory {
    private static volatile Singleton singleton;
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (SingletonFactory.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    private static  class Singleton{
    }
}

