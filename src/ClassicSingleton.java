/**
 * Created by mming on 10/21/17.
 */
public class ClassicSingleton {
    private static ClassicSingleton instance;
    static ClassicSingleton getInstance(){
        if(instance == null){
            instance = new ClassicSingleton();
        }
        return instance;
    }
    public void print(){
        System.out.print("Only once");
    }
    private ClassicSingleton(){};
}
