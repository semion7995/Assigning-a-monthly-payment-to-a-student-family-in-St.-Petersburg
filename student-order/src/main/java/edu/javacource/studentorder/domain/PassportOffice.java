package edu.javacource.studentorder.domain;

public class PassportOffice
{
    private Long officeId;
    private String officeAreaId;
    private String officeName;

    public PassportOffice() {
    }

    public PassportOffice(Long officeId, String officeAreaId, String officeName) {
        this.officeId = officeId;
        this.officeAreaId = officeAreaId;
        this.officeName = officeName;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeAreaId() {
        return officeAreaId;
    }

    public void setOfficeAreaId(String officeAreaId) {
        this.officeAreaId = officeAreaId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @Override
    public String toString() {
        return "PassportOffice{" +
                "officeId=" + officeId +
                ", officeAreaId='" + officeAreaId + '\'' +
                ", officeName='" + officeName + '\'' +
                '}';
    }
}
/**
 * p_office_id integer not null,
 * 	p_office_area_id char(12) not null,
 * 	p_office_name varchar(200),
 * 	PRIMARY KEY (p_office_id),
 * 	FOREIGN KEY (p_office_area_id) REFERENCES jc_country_struct(area_id) ON DELETE RESTRICT
 * );
 */
