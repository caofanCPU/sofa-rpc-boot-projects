package com.alipay.sofa.rpc.boot.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootApplication
@SpringBootTest(properties = {
        SofaBootRpcProperties.PREFIX + ".bolt.port=5000",
        "com_alipay_sofa_rpc_bolt_io_thread_count=600"
})
public class SofaBootRpcPropertiesTest {
    @Autowired
    private SofaBootRpcProperties sofaBootRpcProperties;

    @Test
    public void testCamelCaseToDot() {
        Assert.assertEquals("com.alipay.sofa", sofaBootRpcProperties.camelToDot("comAlipaySofa"));
        Assert.assertEquals("com.alipay.sofa", sofaBootRpcProperties.camelToDot("ComAlipaySofa"));
    }

    @Test
    public void testDotConfig() {
        Assert.assertEquals("5000", sofaBootRpcProperties.getBoltPort());
    }

    @Test
    public void testUnderscoreConfig() {
        Assert.assertEquals("600", sofaBootRpcProperties.getBoltIoThreadCount());
    }
}
