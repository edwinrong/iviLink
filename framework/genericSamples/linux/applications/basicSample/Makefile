# 
# iviLINK SDK, version 1.1.2
# http://www.ivilink.net
# Cross Platform Application Communication Stack for In-Vehicle Applications
# 
# Copyright (C) 2012, Luxoft Professional Corp., member of IBS group
# 
# This library is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; version 2.1.
# 
# This library is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
# Lesser General Public License for more details.
# 
# You should have received a copy of the GNU Lesser General Public
# License along with this library; if not, write to the Free Software
# Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
# 
# 
ifndef CONFIG_MK_EXPORTED
ifdef AXIS_CONFIG_MK
include $(AXIS_CONFIG_MK)
else
$(error config.mk is not exported and AXIS_CONFIG_MK variable cannot be found)
endif
endif
ifndef COMMON_MK
$(error COMMON_MK is not defined)
endif
include $(COMMON_MK)

###############################################################################
# Subfolders
define SUBFOLDERS
endef
###############################################################################
# This target

SRC_DIR := .
SRC := $(wildcard $(SRC_DIR)/*.cpp)

OUT_FNAME     := BasicSample

INCLUDES      += -I.
INCLUDES	     += -I$(IVILINK_INCLUDE_COMMON_DIR)
INCLUDES	     += -I$(IVILINK_INCLUDE_DIR)ApplicationLibrary/
INCLUDES      += -I$(FW_DIR)genericSamples/linux/serviceSources/
INCLUDES      += -I$(IVILINK_INCLUDE_UTILS_DIR)misc/
INCLUDES      += -I$(IVILINK_INCLUDE_UTILS_DIR)threads/


export OBJ_DIR := obj

CFLAGS   := -I$(ROOT_DIR) -Wall -pthread -fPIC -I$(3RD_PARTY_RES_DIR)include 
LDFLAGS  := -L$(ROOT_DIR) -lrt -ldl -pthread -L$(IVILINK_LIB_DIR) -Wl,-rpath,$(PREFIX)
LDFLAGS += -L$(RESULT_DIR)/framework/utils/sharedLib/
LDFLAGS += -L$(RESULT_DIR)/framework/components/ChannelSupervisor/ChannelLib/
LDFLAGS += -L$(RESULT_DIR)/framework/sharedLibs/applicationSharedLib/
LDFLAGS += -llog4cplus -Wl,-rpath,$(IVILINK_LIB_DIR)
CFLAGS += -DUSELOG4CPLUS
CXXFLAGS := $(CFLAGS)

DLL_CFLAGS   := 
DLL_CXXFLAGS := $(DLL_CFLAGS)
DLL_LDFALGS  :=  

CXXFLAGS      := $(CXXFLAGS) $(DLL_CXXFLAGS) $(INCLUDES)
CFLAGS        := $(CFLAGS) $(DLL_CFLAGS) $(INCLUDES) -std=c99
LDFLAGS       := $(LDFLAGS) $(GLOBAL_DLL_LDFALGS)

LIBS := $(addprefix $(RESULT_DIR)/,$(LIBS))

DLIBS := 
DLIBS += $(RESULT_DIR)/framework/sharedLibs/applicationSharedLib/libIviLinkApp.so
DLIBS += $(RESULT_DIR)/framework/components/ChannelSupervisor/ChannelLib/libIviLinkChannel.so
DLIBS += $(RESULT_DIR)/framework/utils/sharedLib/libIviLinkUtils.so

###############################################################################
# Variables

OUT_PATH := $(call OUT_PATH_FUNC)
$(info OUT_PATH $(OUT_PATH))

OUT_FULLDIR   := $(OUT_PATH)
OUT_FULLFNAME := $(OUT_FULLDIR)$(OUT_FNAME)


OBJ_FULLDIR := $(OUT_PATH)$(OBJ_DIR)
OBJS        := $(SRC:.cpp=.o)
OBJS        := $(OBJS:.c=.o)
OBJS        := $(addprefix $(OBJ_FULLDIR)/,$(notdir $(OBJS)))
DEPS        := $(OBJS:.o=.d)


###############################################################################
# Rules
$(OUT_FULLDIR):
	mkdir -p $@

$(OBJ_FULLDIR):
	mkdir -p $@

$(OUT_FULLFNAME): $(OBJS) $(call GET_DEPS, $(LIBS)) $(DLIBS) | $(OUT_FULLDIR) 
	$(CXX) $(OBJS) $(call GET_LIB_LDFLAGS,$(LIBS),$(DLIBS)) $(LDFLAGS) -o $@


$(OBJ_FULLDIR)/%.o: $(SRC_DIR)/%.cpp | $(OBJ_FULLDIR)
	$(CXX) -c $< $(CXXFLAGS) -MMD -o $@

debug:  $(OUT_FULLFNAME)
	$(SUBFOLDERS)

release: $(OUT_FULLFNAME)
	 $(SUBFOLDERS)
	 
clean:
	-rm -rf $(OBJ_FULLDIR)
	-rm -rf $(OUT_FULLDIR)
	$(SUBFOLDERS)

.PHONY: debug release clean
 

ifeq (,$(findstring $(MAKECMDGOALS),dist clean depend doc docs))
-include $(DEPS)
endif
