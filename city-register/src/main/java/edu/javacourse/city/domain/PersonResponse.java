package edu.javacourse.city.domain;

public class PersonResponse {
    private boolean register;
    private boolean temporal;

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
        return "PersonResponse{" +
                "register=" + register +
                ", temporal=" + temporal +
                '}';
    }
}
