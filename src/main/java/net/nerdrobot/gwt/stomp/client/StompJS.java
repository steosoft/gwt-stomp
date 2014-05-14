package net.nerdrobot.gwt.stomp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class StompJS {
    protected interface JsClientBundle extends ClientBundle {
        JsClientBundle INSTANCE = GWT.create(JsClientBundle.class);

        @Source("stomp.js")
        TextResource stompjs();

        @Source("sockjs.js")
        TextResource sockjs();
    }

    private static boolean installed = false;

    private StompJS() {
    }

    public static void install() {
        if (!installed) {
            /* inject sockjs and stompjs */
            ScriptInjector.fromString(JsClientBundle.INSTANCE.sockjs().getText()).setWindow(ScriptInjector.TOP_WINDOW)
                    .inject();
            ScriptInjector.fromString(JsClientBundle.INSTANCE.stompjs().getText()).setWindow(ScriptInjector.TOP_WINDOW)
                    .inject();

            installed = true;
        }
    }

}