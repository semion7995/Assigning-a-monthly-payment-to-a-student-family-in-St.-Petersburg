package edu.javacource.studentorder.domain.register;
// сущность для получения ответа от базы регистров
public class CityRegisterResponse {
    private boolean register;
    private boolean temporal;//временная регистрация

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "CityRegisterResponse{" +
                "registered=" + register +
                ", temporal=" + temporal +
                '}';
    }
}
