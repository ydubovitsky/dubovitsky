package io.archive;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * In this class all files add in zip.
 */
public class Archivation {

    // zip file out.
    File fileOut;

    public Archivation(String fileOut) {
        // needed add check
        this.fileOut = new File(fileOut);
    }

    /**
     * In this method all files from path add into archive
     * @param path
     */
    private void getDirectories(Path path) {

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

    public static void main(String[] args) throws IOException {
        Archivation archivation = new Archivation("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\archive\\outfile.zip");
        archivation.getDirectories(Paths.get("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\archive"));
    }
}
