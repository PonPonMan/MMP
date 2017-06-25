package com.module.device.bean;

public class Device implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int Id;
	private String device;
	private String firm;
	private String language;
	private String size;
	private String system;
	private String resolution;
	private String cpu;
	private String lamp;
	private int pitNum;
	private String network;
	private String remark;
	private int flag;
	private String useAdmin;
	private String area;
	private String sn;
	private int platform;
	private String serialNumber;
	private int exeStatus;// 手机状态 0：空闲，1：正在检测，2：正在执行
	private int connectStatus;//连接状态，是否连着
	private String financenum;
	private String lastLeaveTime;//上次拔走时间

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getLamp() {
		return lamp;
	}

	public void setLamp(String lamp) {
		this.lamp = lamp;
	}

	public int getPitNum() {
		return pitNum;
	}

	public void setPitNum(int pitNum) {
		this.pitNum = pitNum;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getUseAdmin() {
		return useAdmin;
	}

	public void setUseAdmin(String useAdmin) {
		this.useAdmin = useAdmin;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getExeStatus() {
		return exeStatus;
	}

	public void setExeStatus(int exeStatus) {
		this.exeStatus = exeStatus;
	}

	public String getFinancenum() {
		return financenum;
	}

	public void setFinancenum(String financenum) {
		this.financenum = financenum;
	}

	public int getConnectStatus() {
		return connectStatus;
	}

	public void setConnectStatus(int connectStatus) {
		this.connectStatus = connectStatus;
	}

	public String getLastLeaveTime() {
		return lastLeaveTime;
	}

	public void setLastLeaveTime(String lastLeaveTime) {
		this.lastLeaveTime = lastLeaveTime;
	}

}
