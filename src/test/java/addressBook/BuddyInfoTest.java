package addressBook;

import org.junit.Assert;
import org.junit.Test;

public class BuddyInfoTest {

    @Test
    public void testBuddyInfo(){
        BuddyInfo b = new BuddyInfo();
        b.setName("Rachel");
        b.setAddress("1 abc rd.");
        b.setPhoneNumber("111-111-1111");
        Assert.assertEquals("Rachel", b.getName());
        Assert.assertEquals("111-111-1111", b.getPhoneNumber());
        Assert.assertEquals("1 abc rd.", b.getAddress());
    }
}
