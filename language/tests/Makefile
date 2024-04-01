DEBUG_FILES=stack-dump-before data-dump-before extra-roots-dump-before heap-dump-before stack-dump-after data-dump-after extra-roots-dump-after heap-dump-after
TESTS=$(sort $(filter-out test111, $(basename $(wildcard test*.lama))))

LAMAR=../../sl -J-Xss4m

.PHONY: check $(TESTS)

check: $(TESTS)

$(TESTS): %: %.lama
	echo "regression/$@"
	cat $@.input | $(LAMAR) --disable-launcher-output $@.lama > $@.log && diff $@.log orig/$@.log

clean:
	$(RM) test*.log *.s *.sm *~ $(TESTS) *.i $(DEBUG_FILES)
	$(MAKE) clean -C expressions
	$(MAKE) clean -C deep-expressions
