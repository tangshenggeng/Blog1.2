package ink.tsg.cst.bean;

public class Platform {
    private Integer plaId;

    private String plaName;

    public Integer getPlaId() {
        return plaId;
    }

    public void setPlaId(Integer plaId) {
        this.plaId = plaId;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName == null ? null : plaName.trim();
    }

	@Override
	public String toString() {
		return "Platform [plaId=" + plaId + ", plaName=" + plaName + "]";
	}
}