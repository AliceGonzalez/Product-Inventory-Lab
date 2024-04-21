package io;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtility { //for CSV operations
    private static final char DEFAULT_SEPARATOR = ',';
    public static void  writeLine(Writer w, List<String> values) throws IOException {
        boolean first = true;

        StringBuilder str = new StringBuilder();
        for(String value : values) {
            if (!first) {
                str.append(DEFAULT_SEPARATOR);
                str.append(value);
                first = false;
            }
        }
        str.append("\n");
        w.append(str.toString());
    }
}
//Now go integrate CSV operations to Service classes
