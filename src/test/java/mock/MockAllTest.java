package mock;

import junit.framework.TestCase;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class MockAllTest extends TestCase {

    public void testRefreshData() {
        MockAll mockAll = new MockAll();

        mockAll.refreshData();
    }
}