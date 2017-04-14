package test3.dao;


import org.junit.Test;

/**
 * Created by Administrator on 2017/2/20.
 */
public class CGLibTest {

    @Test
    public void inteceptorTest() throws InstantiationException, IllegalAccessException {

        CGLibProxy proxy = new CGLibProxy();
        ADao adao = (ADao)proxy.init(new ADao().getClass());
        adao.GetA1();
    }

}
