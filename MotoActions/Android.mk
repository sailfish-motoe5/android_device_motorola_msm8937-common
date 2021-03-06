LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_PACKAGE_NAME := MotoActions
LOCAL_CERTIFICATE := platform
LOCAL_PRIVATE_PLATFORM_APIS := true
LOCAL_USE_AAPT2 := true
LOCAL_PROPRIETARY_MODULE := true

LOCAL_STATIC_JAVA_LIBRARIES := \
    android-support-v14-preference \
    android-support-v7-appcompat \
    android-support-v7-preference \
    android-support-v7-recyclerview

LOCAL_STATIC_JAVA_LIBRARIES := \
    org.lineageos.platform.internal

LOCAL_PROGUARD_FLAG_FILES := proguard.flags

LOCAL_RESOURCE_DIR := \
    $(LOCAL_PATH)/res \
    $(LOCAL_PATH)/../../../../packages/resources/devicesettings/res

LOCAL_PROGUARD_ENABLED := disabled
LOCAL_DEX_PREOPT := false

include $(BUILD_PACKAGE)

include $(call all-makefiles-under,$(LOCAL_PATH))
