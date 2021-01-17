import org.junit.Test;
import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import static org.junit.Assert.*;

public class PureStorageTest {

    @Test
    public void arrangeTextBox() throws Exception {
        PureStorage.TextBox textBox = new PureStorage.TextBox(0, 0, 3, 4,2);
        PureStorage.TextBox textBox2 = new PureStorage.TextBox(0, 0, 2, 4,3);
        PureStorage.TextBox textBox3 = new PureStorage.TextBox(0, 0, 1, 4,4);
        PureStorage.TextBox textBox4 = new PureStorage.TextBox(0, 0, 2, 3,5);
        PureStorage.TextBox textBox5 = new PureStorage.TextBox(0, 0, 1, 6,6);
        List<PureStorage.TextBox> list = new ArrayList<>();
        list.add(textBox);
        list.add(textBox2);
        list.add(textBox3);
        list.add(textBox4);
        list.add(textBox5);
        PureStorage ps = new PureStorage();
        List<List<PureStorage.TextBox>> result = ps.arrangeTextBox2(list, 10 );
        System.out.println(result);
    }

    @Test
    public void testTest() throws Exception{
        Semaphore notFull = new Semaphore(1);
        notFull.release(99);
        System.out.println("100 keys");
        notFull.acquire(100);

    }
}