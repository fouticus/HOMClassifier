# HOMClassifier
An experimental higher order equivalent mutant classifier.

This was the final project for a software engineering/testing class, where I investigated a new form of [Mutation Testing](https://en.wikipedia.org/wiki/Mutation_testing).
Mutation testing is a way to evaluate code coverage of a test suite by automatically making small changes to the codebase and determining whether a set of software tests can distinguish between the mutants and the original code.
Mutants are "killed" if at least one tests fails which otherwise passes for the original code, and the ability to kill all mutants is a mark of a thorough test suite.
Unfortunately, some automatically created mutants are functionally identical to the original code, making them unkillable, and distorting the perceived code coverage.
Rather than require human review of unkilled mutants, I investigated a way to automatically identify whether mutants were unkillable by combining them together and using some simple classification rules.

