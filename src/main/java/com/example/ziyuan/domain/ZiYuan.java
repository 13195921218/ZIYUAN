package com.example.ziyuan.domain;

public class ZiYuan {
    private String vdcName;
    private String cloudLocationName;
    private String name;
    private String flavorRamSize;
    private String flavorVcpu;
    private String nativeId;
    private String engineVersion;
    private String usedMemory;
    private String ip;
    private String cacheMode;
    private String bizRegionName;

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(String usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCacheMode() {
        return cacheMode;
    }

    public void setCacheMode(String cacheMode) {
        this.cacheMode = cacheMode;
    }

    public String getBizRegionName() {
        return bizRegionName;
    }

    public void setBizRegionName(String bizRegionName) {
        this.bizRegionName = bizRegionName;
    }

    public String getVdcName() {
        return vdcName;
    }

    public void setVdcName(String vdcName) {
        this.vdcName = vdcName;
    }

    public String getCloudLocationName() {
        return cloudLocationName;
    }

    public void setCloudLocationName(String cloudLocationName) {
        this.cloudLocationName = cloudLocationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavorRamSize() {
        return flavorRamSize;
    }

    public void setFlavorRamSize(String flavorRamSize) {
        this.flavorRamSize = flavorRamSize;
    }

    public String getFlavorVcpu() {
        return flavorVcpu;
    }

    public void setFlavorVcpu(String flavorVcpu) {
        this.flavorVcpu = flavorVcpu;
    }

    public String getNativeId() {
        return nativeId;
    }

    public void setNativeId(String nativeId) {
        this.nativeId = nativeId;
    }
}
