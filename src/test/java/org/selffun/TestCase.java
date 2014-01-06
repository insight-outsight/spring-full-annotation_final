package org.selffun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class) 
public class TestCase {

	 @Test public void testSomeBeanBehavior() { } 
}
