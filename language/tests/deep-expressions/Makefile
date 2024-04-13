TESTS=$(sort $(basename $(wildcard generated*.lama)))

# RC = ../../src/lamac
LAMAR=../../../standalone/target/slnative

.PHONY: check $(TESTS)

check: $(TESTS)

$(TESTS): %: %.lama
	@echo "regression/deep-expressions/$@"
	@cat $@.input | $(LAMAR) --disable-launcher-output $@.lama > $@.log && diff $@.log orig/$@.log

clean:
	rm -f *.log *.s *~
	find . -maxdepth 1 -type f -not -name '*.*' -not -name 'Makefile' -delete
