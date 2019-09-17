import br.edu.ifpb.conversor.Conversor;
import org.junit.Assert;
import org.junit.Test;

public class testConversor {
    @Test
    public void testbinario(){
        Conversor c = new Conversor();
        Assert.assertEquals(c.decimalBinario(10),"1010");
        Assert.assertEquals(c.decimalBinario(100),"1100100");
        Assert.assertEquals(c.decimalBinario(1),"1");
        Assert.assertEquals(c.decimalBinario(2),"10");

    }

    @Test
    public void testHexdecimal(){
        Conversor c = new Conversor();
        Assert.assertEquals(c.decimalHexadecimal(10),"a");
        Assert.assertEquals(c.decimalHexadecimal(100),"64");
        Assert.assertEquals(c.decimalHexadecimal(1),"1");
        Assert.assertEquals(c.decimalHexadecimal(3),"3");
        Assert.assertEquals(c.decimalHexadecimal(4),"4");
        Assert.assertEquals(c.decimalHexadecimal(5),"5");
        Assert.assertEquals(c.decimalHexadecimal(6),"6");
        Assert.assertEquals(c.decimalHexadecimal(7),"7");
        Assert.assertEquals(c.decimalHexadecimal(8),"8");
        Assert.assertEquals(c.decimalHexadecimal(9),"9");
        Assert.assertEquals(c.decimalHexadecimal(11),"b");
        Assert.assertEquals(c.decimalHexadecimal(12),"c");
        Assert.assertEquals(c.decimalHexadecimal(13),"d");
        Assert.assertEquals(c.decimalHexadecimal(14),"e");
        Assert.assertEquals(c.decimalHexadecimal(15),"f");
    }


}
