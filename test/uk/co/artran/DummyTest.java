package uk.co.artran;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import uk.co.artran.rules.exception.ExpectedException;
import uk.co.artran.rules.exception.ExpectedExceptionRule;
import uk.co.artran.rules.wip.WorkInProgress;
import uk.co.artran.rules.wip.WorkInProgressRule;

import static org.fest.assertions.api.Assertions.assertThat;
import static uk.co.artran.Dummy.not;
import static uk.co.artran.Dummy.notQuite;
import static uk.co.artran.Dummy.throwsAnException;

public class DummyTest {
    @Rule
    public TestRule workInProgressRule = new WorkInProgressRule();

    @Rule
    public TestRule expectedExceptionRule = new ExpectedExceptionRule();

    @Test
    public void testNot() throws Exception {
        assertThat(not(true)).isEqualTo(false);
    }

    @Test
    @WorkInProgress(reason = "shouldn't work")
    public void testNotQuite() throws Exception {
        assertThat(notQuite(true)).isEqualTo(false);
    }

    @Test
    @ExpectedException(expectedClass = RuntimeException.class)
    public void testThrowsException() throws Exception {
        throwsAnException();
    }
}
