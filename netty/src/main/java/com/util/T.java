package com.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class T {

    public static void main(String[] args)  {
        String rootPath = File.separator.equals("\\") ? "E:\\myProjects\\netty\\src\\main\\resources\\file":"/data/file";
        final File file = FileUtils.getFile(rootPath, "a", "b","c");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtils.deleteQuietly(file);
        System.out.println(file);
    }
}
