package edu.javacourse.register.dao;

import edu.javacourse.register.view.MarriageRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarriageDaoTest {

    @Test
    public void findMarriageCertificate() {
        MarriageDao md = new MarriageDao();
        MarriageRequest request = new MarriageRequest();

        md.findMarriageCertificate(request);
    }
}