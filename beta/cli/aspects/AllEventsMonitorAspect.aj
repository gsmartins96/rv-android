import java.io.*;
import java.util.*;
import java.lang.ref.*;
import org.aspectj.lang.*;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.database.CursorWrapper;

public aspect AllEventsMonitorAspect {
    public AllEventsMonitorAspect() {}

    after (Object o): (call(* Object+.*(..)) && target(o)) {
       Log.v("gRV-MONITOR:", "ALL EVENTS MONITOR ASPECT");
    }
}
