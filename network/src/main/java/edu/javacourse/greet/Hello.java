package edu.javacourse.greet;

import edu.javacourse.net.Greetable;

public class Hello extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "What's app bro " + userName;
    }
}
