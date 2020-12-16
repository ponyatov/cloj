repl:
	lein repl
	make $@

MERGE += README.md Makefile project.clj src

master:
	git checkout $@
	git checkout shadow -- $(MERGE)
shadow:
	git checkout $@
