package _2Wednesday;

/**
 * Created by plamen on 1/27/16.
 */

@ClassInfo(author = "Plamen", revision = 2, relatedClasses = {int.class, String.class, boolean.class})
public class Foo {
    int mFoo;
    String mBar;
    boolean mBaz;

    public Foo(int foo, String bar, boolean baz) {
        mFoo = foo;
        mBar = bar;
        mBaz = baz;
    }
}
