package io.archive;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * In this class all files from the specified directory add into zip.
 * to do this, use public method toZip(Dir dirname);
 */
public class Archivation {

    // zip file out.
    File fileOut;

    /**
     * Enter file out name and path.
     * @param fileOut
     */
    public Archivation(String fileOut) {
        // needed add check
        this.fileOut = new File(fileOut);
    }

    /**
     * In this method all files from the specified directory add into archive;
     */
    private void archivation(Path path) {

        try(DirectoryStream<Path> directories = Files.newDirectoryStream(path);
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(fileOut))) {
            for (Path p : directories) {

                // add into zipEntry
                ZipEntry zipEntry = new ZipEntry(p.toString());
                zout.putNextEntry(zipEntry);

                // create new stream for add file date.
                FileInputStream fileInputStream = new FileInputStream(p.toString());

                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);

                // add data into archive
                zout.write(buffer);

                // close streams
                fileInputStream.close();
                zout.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method toZip basis class and add in archive parent directory of project;
     * @param dir
     */
    public void toZip(String dir) {
        // create an object File;
        File file = new File(dir);

        // Get list of file
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                this.toZip(f.getAbsolutePath());
            } else {

                // replace
                String temp = this.replace(f.getAbsolutePath());
                if (temp.contains(this.getClass().getCanonicalName())) {
                    archivation(f.toPath().getParent());
                }
            }
        }
    }

    /**
     * This method replace System separator on "." in file path, or something else =)
     * @param str - string to replace
     * @return
     */
    private String replace(String str) {
        // file system separator is used; different for various systems.
        String fileSeparator = System.getProperty("file.separator");
        String result = str.replace(fileSeparator, ".");
        return result;
    }

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Archivation a = new Archivation("outFile.zip");
        a.toZip("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src");
    }
}

