package risorse;

public class ZC6616 {
	private String type = "Xperia Z C6616";
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String nation;
	private String brand;
	private String serial;
	private String version;
	private String newVersion;
	public String getNewVersion() {
		return newVersion;
	}
	public void setNewVersion(String newVersion) {
		this.newVersion = newVersion;
	}
	private String link = "http://fuas.sonymobile.com/fuas/services/updates?clientName=PCC&clientVersion=3.0&lang=en-US&"
			+ "model=C6616&tac_mc=01370100&swId=1269-5309&swVer=10.1.1.A.1.319&fsVariant=BELL-LTE&cdfVer=R2A&"
			+ "buildVariant=USER&clientCertType=live&updateFormat=delta,image&channel=cable&cdfId=";
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public ZC6616(String nation, String brand, String serial, String version) {
		super();
		this.nation = nation;
		this.brand = brand;
		this.serial = serial;
		this.version = version;
	}

}