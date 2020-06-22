package utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import okhttp3.Request;
import okio.Buffer;
import org.testng.Reporter;

import java.io.IOException;

public class ReporterUtil {

    @Step("{0}")
    public static void reportTC(String tcName, String msg) {
        log(String.format(" Test: %s Status: %s", tcName, msg));
    }


    @Step("{0}")
    public static void log(String str) {
        Reporter.log(str, true);
    }

    public static String bodyToString(final Request request) {

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            if (copy.body() != null) {
                copy.body().writeTo(buffer);
            }
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
