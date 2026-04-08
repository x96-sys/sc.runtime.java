BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
CLI_BUILD     = $(BUILD_DIR)/cli
TEST_BUILD    = $(BUILD_DIR)/test

SRC_MAIN      = src/main
SRC_CLI       = src/cli
SRC_TEST      = src/test
SRC_TEST_JAVA = $(SRC_TEST)/java
SRC_TEST_RESOURCES = $(SRC_TEST)/resources

LIB_DIR        = lib
TOOLS_DIR      = tools

CS_RUNTIME_VERSION = 1.0.2
CS_RUNTIME_BIN     = $(LIB_DIR)/org.x96.sys.cs-deps.jar
CS_RUNTIME_URL     = https://github.com/x96-sys/cs.runtime.java/releases/download/v$(CS_RUNTIME_VERSION)/org.x96.sys.cs-deps.jar
CS_RUNTIME_SHA256  = 737cb08c1b6fa3768380bfe2db36bf3dc57e87d2e7e5d63e6cbd36d46ae2d150

JUNIT_VERSION = 1.13.4
JUNIT_BIN     = $(TOOLS_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar
JUNIT_SHA256  = 3fdfc37e29744a9a67dd5365e81467e26fbde0b7aa204e6f8bbe79eeaa7ae892

JACOCO_VERSION = 0.8.13
JACOCO_BASE    = https://maven.org/maven2/org/jacoco

JACOCO_CLI_VERSION = $(JACOCO_VERSION)
JACOCO_CLI_BIN     = $(TOOLS_DIR)/jacococli.jar
JACOCO_CLI_URL     = $(JACOCO_BASE)/org.jacoco.cli/$(JACOCO_CLI_VERSION)/org.jacoco.cli-$(JACOCO_CLI_VERSION)-nodeps.jar
JACOCO_CLI_SHA256  = 8f748683833d4dc4d72cea5d6b43f49344687b831e0582c97bcb9b984e3de0a3

JACOCO_AGENT_VERSION = $(JACOCO_VERSION)
JACOCO_AGENT_BIN     = $(TOOLS_DIR)/jacocoagent-runtime.jar
JACOCO_AGENT_URL     = $(JACOCO_BASE)/org.jacoco.agent/$(JACOCO_AGENT_VERSION)/org.jacoco.agent-$(JACOCO_AGENT_VERSION)-runtime.jar
JACOCO_AGENT_SHA256  = 47e700ccb0fdb9e27c5241353f8161938f4e53c3561dd35e063c5fe88dc3349b

GJF_VERSION = 1.28.0
GJF_BIN     = $(TOOLS_DIR)/gjf.jar
GJF_URL     = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar
GJF_SHA256  = 32342e7c1b4600f80df3471da46aee8012d3e1445d5ea1be1fb71289b07cc735

JAVA_SOURCES      := $(shell find $(SRC_MAIN) -name "*.java")
JAVA_TEST_SOURCES := $(shell find $(SRC_TEST_JAVA) -name "*.java")

CP  = $(CS_RUNTIME_BIN)
CPT = $(JUNIT_BIN):$(CP)

define deps
$1/$2: $1
	@expected="$($3_SHA256)"; \
	bin="$($3_BIN)"; \
	url="$($3_URL)"; \
	tmp="$$$$(mktemp)"; \
	if [ ! -f "$$$$bin" ]; then \
		echo "[📦] [🚛] [$($3_VERSION)] [$2]"; \
		curl -sSL -o "$$$$tmp" "$$$$url"; \
		actual="$$$$(shasum -a 256 $$$$tmp | awk '{print $$$$1}')"; \
		if [ "$$$$expected" = "$$$$actual" ]; then mv "$$$$tmp" "$$$$bin"; \
		echo "[📦] [📍] [$($3_VERSION)] [$2] [🐚]"; else rm "$$$$tmp"; \
		echo "[❌] [hash mismatch] [$2]"; exit 1; fi; \
	else \
		actual="$$$$(shasum -a 256 $$$$bin | awk '{print $$$$1}')"; \
		if [ "$$$$expected" = "$$$$actual" ]; \
		then echo "[📦] [📍] [$($3_VERSION)] [🐚] [$2]"; \
		else \
			echo "[❌] [hash mismatch] [$2]"; \
			curl -sSL -o "$$$$tmp" "$$$$url"; \
			actual="$$$$(shasum -a 256 $$$$tmp | awk '{print $$$$1}')"; \
			if [ "$$$$expected" = "$$$$actual" ]; then mv "$$$$tmp" "$$$$bin"; \
			echo "[📦] [♻️] [$($3_VERSION)] [🐚] [$2]"; else rm "$$$$tmp"; \
			echo "[❌] [download failed] [$2]"; exit 1; fi; \
		fi; \
	fi
endef

build: clean/build/main
	@echo "[☕️] [compiling] [`javac --version`]"
	@javac -d $(MAIN_BUILD) -cp $(CP) $(JAVA_SOURCES)
	@echo "[🦿] [compiled] [$(MAIN_BUILD)]"

build/test: clean/build/test build
	@echo "[☕️] [compiling] [`javac --version`]"
	@javac -d $(TEST_BUILD) -cp $(CPT):$(MAIN_BUILD) $(JAVA_TEST_SOURCES)
	@echo "[🦾] [compiled] [$(TEST_BUILD)]"

test: build/test
	@java -jar $(JUNIT_BIN) \
	   execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
	   --scan-class-path

test/class: build/test
	@java -jar $(JUNIT_BIN) \
	   execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
	   --select-class $(CLASS)

COVERAGE_EXEC = $(BUILD_DIR)/jacoco.exec
COVERAGE_REPORT = $(BUILD_DIR)/coverage

coverage: build/test $(COVERAGE_REPORT)
	@echo "[📊] Running tests with JaCoCo agent..."
	@java -javaagent:$(JACOCO_AGENT_BIN)=destfile=$(COVERAGE_EXEC) \
		-jar $(JUNIT_BIN) \
		execute \
		--class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
		--scan-class-path
	@echo "[📑] Generating coverage report..."
	@java -jar $(JACOCO_CLI_BIN) report $(COVERAGE_EXEC) \
		--classfiles $(MAIN_BUILD) \
		--sourcefiles $(SRC_MAIN) \
		--html $(COVERAGE_REPORT) \
		--xml  $(COVERAGE_REPORT)/coverage.xml \
		--csv  $(COVERAGE_REPORT)/coverage.csv
	@echo "[✅] Coverage report available in $(COVERAGE_REPORT)/index.html"

cs:
	@echo "[cs] [run] [$(CS_RUNTIME_VERSION)]"
	@java -jar $(CP) $(ARGS)

sc:
	@echo "[☕️] [running] [`java --version`]"
	@java -cp $(MAIN_BUILD):$(CP) FlyTime $(ARGS)

repl: build
	@echo "[☕️] [running] [`java --version`]"
	@java -cp $(MAIN_BUILD):$(CP) org.x96.sys.sc.kernel.Kernel

libs: $(LIB_DIR)/cs_runtime

$(eval $(call deps,$(LIB_DIR),cs_runtime,CS_RUNTIME))

$(LIB_DIR) $(TOOLS_DIR) $(COVERAGE_REPORT):
	@mkdir -p $@

kit: \
	$(TOOLS_DIR)/junit \
	$(TOOLS_DIR)/jacoco_cli \
	$(TOOLS_DIR)/jacoco_agent \
	$(TOOLS_DIR)/gjf

$(eval $(call deps,$(TOOLS_DIR),junit,JUNIT))
$(eval $(call deps,$(TOOLS_DIR),jacoco_cli,JACOCO_CLI))
$(eval $(call deps,$(TOOLS_DIR),jacoco_agent,JACOCO_AGENT))
$(eval $(call deps,$(TOOLS_DIR),gjf,GJF))

format: kit
	@find src -path "src/test/resources" -prune -o -name "*.java" -print0 \
      | xargs -0 java -jar $(GJF_BIN) --aosp --replace
	@echo "[✨] source formated"

clean/build/main:
	@rm -rf $(MAIN_BUILD)
	@echo "[🧼] [clean] [$(MAIN_BUILD)]"

clean/build/test:
	@rm -rf $(TEST_BUILD)
	@echo "[🧽] [clean] [$(TEST_BUILD)]"