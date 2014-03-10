package uk.co.artran.rules.wip;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static junit.framework.Assert.fail;

public class WorkInProgressRule implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        if (testIsWorkInProgress(description)) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        base.evaluate();
                    } catch (Throwable e) {
                        return; // We EXPECT to see an AssertionException in WIP tests
                    }

                    fail("Unexpected success. Reason = " + description.getAnnotation(WorkInProgress.class).reason());
                }
            };
        }

        return base;
    }

    private boolean testIsWorkInProgress(Description description) {
        return description.getAnnotation(WorkInProgress.class) != null;
    }
}
