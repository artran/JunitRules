JunitRules
==========

Some rules to help with JUnit tests.

WorkInProgressRule
------------------

Used with the @WorkInProgress annotation to say that a test is expected to fail. The test fails if the assertions
pass.

ExpectedExceptionRule
---------------------

Used with @ExpectedException annotation to say that a test should throw the specified exception. The test fails
if a different Exception is thrown or if no exception is thrown.