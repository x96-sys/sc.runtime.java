BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
CLI_BUILD     = $(BUILD_DIR)/cli
TEST_BUILD    = $(BUILD_DIR)/test

SRC_MAIN      = src/main
SRC_CLI       = src/cli
SRC_TEST      = src/test

LIB_DIR        = lib
TOOLS_DIR      = tools

CS_RUNTIME_VERSION = 1.0.2
CS_RUNTIME_BIN     = $(LIB_DIR)/org.x96.sys.cs-deps.jar
CS_RUNTIME_URL     = https://github.com/x96-sys/cs.runtime.java/releases/download/v$(CS_RUNTIME_VERSION)/org.x96.sys.cs-deps.jar
CS_RUNTIME_SHA256  = 737cb08c1b6fa3768380bfe2db36bf3dc57e87d2e7e5d63e6cbd36d46ae2d150

JAVA_SOURCES := $(shell find $(SRC_MAIN) -name "*.java")

CP = $(CS_RUNTIME_BIN)

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

build:
	@echo "[☕️] [compiling] [`javac --version`]"
	@javac -d $(MAIN_BUILD) -cp $(CP) $(JAVA_SOURCES)
	@echo "[🦿] [compiled] [$(MAIN_BUILD)]"

cs:
	@echo "[cs] [run] [$(CS_RUNTIME_VERSION)]"
	@java -jar $(CP) $(ARGS)

sc:
	@echo "[☕️] [running] [`java --version`]"
	@java -cp $(MAIN_BUILD):$(CP) FlyTime $(ARGS)

libs: $(LIB_DIR)/cs_runtime

$(eval $(call deps,$(LIB_DIR),cs_runtime,CS_RUNTIME))

$(LIB_DIR):
	@mkdir -p $@
