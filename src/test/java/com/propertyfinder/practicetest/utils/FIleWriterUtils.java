package com.propertyfinder.practicetest.utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FIleWriterUtils {

    public void generateCsv(String fileOutputPath, Map result) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileOutputPath, false), ',');
        result.forEach((key, value) -> {
            String splitArray[] = value.toString().split("-");
            String[] entries = {key.toString(), splitArray[0], splitArray[1]};
            writer.writeNext(entries, false);
        });
        writer.close();
    }

    public void writeToTxt(String agentdetails) throws IOException {
        FileWriter textfile = new FileWriter("src/test/agent.txt");
        textfile.write(agentdetails);
        textfile.close();
    }
}
