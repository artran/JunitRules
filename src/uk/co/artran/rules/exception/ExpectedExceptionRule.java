package uk.co.artran.rules.exception;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.fest.assertions.api.Assertions.fail;

public class ExpectedExceptionRule implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        if (description.getAnnotation(ExpectedException.class) != null) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        base.evaluate();
                    } catch (Throwable ex) {
                        if (ex.getClass().equals(description.getAnnotation(ExpectedException.class).expectedClass())) {
                            // TODO: also match message
                            return;  // Expected type matches
                        }

                        fail("Unexpected exception");
                    }
                    fail("Expected exception was not thrown");
                }
            };
        }

        return base;
    }
}
