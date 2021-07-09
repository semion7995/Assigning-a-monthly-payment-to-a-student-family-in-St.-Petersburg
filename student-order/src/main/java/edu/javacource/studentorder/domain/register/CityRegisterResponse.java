package edu.javacource.studentorder.domain.register;
// сущность для получения ответа от базы регистров
public class CityRegisterResponse {
    private boolean existing;
    private Boolean temporal;//временная регистрация

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "CityRegisterResponse{" +
                "existing=" + existing +
                ", temporal=" + temporal +
                '}';
    }
}
