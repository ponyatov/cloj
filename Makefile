# \ <section:var>
MODULE     = $(notdir $(CURDIR))
OS         = $(shell uname -s)
MACHINE    = $(shell uname -m)
NOW        = $(shell date +%d%m%y)
REL        = $(shell git rev-parse --short=4 HEAD)
# / <section:var>
# \ <section:dir>
CWD        = $(CURDIR)
DOC        = $(CWD)/doc
BIN        = $(CWD)/bin
SRC        = $(CWD)/src
TMP        = $(CWD)/tmp
# / <section:dir>
# \ <section:tool>
CURL       = curl
PY         = $(BIN)/python3
PIP        = $(BIN)/pip3
PEP        = $(BIN)/autopep8
PYT        = $(BIN)/pytest
# / <section:tool>
# \ <section:obj>
J	+= project.clj src/cloj/core.clj
R	+= src/hello.rs
C	+= src/hello.c
S 	+= $(J) $(R) $(C)
# / <section:obj>
# \ <section:all>
repl:
	lein repl
	make $@
# / <section:all>
# \ <section:install>
.PHONY: install
install:
	$(MAKE) update
.PHONY: update
update: $(OS)_install
	$(PIP) install -U pip autopep8
	$(PIP) install -U -r requirements.pip
.PHONY: $(OS)_install $(OS)_update
$(OS)_install $(OS)_update:
	sudo apt update
	sudo apt install -u `cat apt.txt`
# \ <section:pyinst>
$(PY) $(PIP):
	python3 -m venv .
	$(MAKE) update
# / <section:pyinst>
# / <section:install>
# \ <section:merge>
MERGE  = Makefile README.md apt.txt .gitignore .vscode $(S)

.PHONY: master
master:
	git push -v
	git checkout $@
	git pull -v
	git checkout shadow -- $(MERGE)
.PHONY: shadow
shadow:
	git pull -v
	git checkout $@
	git pull -v
.PHONY: release
release:
	git tag $(NOW)-$(REL)
	git push -v && git push -v --tags
	$(MAKE) shadow
# / <section:merge>
