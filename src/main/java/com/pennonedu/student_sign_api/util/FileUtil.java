package com.pennonedu.student_sign_api.util;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.List;

/**
 * @author jishuai
 */
public class FileUtil {
    public static boolean checkFile(String src) {
        File file = new File(src);
        return file.exists();
    }

    public static boolean checkFiles(List<String> srcs) {
        for (String src : srcs) {
            System.out.println(src);
            File file = new File(src);
            if (!file.exists()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFiles(List<String> srcs, String filePrefix) {
        for (String src : srcs) {
//            System.out.println(getAbsolutePath(filePrefix, src));
            File file = new File(getAbsolutePath(filePrefix, src));

            if (!file.exists()) {
                return false;
            }
        }
        return true;
    }

    public static String getAbsolutePath(String prefix, String src) {
        return prefix + src;
    }
}
