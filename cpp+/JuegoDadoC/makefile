# --- Configuración ---
CC       := gcc
CXX      := g++
TARGET   := programa.exe
SRC_DIR  := src
OBJ_DIR  := temp_objs

# --- Flags Inteligentes ---
# -I$(SRC_DIR) permite hacer #include "models/user.h" desde cualquier sitio
CFLAGS   := -Wall -Wextra -O2 -I$(SRC_DIR)
CXXFLAGS := -Wall -Wextra -O2 -I$(SRC_DIR) -std=c++17

# --- Búsqueda Recursiva Relevante ---
# Encuentra TODOS los archivos en cualquier subcarpeta de src
SRCS_C   := $(shell find $(SRC_DIR) -name "*.c")
SRCS_CPP := $(shell find $(SRC_DIR) -name "*.cpp")

# Genera los .o manteniendo la estructura de carpetas dentro de temp_objs
OBJS     := $(patsubst %.c, $(OBJ_DIR)/%.o, $(SRCS_C)) \
            $(patsubst %.cpp, $(OBJ_DIR)/%.o, $(SRCS_CPP))

# --- Colores ---
GREEN := \033[1;32m
CYAN  := \033[1;36m
RESET := \033[0m

# --- Reglas de Compilación ---

all: $(TARGET)
	@echo "$(GREEN)✔ Limpiando temporales y finalizando...$(RESET)"
	@rm -rf $(OBJ_DIR)

# Enlace: $^ usa todos los objetos detectados
$(TARGET): $(OBJS)
	@echo "$(CYAN)Linking [$(TARGET)]...$(RESET)"
	@$(CXX) $(CXXFLAGS) $^ -o $@

# Compilación de C
$(OBJ_DIR)/%.o: %.c
	@mkdir -p $(dir $@)
	@echo "Compilando C:   $<"
	@$(CC) $(CFLAGS) -c $< -o $@

# Compilación de C++
$(OBJ_DIR)/%.o: %.cpp
	@mkdir -p $(dir $@)
	@echo "Compilando CPP: $<"
	@$(CXX) $(CXXFLAGS) -c $< -o $@
@echo '' > src/models/class1.h
# --- Regla Setup Profesional --@echo '' > src/models/class1.h-
setup:
	@echo "$(CYAN)Creando carpetas$(RESET)"
	@mkdir -p src/models src/core src/utils src/network
	@# Creamos un modelo de ejemplo en C++
	@echo '/*header de la clase 1*/' > src/models/class1.h
	@echo '/*implementacion de la clase 1*/' > src/models/class1.c
	@# Creamos el main que usa la estructura
	@echo '' > src/main.cpp
	@echo "$(GREEN)Proyecto listo para escalar.$(RESET)"

clean:
	@rm -rf $(TARGET) $(OBJ_DIR)
	@echo "Proyecto limpio."

run: all
	@./$(TARGET)

.PHONY: all clean run setup
