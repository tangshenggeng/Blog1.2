package ink.tsg.classification.third.bean;

import org.hibernate.validator.constraints.NotBlank;

import ink.tsg.classification.second.bean.SecondClass;

public class ThirdClass {
    private Integer tclassificationId;
    
    @NotBlank(message="请填写名称！")
    private String tclassificationName;

    private Integer tcScId;
    
    private SecondClass secondClass;

    public Integer getTclassificationId() {
        return tclassificationId;
    }

    public void setTclassificationId(Integer tclassificationId) {
        this.tclassificationId = tclassificationId;
    }

    public String getTclassificationName() {
        return tclassificationName;
    }

    public void setTclassificationName(String tclassificationName) {
        this.tclassificationName = tclassificationName == null ? null : tclassificationName.trim();
    }

    public Integer getTcScId() {
        return tcScId;
    }

    public void setTcScId(Integer tcScId) {
        this.tcScId = tcScId;
    }

	public SecondClass getSecondClass() {
		return secondClass;
	}

	public void setSecondClass(SecondClass secondClass) {
		this.secondClass = secondClass;
	}

	@Override
	public String toString() {
		return "ThirdClass [tclassificationId=" + tclassificationId + ", tclassificationName=" + tclassificationName
				+ ", tcScId=" + tcScId + ", secondClass=" + secondClass + "]";
	}
	
}