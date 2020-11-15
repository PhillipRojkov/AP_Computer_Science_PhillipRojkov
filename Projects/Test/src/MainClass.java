public class MainClass {
    public static void main(String[] args) {
        A object = new B();

        object.m();

        //object.n(); //Throws error

        ((B)object).n();

        B newObject = (B)object;

        newObject.m();

        newObject.n();
    }
}
