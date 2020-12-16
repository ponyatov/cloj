repl:
	lein repl
	make $@

MERGE += Makefile project.clj src

master:
	git checkout $@
	git checkout shadow -- $(MERGE)
shadow:
	git checkout $@
