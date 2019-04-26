package pattern.singleton;

public class Singleton {

    private Singleton(){};

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

}
