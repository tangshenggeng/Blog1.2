package ink.tsg.classification.second.bean;


import org.hibernate.validator.constraints.NotBlank;

import ink.tsg.classification.first.bean.FirstClass;


public class SecondClass {
    private Integer sclassificationId;
    
    @NotBlank(message="请填写分类名称！")
    private String sclassificationName;

    private Integer scFcId;
    
    private FirstClass firstClass;
    
    public Integer getSclassificationId() {
        return sclassificationId;
    }

    public void setSclassificationId(Integer sclassificationId) {
        this.sclassificationId = sclassificationId;
    }

    public String getSclassificationName() {
        return sclassificationName;
    }

    public void setSclassificationName(String sclassificationName) {
        this.sclassificationName = sclassificationName == null ? null : sclassificationName.trim();
    }

    public Integer getScFcId() {
        return scFcId;
    }

    public void setScFcId(Integer scFcId) {
        this.scFcId = scFcId;
    }

	public FirstClass getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(FirstClass firstClass) {
		this.firstClass = firstClass;
	}

	@Override
	public String toString() {
		return "SecondClass [sclassificationId=" + sclassificationId + ", sclassificationName=" + sclassificationName
				+ ", scFcId=" + scFcId + ", firstClass=" + firstClass + "]";
	}
}