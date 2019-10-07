package blok2dz2;

public class SelfIterator {
    public static void main(String[] args) {
        ArrayString arrayString = new ArrayString();
        myMetodIterator(arrayString.object);

        ArrayInteger arrayInteger = new ArrayInteger();
        myMetodIterator(arrayInteger.object);

        ArrayBoolean arrayBoolean = new ArrayBoolean();
        myMetodIterator(arrayBoolean.object);

        ArrayLong arrayLong = new ArrayLong ();
        myMetodIterator(arrayLong.object);
    }

    private static void myMetodIterator(Object object) {
        System.out.println(object);
    }
}