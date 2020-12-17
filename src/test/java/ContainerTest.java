import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.JUnit4;

public class ContainerTest {

    @Test
    public void get() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        Assert.assertEquals(1, con.get(0).intValue());
    }

    @Test
    public void add() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        con.add(3);
        Assert.assertEquals(1, con.get(0).intValue());
        Assert.assertEquals(2, con.get(1).intValue());
        Assert.assertEquals(2, con.get(2).intValue());
        Assert.assertEquals(3, con.get(3).intValue());
    }

    @Test
    public void remove() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(3);
        con.remove(2);
        con.remove(1);
        con.remove(0);
        Assert.assertTrue(con.isEmpty());
    }

    @Test
    public void removeTwo() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(3);
        con.remove();
        con.remove();
        con.remove();
        Assert.assertTrue(con.isEmpty());
    }

    @Test
    public void set() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        con.add(3);
        int prev = con.set(2, 111);
        Assert.assertEquals(1, con.get(0).intValue());
        Assert.assertEquals(2, con.get(1).intValue());
        Assert.assertEquals(111, con.get(2).intValue());
        Assert.assertEquals(2, prev);
        Assert.assertEquals(3, con.get(3).intValue());
    }

    @Test
    public void indexOf() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        con.add(2);
        con.add(3);
        con.add(3);
        con.add(3);
        con.add(4);
        con.add(4);
        con.add(4);
        con.add(4);
        Assert.assertEquals(7, con.indexOf(4));
        Assert.assertNotEquals(8, con.indexOf(3));
        Assert.assertEquals(4, con.indexOf(3));
        Assert.assertNotEquals(5, con.indexOf(3));
        Assert.assertEquals(1, con.indexOf(2));
        Assert.assertNotEquals(2, con.indexOf(2));
    }

    @Test
    public void lastIndexOf() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        con.add(2);
        con.add(3);
        con.add(3);
        con.add(3);
        con.add(4);
        con.add(4);
        con.add(4);
        con.add(4);

        Assert.assertEquals(10, con.lastIndexOf(4));
        Assert.assertEquals(6, con.lastIndexOf(3));
        Assert.assertEquals(3, con.lastIndexOf(2));
        Assert.assertEquals(0, con.lastIndexOf(1));

    }

    @Test
    public void size() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        Assert.assertEquals(3, con.size());
        con.add(2);
        con.add(2);
        Assert.assertEquals(5, con.size());
    }

    @Test
    public void isEmpty() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(3);
        con.remove();
        con.remove();
        con.remove();
        Assert.assertEquals(0, con.size());
        Assert.assertTrue(con.isEmpty());
        con.add(2);
        con.add(2);
        con.remove();
        con.remove();
        Assert.assertEquals(0, con.size());
        Assert.assertTrue(con.isEmpty());
    }

    @Test
    public void clear() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        con.clear();
        Assert.assertEquals(0, con.size());
        Assert.assertTrue(con.isEmpty());
        con.add(2);
        con.add(2);
        con.clear();
        Assert.assertEquals(0, con.size());
        Assert.assertTrue(con.isEmpty());
    }

    @Test
    public void contains() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        Assert.assertTrue(con.contains(2));
        Container<String> conSrt = new Container<String>();
        conSrt.add("Hello");
        conSrt.add("Bye");
        Assert.assertTrue(conSrt.contains("Hello"));
        Assert.assertFalse(conSrt.contains("Ho"));
    }

    @Test
    public void rangeCheck() {
        Container<Integer> con = new Container<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        Assert.assertTrue(con.rangeCheck(3));
        Assert.assertEquals(3, con.size());
        con.add(3);
        con.add(4);
        Assert.assertTrue(con.rangeCheck(5));
        Assert.assertEquals(5, con.size());
    }


}
