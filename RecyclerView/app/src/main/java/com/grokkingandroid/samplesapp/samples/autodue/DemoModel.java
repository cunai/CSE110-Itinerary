package com.grokkingandroid.samplesapp.samples.autodue;

import java.util.Date;

public class DemoModel {
    private static int nextId = 0;
    String label;
    Date dateTime;
    String pathToImage;
    int id = ++nextId;
    int priority;
}
