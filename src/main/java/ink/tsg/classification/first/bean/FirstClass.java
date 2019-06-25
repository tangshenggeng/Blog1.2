package ink.tsg.classification.first.bean;


import org.hibernate.validator.constraints.NotBlank;

public class FirstClass {
    private Integer fclassificationId;
    
    @NotBlank(message="请输入名称")
    private String fclassificationName;

    public Integer getFclassificationId() {
        return fclassificationId;
    }

    public void setFclassificationId(Integer fclassificationId) {
        this.fclassificationId = fclassificationId;
    }

    public String getFclassificationName() {
        return fclassificationName;
    }

    public void setFclassificationName(String fclassificationName) {
        this.fclassificationName = fclassificationName == null ? null : fclassificationName.trim();
    }

	@Override
	public String toString() {
		return "FirstClass [fclassificationId=" + fclassificationId + ", fclassificationName=" + fclassificationName
				+ "]";
	}
}