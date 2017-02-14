package coding.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TvRemoteTest {

    private TvRemote remote;

    @Before
    public void setUp() throws Exception {
        remote = new TvRemote();
    }

    @Test public void testFirstChannel() { Assert.assertEquals(2, remote.getMinimumClicks("0,99", "22")); }
    @Test public void testTwoChannels() { Assert.assertEquals(4, remote.getMinimumClicks("0,99", "22,34")); }
    @Test public void testInvalidChannel() { Assert.assertEquals(4, remote.getMinimumClicks("0,99", "22,100,34")); }
    @Test public void testLeftChannel() { Assert.assertEquals(3, remote.getMinimumClicks("0,99", "22,21")); }
    @Test public void testRightChannel() { Assert.assertEquals(3, remote.getMinimumClicks("0,99", "22,23")); }
    @Test public void testTwoLeftChannel() { Assert.assertEquals(4, remote.getMinimumClicks("0,99", "22,21,20")); }
    @Test public void testTwoRightChannel() { Assert.assertEquals(4, remote.getMinimumClicks("0,99", "22,23,24")); }
    @Test public void testFirstInvalidChannel() { Assert.assertEquals(3, remote.getMinimumClicks("0,99", "100,23,24")); }
    @Test public void testRepeatedChannel() { Assert.assertEquals(3, remote.getMinimumClicks("0,99", "23,23,24")); }
    @Test public void testThreeDigitChannels() { Assert.assertEquals(7, remote.getMinimumClicks("1,200", "23,100,24")); }
    @Test public void testFourDigitChannels() { Assert.assertEquals(9, remote.getMinimumClicks("1,1000", "1000,100,24")); }
    @Test public void testPreviousChannel() { Assert.assertEquals(5, remote.getMinimumClicks("1,99", "24,34,24")); }
    @Test public void testInvalidPreviousChannel() { Assert.assertEquals(2, remote.getMinimumClicks("1,99", "100,34,100")); }
    @Test public void testTwoRepeatedChannel() { Assert.assertEquals(2, remote.getMinimumClicks("1,99", "23,23,23")); }
    @Test public void testSportsNewsSportsChannel() { Assert.assertEquals(5, remote.getMinimumClicks("1,99", "23,25,23")); }
}
