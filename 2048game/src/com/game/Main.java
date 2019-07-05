package com.game;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
    private static final Path saveFilePath = FileSystems.getDefault().getPath( "saveRecord");
    private static final File saveRecordFile = saveFilePath.toFile();
    private static final Model model = new Model();

    public static void main(String[] args) {
        Controller controller = new Controller(model);
        View view = new View(controller);
        controller.setView(view);
        readRecord();
    }

    static void writeRecord() {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(saveRecordFile))) {
            output.writeInt(model.record);

        } catch (IOException ignore) {
            //do nothing
        }
    }

    private static void readRecord() {
        try (DataInputStream input = new DataInputStream(new FileInputStream(saveRecordFile))) {
            model.record = input.readInt();

        } catch (IOException ignore) {
            //do nothing
        }
    }
}