import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class WriterCopyReader {
    private static String source = "E:\\TestTest\\est.txt";
    private static String dest = "E:\\TestTest\\est1.txt";
    private static String engPhrase = "Hello, it is the first time when i write into file by my program\n";
    private static String russPhrase = "Это первая запись в файл через IntelliJ IDEA через собственную программу";
    static final Charset WIN1251 = Charset.forName("WINDOWS-1251");

    public static void main(String[] args) throws IOException {

        writeIntoFile(source, engPhrase,russPhrase,WIN1251);
        copyFileUsingStream(source,dest);
        readFromFile(dest,WIN1251);
    }

    private static void copyFileUsingStream(String source, String dest) throws IOException {
        InputStream fis = new FileInputStream(source);
        OutputStream fos = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }

    private static void writeIntoFile(String source, String eng, String russ, Charset dEnc) throws IOException {
        FileOutputStream fos = new FileOutputStream(source);
        fos.write(eng.getBytes(StandardCharsets.UTF_8));
        fos.write(russ.getBytes(dEnc));
        fos.close();
    }

    private static void readFromFile(String source, Charset dEnc) throws IOException {
        Reader reader = new FileReader(source, dEnc);
        int i = 0;
        while ((i = reader.read()) != -1) {
            System.out.print((char) i);
        }
        reader.close();
    }
}
