package zinoviy23.simpledb4java;

import java.io.*;

public class FileUtils {
    public static void createDirectory(String name) {
        File file = new File(System.getProperty("user.dir") + "/" + name);
        boolean creationDirectoryResult = file.mkdir();
        if (!creationDirectoryResult && !file.exists()) {
            throw new RuntimeException("Can't create directory.");
        }
    }

    public static void copyFiles(String fileName, String destinationPath) throws IOException {
        File source = new File(fileName);
        File dest = new File(destinationPath);

        try (InputStream is = new FileInputStream(source); OutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    public static void copyFormat(String fileName, String destinationPath, Object... args) throws IOException {
        File source = new File(fileName);
        File dest = new File(destinationPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(dest)) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            writer.print(String.format(sb.toString(), args));
        }
    }

    public static void writeToFile(String fileName, String string) throws IOException {
        File dest = new File(fileName);

        try (PrintWriter writer = new PrintWriter(dest)) {
            writer.print(string);
        }
    }
}
