package com.hazelcast.util;

import com.hazelcast.test.HazelcastParallelClassRunner;
import com.hazelcast.test.annotation.QuickTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(HazelcastParallelClassRunner.class)
@Category(QuickTest.class)
public class HazelcastUtilTest {

    @Test
    public void testReadValues() {

        String version = HazelcastUtil.getVersion();
        String build = HazelcastUtil.getBuild();
        int buildNumber = HazelcastUtil.getBuildNumber();

        assertEquals("3.3",version);
        assertEquals("1",build);
        assertEquals(1,buildNumber);
        assertFalse(HazelcastUtil.isEnterprise());

    }

    @Test
    public void testOverrideBuildNumber() {

        System.setProperty("hazelcast.build","2");

        String version = HazelcastUtil.getVersion();
        String build = HazelcastUtil.getBuild();
        int buildNumber = HazelcastUtil.getBuildNumber();

        assertEquals("3.3",version);
        assertEquals("2",build);
        assertEquals(2,buildNumber);
        assertFalse(HazelcastUtil.isEnterprise());

    }

}
