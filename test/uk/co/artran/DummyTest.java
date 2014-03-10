package uk.co.artran;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.fest.assertions.api.Assertions.assertThat;
import static uk.co.artran.Dummy.not;
import static uk.co.artran.Dummy.notQuite;

public class DummyTest {
    @Rule
    public TestRule workInProgressRule = new WorkInProgressRule();

    @Test
    public void testNot() throws Exception {
        assertThat(not(true)).isEqualTo(false);
    }

    @Test
    @WorkInProgress(reason = "shouldn't work")
    public void testNotQuite() throws Exception {
        assertThat(notQuite(true)).isEqualTo(false);
    }
}
