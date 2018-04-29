package model.util;

import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class RelativeLocation {
    public static URL location(String file) throws IOException{
        ZipFile zipfile = new ZipFile(System.getProperty("java.class.path"));
        ZipEntry entry = zipfile.getEntry(file);            
        return ClassLoader.getSystemResource(entry.getName());
    }
}
